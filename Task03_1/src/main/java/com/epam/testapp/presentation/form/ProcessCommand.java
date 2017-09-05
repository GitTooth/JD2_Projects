package com.epam.testapp.presentation.form;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.testapp.model.News;

@Controller
@RequestMapping("/News")
public class ProcessCommand {
	
	@RequestMapping("/NewsListForm")
	public String showPage(@Valid @ModelAttribute("news") News news, BindingResult theBindingResult, Model theModel) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(News.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {						    
		    session.beginTransaction();
			Query query = session.createQuery("FROM News");
		     
			List<News> newsList = query.list();
			session.getTransaction().commit();
		     
		    theModel.addAttribute("newsList", newsList);
			
		} finally {
			factory.close();
		}
		
		return "newsList";
	}
	
	@RequestMapping("/showNews")
	public String show(@Valid @ModelAttribute("news") News news, BindingResult theBindingResult, Model theModel) {
							
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(News.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		System.out.println(news.getId());
		
		try {						    
		    session.beginTransaction();
			News res = session.get(News.class, news.getId());
			session.getTransaction().commit();
		    
			System.out.println(res.getTitle());
			
		    theModel.addAttribute("news", res);
			
		} finally {
			factory.close();
		}
		
		return "newsView";
	}
	
	@RequestMapping("/addNewsForm")
	public String addNews(@Valid @ModelAttribute("news") News news, BindingResult theBindingResult, Model theModel) {
			
		
		if(news.getId() != 0) {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(News.class).buildSessionFactory();
			
			Session session = factory.getCurrentSession();
			
			System.out.println(news.getId());
			
			try {						    
			    session.beginTransaction();
				News res = session.get(News.class, news.getId());
				session.getTransaction().commit();
			    
				System.out.println(res.getTitle());
				
			    theModel.addAttribute("news", res);
				
			} finally {
				factory.close();
			}
		}
		
		return "addNews";
	}

}
