  
/**  
 * �ļ�����LoginController.java  
 *   
 * ���ڣ�2015��3��14��  
 *  
*/  
    
package com.itxxz.blog.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

  
/**  
 * 
 * @author: ITѧϰ��-�з
 * 
 * @���� www.itxxz.com
 *
 * @version: 2015��3��14�� ����12:01:45   
 */

@Controller
public class LoginController {
	
	private static transient final Logger log = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login")
    public String showLoginForm(HttpServletRequest req) {
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = "";
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "�˻�������";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "�û���/�������";
        }else if(exceptionClassName != null) {
            error = "��������" + exceptionClassName;
        }
        log.info(error);
        
        return "login";
    }


}
