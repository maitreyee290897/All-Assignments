package com.example.demo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
public interface UserDAO extends CrudRepository<User, Integer>{
	@Query("Select u from User u where u.user=?1 and u.pwd=?2")
	 User findUser(String name,String pwd);
}
