package com.xinliang.spring.boot.blog.repository;

import java.util.List;

import com.xinliang.spring.boot.blog.domain.User;

/**
 * User Repository接口
 * @author liangxin
 *
 */
public interface UserRepository {
	/**
	 * 用于保存及修改用户
	 * @param user
	 * @return
	 */
	User saveOrUpdateUser(User user);
	
	/**
	 * 删除用户
	 * @param id
	 */
	void deleteUser(Long id);
	
	/**
	 * 根据id来查询用户
	 * @param id
	 * @return
	 */
	User getUserById(Long id);
	
	/**
	 * 获取用户列表
	 * @return
	 */
	List<User> listUser();
}
