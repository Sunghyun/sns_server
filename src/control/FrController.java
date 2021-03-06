package control;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Article;
import model.FileModel;
import model.FrInfo;
import model.Member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.BoardService;
import service.FileService;
import service.FrService;
import service.MemberService;


@Controller
public class FrController {
	private FrService fservice;
	private MemberService mservice;
	private BoardService bservice;
	private FileService fileservice;
	
	private String temp="1";  // list.jsp 에서 글쓰기, 자료실 구분자로 사용할 변수 (초기값은 게시판부터 보기위해 1을 넣는다.)

	
	public FileService getFileservice() {
		return fileservice;
	}
	public void setFileservice(FileService fileservice) {
		this.fileservice = fileservice;
	}
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

	public MemberService getMservice() {
		return mservice;
	}

	public void setMservice(MemberService mservice) {
		this.mservice = mservice;
	}

	@RequestMapping(value = "/list.do")
	public ModelAndView list(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView("list");
		HttpSession session = req.getSession(false);
		temp = req.getParameter("temp");   // list 에서 하이퍼 링크로 1,2가 올시.. 게시판, 자료실을 구분하기 위해 사용
		String id = null;
		int sg = 0;
		ArrayList<Member> data = null;
		ArrayList<FrInfo> fList = null;
		ArrayList<Article> articles = null;
		ArrayList<String> idList = null;
		if (session != null && "1".equals(temp)) {
			id = (String) session.getAttribute("id");
			sg = mservice.select(id).getSg();
			data = fservice.getFr_sgList(sg, id);
			fList = fservice.getFrList(id);
			idList = fservice.getFrIdList(id);
			idList.add(id);
			articles = bservice.select(idList);
		}
		else if(session != null && "2".equals(temp)){
			ArrayList<FileModel> filem = null;
			
			id = (String) session.getAttribute("id");
			sg = mservice.select(id).getSg();
			data = fservice.getFr_sgList(sg, id);
			fList = fservice.getFrList(id);
			filem = (ArrayList<FileModel>) fileservice.selectfiles(id);
			mav.addObject("list", filem);
		}
		
		mav.addObject("data", data);
		mav.addObject("fdata", fList);
		mav.addObject("articles", articles);
		mav.addObject("temp",temp);
		
		return mav;
	}

	@RequestMapping(value = "/frInfo.do")
	public ModelAndView frInfo(@RequestParam("id") String id) {
		Member m = mservice.select(id);
		ModelAndView mav = new ModelAndView("frInfo");
		mav.addObject("m", m);
		return mav;
	}
	@RequestMapping(value = "/reqFr.do")
	public ModelAndView reqFr(HttpServletRequest req) {
		String fr_id = req.getParameter("id");
		String id = null;
		ModelAndView mav = new ModelAndView("redirect:/list.do");
		HttpSession session = req.getSession(false);
		if (session != null) {
			id = (String) session.getAttribute("id");
			fservice.reqFr(id, fr_id);
		}
		return mav;
	}
	
	@RequestMapping(value = "/addFr.do")
	public ModelAndView addFr(HttpServletRequest req) {
		String fr_id = req.getParameter("id");
		String id = null;
		ModelAndView mav = new ModelAndView("redirect:/list.do");
		HttpSession session = req.getSession(false);
		if (session != null) {
			id = (String) session.getAttribute("id");
			fservice.addFr(id, fr_id);
		}
		return mav;
	}
	
	@RequestMapping(value = "/delFr.do")
	public ModelAndView delFr(HttpServletRequest req) {
		String fr_id = req.getParameter("id");
		String id = null;
		ModelAndView mav = new ModelAndView("redirect:/list.do");
		HttpSession session = req.getSession(false);
		if (session != null) {
			id = (String) session.getAttribute("id");
			fservice.delFr(id, fr_id);
		}
		return mav;
	}
	@RequestMapping(value = "/searchFr.do")
	public ModelAndView searchFr(@RequestParam("id") String fr_id, 
			HttpServletRequest req) {
		
		System.out.println("검색을 실시 합니다.");
		
		String msg = null;
		String id = null;
		boolean flag = false;
		HttpSession session = req.getSession(false);
		Member m = mservice.select(fr_id);
		
		
		if(m==null){
			msg = "회원이 아닙니다.";
		}else{
			if (session != null) {
				id = (String) session.getAttribute("id");
				flag = fservice.getFr(id, fr_id);
			}
			
			if(flag){
				msg = "요청가능";
			}else{
				msg = "이미 친구임";
			}
			if(id.equals(fr_id)){
				flag = false;
				msg = "자신은 친구로 등록할 수 없음";
			}
			
		}
		ModelAndView mav = new ModelAndView("frInfo2");
		mav.addObject("flag", flag);
		mav.addObject("msg", msg);
		mav.addObject("m", m);
		return mav;
	}
}
