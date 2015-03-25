  
/**  
 * �ļ�����MenuController.java  
 *   
 * ���ڣ�2015��3��20��  
 *  
*/  
    
package com.itxxz.blog.menu.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itxxz.blog.menu.service.MenuService;

  
/**  
 * 
 * @author: ITѧϰ��-�з
 * 
 * @���� www.itxxz.com
 *
 * @version: 2015��3��20�� ����5:21:52   
 */
@Controller
@RequestMapping("admin")
public class MenuController {

	@Autowired
	MenuService menuService;
	
	@RequestMapping("menuList")
	public String showAllMenuList(Model model){
		model.addAttribute("menuList", menuService.findAllMenus());
		return "admin/menuList";
	}
	@RequiresPermissions("menu:create") 
	@RequestMapping("create")
	public String createMenu(Model model){
		System.out.println("������Ӳ˵�");
		model.addAttribute("menuList", menuService.findAllMenus());
		return "admin/menuList";
	}
	@RequiresPermissions("menu:delete") 
	@RequestMapping("delete")
	public String deleteMenu(Model model){
		System.out.println("����ɾ���˵�");
		model.addAttribute("menuList", menuService.findAllMenus());
		return "admin/menuList";
	}
}
