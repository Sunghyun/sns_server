package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Article;
import model.FrInfo;
import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.MemberService;
import validator.MemberValidator;

@Controller
public class MemberController {
	private String view = "redirect:/";
	private MemberService service;

	public MemberService getService() {
		return service;
	}

	public void setService(MemberService service) {
		this.service = service;
	}

	@RequestMapping(value = "/regist.do")
	public String form() {
		return "joinForm";
	}

	@RequestMapping(value = "/insert.do")
	public String insert(@ModelAttribute("member") Member m,
			BindingResult result) {
		new MemberValidator().validate(m, result);
		if (result.hasErrors()) {
			return "joinForm";
		}

		if (!service.idCheck(m.getId())) {
			result.rejectValue("id", "idcheck");
			return "joinForm";
		}
		service.insert(m);
		return "loginForm";
	}
	
	@RequestMapping(value = "/loginForm.do")
	public String loginForm() {
		return "loginForm";
	}
	
	@RequestMapping(value = "/login.do")
	public ModelAndView login(@RequestParam("id") String id, 
			@RequestParam("pwd") String pwd, HttpSession session) {
		String query = null;
		ModelAndView mav = new ModelAndView();		
		if(service.login(id, pwd)){
			session.setAttribute("id", id);
			query = "list.do";
		}else{
			query = "loginForm.do";
		}
		mav.setViewName(view+query);
		return mav;
	}
	
	@RequestMapping(value = "/logout.do")
	public ModelAndView logout(HttpServletRequest request) {
		String query = "loginForm.do";
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("id")!=null){
			session.invalidate();
		}
		mav.setViewName(view+query);
		return mav;
	}
	
	@RequestMapping(value = "/out.do")
	public ModelAndView out(@RequestParam("pwd") String pwd, 
			HttpServletRequest request) {
		String query = null;
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession(false);
		String id = null;
		boolean flag = false;
		if(session == null){			
			query = "loginForm.do";
			mav.setViewName(view+query);
			return mav;
		}else{
			id = (String)session.getAttribute("id");
			if(id != null){
				flag = service.login(id, pwd);
			}
			if(flag){
				service.delete(id);
				query = "logout.do";
				mav.setViewName(view+query);
				return mav;
			}else{
				mav.setViewName("result");
				mav.addObject("msg", "비밀번호가 틀립니다.");
				return mav;
			}			
		}	
	}
	
	@RequestMapping(value = "/updateForm.do")
	public ModelAndView updateForm(HttpServletRequest request) {
		String query = null;
		ModelAndView mav = new ModelAndView();
		Member m = null;
		HttpSession session = request.getSession(false);
		if(session == null){
			query = "loginForm.do";
			mav.setViewName(view+query);
		}else if(session.getAttribute("id")==null){
			query = "loginForm.do";
			mav.setViewName(view+query);
		}else{
			m = service.select((String)session.getAttribute("id"));
			query = "updateForm";
			mav.setViewName(query);
			mav.addObject("member", m);
		}		
		return mav;
	}
	
	@RequestMapping(value = "/update.do")
	public ModelAndView update(Member m) {
		String query = null;
		ModelAndView mav = new ModelAndView();
		service.update(m);
		query = "list.do";
		mav.setViewName(view+query);
		return mav;
	}
	
//	@RequestMapping(value = "/list.do")
//	public String list(HttpServletRequest req) {
//		return "list";
//	}
}
