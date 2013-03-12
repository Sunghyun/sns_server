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

import service.BoardService;
import service.FrService;
import service.MemberService;
import validator.MemberValidator;

@Controller
public class MemberController {
	private String view = "redirect:/";
	private MemberService service;
	private FrService fservice;
	private BoardService bservice;
	
	public BoardService getBservice() {
		return bservice;
	}

	public void setBservice(BoardService bservice) {
		this.bservice = bservice;
	}

	public FrService getFservice() {
		return fservice;
	}

	public void setFservice(FrService fservice) {
		this.fservice = fservice;
	}

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
		mav.addObject("temp","1");   // 처음  list.jps 에 자료실을 나타내기 위해.
		System.out.println(id);
		System.out.println(pwd);
		
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
	//	System.out.println("==============logout==============="+session.getAttribute("id"));
		
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
	//	System.out.println("=================hiijong===============");
		ArrayList<String> idList = new ArrayList<String>();
	
	//	System.out.println("==============out==============="+session.getAttribute("id"));
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
				/*=============================================*/
				id = (String)session.getAttribute("id");
				//System.out.println("==============out: id가 있긴 한가==============="+id);
				idList = fservice.getFrList_del(id);
				//System.out.println("==============out: id불러오긴하나==============="+id);
				idList.add(id);
				for(int i =0; i<idList.size()-1; i++){
					fservice.delFr(id, idList.get(i));
				}
				/*=============================================*/
				bservice.delete_id(id);
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
		//System.out.println("==============update==============="+session.getAttribute("id"));
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
