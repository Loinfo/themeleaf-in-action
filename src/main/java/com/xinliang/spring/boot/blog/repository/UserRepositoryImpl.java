package com.xinliang.spring.boot.blog.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.xinliang.spring.boot.blog.domain.User;

/**
 * User Repository
 * @author liangxin
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository{
	private static AtomicLong counter = new AtomicLong();
	private final ConcurrentMap<Long, User> userMap = new ConcurrentHashMap<>();
	
	@Override
	public User saveOrUpdateUser(User user) {
		Long id = user.getId();
		if(id == null) {
			id = counter.incrementAndGet();
			user.setId(id);
		}
		this.userMap.put(id, user);
		return user;
	}

	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		this.userMap.remove(id);
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return this.userMap.get(id);
	}

	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return new ArrayList<>(this.userMap.values());
	}

}
