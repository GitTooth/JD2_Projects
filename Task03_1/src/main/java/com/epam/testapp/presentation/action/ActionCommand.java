package com.epam.testapp.presentation.action;

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
public class ActionCommand {

	@RequestMapping("/update")
	public String updateNews(@Valid @ModelAttribute("news") News news, BindingResult theBindingResult, Model theModel) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(News.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {						    
		    session.beginTransaction();
			session.update(news);
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
		return "newsList";
	}
	
	@RequestMapping("/delete")
	public String deleteNews(@Valid @ModelAttribute("news") News news, BindingResult theBindingResult, Model theModel) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(News.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {						    
		    session.beginTransaction();
			session.delete(news);
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
		
		return "newsList";
	}
}
