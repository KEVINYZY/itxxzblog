  
/**  
 * �ļ�����NavbarController.java  
 *   
 * ���ڣ�2015��3��18��  
 *  
*/  
    
package com.itxxz.blog.navbar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itxxz.blog.navbar.service.NavbarService;

  
/**  
 * 
 * @author: ITѧϰ��-�з
 * 
 * @���� www.itxxz.com
 *
 * @version: 2015��3��18�� ����5:04:05   
 */
@Controller
public class NavbarController {
	
	@Autowired
	private NavbarService navbarService;

}
