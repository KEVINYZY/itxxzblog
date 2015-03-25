  
/**  
 * �ļ�����MenuService.java  
 *   
 * ���ڣ�2015��3��20��  
 *  
*/  
    
package com.itxxz.blog.menu.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itxxz.blog.menu.entity.MenuInfo;
import com.itxxz.blog.menu.mapper.MenuMapper;

  
/**  
 * 
 * @author: ITѧϰ��-�з
 * 
 * @���� www.itxxz.com
 *
 * @version: 2015��3��20�� ����10:31:09   
 */
@Service
public class MenuService {

	@Autowired
	MenuMapper menuMapper;
	
	public List<MenuInfo> findAllMenus(){
		List<MenuInfo> allList = menuMapper.findAll();
		MenuInfo test = new MenuInfo();
		RowBounds rb = new RowBounds(test.getStartIndex(), test.getPageSize());
		menuMapper.findPageByCondition(test, rb);
		List<MenuInfo> menuList = new ArrayList<MenuInfo>();
		for(int i=0;i<allList.size();i++){
			if(allList.get(i).getUid()==0){
				menuList.add(allList.get(i));
			}
			for(int j=0;j<allList.size();j++){
				if(allList.get(i).getId()==allList.get(j).getUid()){
					allList.get(i).getChildMenuList().add(allList.get(j));
				}
			}
		}
		return menuList;
	}
	
	public List<MenuInfo> selectUsersByEntity(MenuInfo menu){
		RowBounds rb = new RowBounds(menu.getStartIndex(), menu.getPageSize());
		return menuMapper.findPageByCondition(menu,rb);
	}
}
