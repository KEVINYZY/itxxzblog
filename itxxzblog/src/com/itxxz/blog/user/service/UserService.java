  
/**  
 * �ļ�����UserService.java  
 *   
 * ���ڣ�2015��3��13��  
 *  
*/  
    
package com.itxxz.blog.user.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itxxz.blog.user.entity.User;
import com.itxxz.blog.user.mapper.UserMapper;

  
/**  
 * 
 * @author: ITѧϰ��-�з
 * 
 * @���� wwww.itxxz.comS
 *
 * @version: 2015��3��13�� ����4:28:15   
 */
@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
    //private PasswordHelper passwordHelper;
	
    /**
     * �����û�
     * @param user
     */
    public void createUser(User user) {
        //��������
    	String password_md5= new Md5Hash(user.getPwd(),user.getCredentialsSalt(),4).toHex();
    	user.setPwd(password_md5);
        userMapper.insert(user);
    }
	
	public User findByUserName(String userName){
		return userMapper.findByUserName(userName);
	}
	
	public List<User> findUsersByCondition(User user){
		return userMapper.findUsersByCondition(user);
	}
	
    /**
     * �����û����������ɫ
     * @param username
     * @return
     */
    public Set<String> findRoles(String username) {
        User user =findByUserName(username);
        Set<String> roleSet = new HashSet<String>();
        if(user == null) {
            //return Collections.EMPTY_SET;
        }
        roleSet.add("menu:list");
        roleSet.add("menu:create");
        roleSet.add("menu:update");
        roleSet.add("manager");
        roleSet.add("role");
        roleSet.add("good");
        return roleSet;
        //return roleMapper.findRoles(user.getRoleIds().toArray(new Long[0]));
    }

}
