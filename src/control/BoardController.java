package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Article;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.BoardService;

@Controller
public class BoardController {
	
	
	/*
	 * 
	 * 이것은 줘뚸 크레용
	 * 
	 * 
	 * 
	 * 
	 */
	private BoardService bservice;

	public BoardService getBservice() {
		return bservice;
	}

	public void setBservice(BoardService bservice) {
		this.bservice = bservice;
	}	
	
	@RequestMapping(value = "/writeForm.do")
	public String writeForm(){
		return "writeForm";
	}
	@RequestMapping(value = "/write.do")
	public ModelAndView reqFr(@RequestParam("content") String content, 
			HttpServletRequest req) {		
		String id = null;
		ModelAndView mav = new ModelAndView("redirect:/list.do");
		HttpSession session = req.getSession(false);
		Article a = new Article();
		if (session != null) {
			id = (String) session.getAttribute("id");
			a.setWriter_id(id);
			a.setContent(content);
			bservice.insert(a);
		}
		return mav;
	}
	
	@RequestMapping(value = "/editForm.do")
	public String editForm(Article a){
		return "editForm";
	}
	
	@RequestMapping(value = "/edit.do")
	public ModelAndView edit(Article a){
		bservice.update(a);
		ModelAndView mav = new ModelAndView("redirect:/list.do");
		return mav;
	}
	
	@RequestMapping(value = "/delAr.do")
	public ModelAndView delAr(Article a){
		bservice.delete(a.getNum());
		ModelAndView mav = new ModelAndView("redirect:/list.do");
		return mav;
	}
}
