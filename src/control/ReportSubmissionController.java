package control;

import java.io.File;

import model.FileModel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import service.FileService;

@Controller
public class ReportSubmissionController {

	private FileService service;
	private FileModel m;

	public FileService getService() {
		return service;
	}

	public void setService(FileService service) {
		this.service = service;
	}


	@RequestMapping(value = "/report/submitReport1.do", method = RequestMethod.POST)
	public String submitReport1(
			@RequestParam("id") String id,
			@RequestParam("report") MultipartFile report) {
		
		System.out.println("파일 업로드 중 ");

		String fileName = report.getOriginalFilename();
		String path = "C:\\img\\" + fileName;

		File f = new File(path); // 파일 만듦 이게 저장하려고 하는것
		try {
			report.transferTo(f); // 복사
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//id 파일이름 위치
		m = new FileModel(id,fileName,path);
		service.insert(m);
		
		return "redirect:/filelist.do";
	}


}
