package com.emega.mart.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.emega.mart.model.UserLogin;

public interface LoginRepository extends CrudRepository<UserLogin, Long> {
	
	@Query(value="SELECT * FROM USER_LOGIN WHERE USER_NAME= ?1 AND USER_PASSWORD= ?2",nativeQuery=true)
	public UserLogin doLogin(Long userId,String password);
}
