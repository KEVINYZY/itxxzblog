package com.itxxz.blog.user.mapper;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itxxz.blog.user.entity.User;
import com.itxxz.framework.base.BaseMapper;

/**
 * ������Ա�ӿ���
 * 
 * @author: ITѧϰ��-�з
 * 
 * @���� www.itxxz.com
 *
 * @version: 2015��3��9�� ����4:03:30
 */
@Repository("userMapper")
public interface UserMapper extends BaseMapper<User>{	
	
	/**
	 * ���ݵ�½�˺Ų�ѯ
	 * 
	 * @author: ITѧϰ��-�з
	 * 
	 * @���� www.itxxz.com
	 * 
	 * @version: 2015��3��10�� ����9:58:31
	 */
	public User findByUserName(String userName);
	
	/**
	 * ��ѯ����users
	 * 
	 * @author: ITѧϰ��-�з
	 * 
	 * @���� www.itxxz.com
	 * 
	 * @���� www.itxxz.com
	 * 
	 * @version: 2015��3��10�� ����9:58:42
	 */
	public List<User> findUsersByCondition(User user);
	
	/**
	 * ��ѯ�û�����
	 * 
	 * @author: ITѧϰ��-�з
	 * 
	 * @���� www.itxxz.com
	 * 
	 * @version: 2015��3��12�� ����4:04:41
	 */
	public int selectUsersTotalCount();
}