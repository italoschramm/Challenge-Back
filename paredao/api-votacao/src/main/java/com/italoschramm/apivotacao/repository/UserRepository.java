package com.italoschramm.apivotacao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.italoschramm.apivotacao.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	@Query(value = "SELECT * FROM USER WHERE USERNAME = :username", nativeQuery = true)
	public User findByUserLogin(@Param("username") String username);
	
	@Query(value = "SELECT * FROM USER WHERE USERNAME = :username AND PASSWORD = :password", nativeQuery = true)
	public User findByLoginPassword(@Param("username") String username, @Param("password") String password);
}
