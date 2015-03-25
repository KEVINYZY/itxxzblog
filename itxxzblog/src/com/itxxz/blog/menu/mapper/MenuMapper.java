  
/**  
 * �ļ�����MenuMapper.java  
 *   
 * ���ڣ�2015��3��20��  
 *  
*/  
    
package com.itxxz.blog.menu.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.itxxz.blog.menu.entity.MenuInfo;
import com.itxxz.framework.base.BaseMapper;

  
/**  
 * 
 * @author: ITѧϰ��-�з
 * 
 * @���� www.itxxz.com
 *
 * @version: 2015��3��20�� ����5:22:38   
 */
@Repository("menuMapper")
public interface MenuMapper extends BaseMapper<MenuInfo>{
	public List<MenuInfo> findPageByCondition(MenuInfo menu, RowBounds rb);
}
