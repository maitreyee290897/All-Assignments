package com.sapient.assessment3.service;
import com.sapient.assessment3.model.*;
import java.util.*;
public interface UserService {
	public void saveUser(User user);
	public List<User> listAll();
	public User findById(long id);
	public void update(long id, User user);
	public void deleteuser(long id); 
	public List<Posts> findPostById(long id);
	public Posts findPostByIdById(long id,long pid);
	public void putPostById(long id, List<Posts> post ) ;
	public void deletepost(long id); 
	public void update(User user);
}
