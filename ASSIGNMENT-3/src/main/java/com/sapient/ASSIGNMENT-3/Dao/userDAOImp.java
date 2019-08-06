package com.sapient.assessment3.Dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.assessment3.model.*;

@Transactional
@Repository("hibernateDAOImp")
public class userDAOImp implements UserDAO{

    @Autowired
    private SessionFactory sessionFactory;
    
	public void saveUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		
	}

	public List<User> listAll() {
				Session session=sessionFactory.getCurrentSession();
		return session.createQuery("from User").list();
	}

	public User findById(long id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	public void update(long id, User user) {
		
	}

	public void deleteuser(long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.byId(User.class).load(id);
        session.delete(user);
	}

	public List<Posts> findPostById(long id) {
		return sessionFactory.getCurrentSession().get(User.class, id).getPosts();
	}

	public Posts findPostByIdById(long id, long pid) {
		List<Posts> plist= sessionFactory.getCurrentSession().get(User.class, id).getPosts();
		for(Posts p: plist)
		{
			if(p.getId()==pid)
				return p;
		}
			return null;
	}

	public void putPostById(long id, List<Posts> posts) {
		User user=sessionFactory.getCurrentSession().get(User.class, id);
		List<Posts> plist= user.getPosts();
		plist.addAll(posts);
	}

	public void deletepost(long id)
	{
		Session session = sessionFactory.getCurrentSession();
		User user = findById(id);
		for (Posts post : user.getPosts()) {
			session.delete(post);
		}
		user.setPosts(null);
		session.saveOrUpdate(user);
		
	}

	public void update(User user) {
		User user1 = findById(user.getId());
		Session session = sessionFactory.getCurrentSession();
		if (user.getName() == null)
			user.setName(user1.getName());

	}

}
