package download;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

public class DownloadView extends AbstractView {

	public DownloadView() {
		setContentType("application/download; charset=utf-8");  //
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		File file = (File) model.get("downloadFile");  // input stream  output stream 
		
		response.setContentType(getContentType());
		response.setContentLength((int) file.length());

		String userAgent = request.getHeader("User-Agent");
		boolean ie = userAgent.indexOf("MSIE") > -1;   //exeplore 인지 다른 브라우저인지 체크하는 곳.
		String fileName = null;
		
		if (ie) {
			fileName = URLEncoder.encode(file.getName(), "utf-8");
		} else {
			fileName = new String(file.getName().getBytes("utf-8"),
					"iso-8859-1");
		}
		
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ fileName + "\";");   // attachment filename 파일 붙이는곳??-_-..... 다운로드 창에 나올 파일을... 설정 한다.
		
		response.setHeader("Content-Transfer-Encoding", "binary");
		OutputStream out = response.getOutputStream();    //response  outputStream..  
		FileInputStream fis = null;
		try {
		
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
		} finally {
			if (fis != null)
				try {
					fis.close();
				} catch (IOException ex) {
				}
		}
		out.flush();
	}

}
