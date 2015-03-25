  
/**  
 * �ļ�����UploadController.java  
 *   
 * ���ڣ�2015��3��20��  
 *  
*/  
    
package com.itxxz.blog.pictrue.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadBase.InvalidContentTypeException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import sun.misc.BASE64Decoder;

  
/**  
 * 
 * @author: ITѧϰ��-�з
 * 
 * @���� www.itxxz.com
 *
 * @version: 2015��3��20�� ����10:22:44   
 */
@Controller
public class UploadController {
	
	
	/**
	 * ͼƬ�ϴ�
	 * 
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "imagesUploader")
	@ResponseBody
	public String imgUpload(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("upload") MultipartFile upload) throws IOException {
		System.out.println("uploadFileName:"+upload.getOriginalFilename());
		
StringBuilder result = new StringBuilder();

		response.setCharacterEncoding("utf-8");
		// CKEditor�ύ�ĺ���Ҫ��һ������
		String callback = request.getParameter("CKEditorFuncNum");
		String expandedName = ""; // �ļ���չ��
		String uploadContentType = upload.getContentType();
		System.out.println("uploadContentType:"+upload.getContentType());
		if (uploadContentType.equals("image/pjpeg")
				|| uploadContentType.equals("image/jpeg")) {
			// IE6�ϴ�jpgͼƬ��headimageContentType��image/pjpeg����IE9�Լ�����ϴ���jpgͼƬ��image/jpeg
			expandedName = ".jpg";
		} else if (uploadContentType.equals("image/png")
				|| uploadContentType.equals("image/x-png")) {
			// IE6�ϴ���pngͼƬ��headimageContentType��"image/x-png"
			expandedName = ".png";
		} else if (uploadContentType.equals("image/gif")) {
			expandedName = ".gif";
		} else if (uploadContentType.equals("image/bmp")) {
			expandedName = ".bmp";
		} else {
			result.append("<script type=\"text/javascript\">");
			result.append("window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",''," + "'�ļ���ʽ����ȷ������Ϊ.jpg/.gif/.bmp/.png�ļ���');");
			result.append("</script>");
			return result.toString();
		}
		if (upload.getSize() > 600 * 1024) {
			result.append("<script type=\"text/javascript\">");
			result.append("window.parent.CKEDITOR.tools.callFunction(" + callback
					+ ",''," + "'�ļ���С���ô���600k');");
			result.append("</script>");
			return result.toString();
		}

		InputStream is = upload.getInputStream();
		//ͼƬ�ϴ�·��
		String uploadPath = request.getSession().getServletContext().getRealPath("uploads");
		String fileName = java.util.UUID.randomUUID().toString(); // ����ʱ��+UUID�ķ�ʽ�漴����
		fileName += expandedName;
		File file = new File(uploadPath);
		if (!file.exists()) { // ���·�������ڣ�����
			file.mkdirs();
		}
		File toFile = new File(uploadPath, fileName);
		OutputStream os = new FileOutputStream(toFile);
		byte[] buffer = new byte[1024];
		int length = 0;
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
		is.close();
		os.close();

		// ����"ͼ��"ѡ�����ʾͼƬ  request.getContextPath()Ϊweb��Ŀ�� 
		result.append("<script type=\"text/javascript\">");
		result.append("window.parent.CKEDITOR.tools.callFunction(" + callback
				+ ",'" + request.getContextPath() + "/uploads/" + fileName + "','')");
		result.append("</script>");
		return result.toString();
	}

}
