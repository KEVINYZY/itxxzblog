  
/**  
 * �ļ�����Upload.java  
 *   
 * ���ڣ�2015��3��20��  
 *  
*/  
    
package com.itxxz.blog.pictrue.entity;

import java.util.HashMap;

  
/**  
 * 
 * @author: ITѧϰ��-�з
 * 
 * @���� www.itxxz.com
 *
 * @version: 2015��3��20�� ����10:23:16   
 */

public class Upload {

	// ����ļ���ַ
	private String url = "";
	// �ϴ��ļ���
	private String fileName = "";
	// ״̬
	private String state = "";
	// �ļ�����
	private String type = "";
	// ԭʼ�ļ���
	private String originalName = "";
	// �ļ���С
	private long size = 0;
	
	private HashMap<String, String> errorInfo = new HashMap<String, String>();
	
	public Upload() {
		HashMap<String, String> tmp = this.errorInfo;
		tmp.put("SUCCESS", "SUCCESS"); //Ĭ�ϳɹ�
		tmp.put("NOFILE", "δ�����ļ��ϴ���");
		tmp.put("TYPE", "��������ļ���ʽ");
		tmp.put("SIZE", "�ļ���С��������");
		tmp.put("ENTYPE", "��������ENTYPE����");
		tmp.put("REQUEST", "�ϴ������쳣");
		tmp.put("IO", "IO�쳣");
		tmp.put("DIR", "Ŀ¼����ʧ��");
		tmp.put("UNKNOWN", "δ֪����");
		
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}

	public HashMap<String, String> getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(HashMap<String, String> errorInfo) {
		this.errorInfo = errorInfo;
	}
	
}
