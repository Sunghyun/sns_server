package control;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.FileModel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import service.FileService;

@Controller
public class DownloadController {

	private String path = "C:\\img\\";
	private FileService service;
	private FileModel m;
	
	public FileService getService() {
		return service;
	}

	public void setService(FileService service) {
		this.service = service;
	}
	
	@RequestMapping(value="/file.do")
	public ModelAndView download(@RequestParam(value = "list") String getlist, HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		File downloadFile = new File("C:\\img\\" + getlist);
		
		//System.out.println(getlist);
		
		return new ModelAndView("download", "downloadFile", downloadFile);
	}
	
	//mapping 에서 다른 do 함수로 가고 싶을시 redirect: 를 사용한다.
	@RequestMapping(value="/filedel")
	public ModelAndView filedel(@RequestParam(value="fid")String fid){
		ModelAndView mav = new ModelAndView("redirect:/filelist.do");
		String path = "C:\\img\\";
		
		//img 폴더안에 파일 삭제.
		File f = new File(path+fid);
		f.delete();
		
		service.delete(fid);
		
		return mav;
	}
	
	@RequestMapping(value="/filelist.do")
	public ModelAndView getFileList(HttpServletRequest req) {
//		String path="/report/";
		List<FileModel> data;		
		
		HttpSession session = req.getSession();
		String id = (String)session.getAttribute("id");
		
		System.out.println("id검사 " + id);
		
		data = service.selectfiles(id);	
		
		String list[] = new String[data.size()];
		
		
		for(int i=0;i<data.size();i++){
			 m = data.get(i);
			list[i] = m.getFid(); 
		}
		
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("filelist");
		return new ModelAndView("list","list", list);
	}
	
}
