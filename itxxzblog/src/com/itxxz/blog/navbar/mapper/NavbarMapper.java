  
/**  
 * �ļ�����NavbarMapper.java  
 *   
 * ���ڣ�2015��3��18��  
 *  
*/  
    
package com.itxxz.blog.navbar.mapper;

import org.springframework.stereotype.Repository;

import com.itxxz.blog.navbar.entity.Navbar;
import com.itxxz.framework.base.BaseMapper;

  
/**  
 * 
 * @author: ITѧϰ��-�з
 * 
 * @���� www.itxxz.com
 *
 * @version: 2015��3��18�� ����5:04:31   
 */
@Repository("navbarMapper")
public interface NavbarMapper  extends BaseMapper<Navbar>{
	public Navbar findByNavId(int navId);

}
