package com.epam.testapp.util;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.epam.testapp.model.News;

@Repository
public class NewsDAOImpl implements NewsDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	public List<News> getList() {
		Session session = sessionFactory.getCurrentSession();
				
		List<News> newsList = session.createQuery("FROM News ORDER BY date", News.class).list();
		
		Collections.reverse(newsList);
		
		return newsList;
	}

	public void save(News theNews) {
		Session session = sessionFactory.getCurrentSession();
				
		session.saveOrUpdate(theNews);
		
	}

	public News fetchById(int theId) {
		Session session = sessionFactory.getCurrentSession();
		
		News theNews = session.get(News.class, theId);
		
		return theNews;
	}

	public void remove(int theId) {
			Session session = sessionFactory.getCurrentSession();
			
			Query theQuery = session.createQuery("delete from News where id=:newsId");
			theQuery.setParameter("newsId", theId);
			
			theQuery.executeUpdate();	
		
	}
	
}
