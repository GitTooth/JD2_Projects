package com.epam.testapp.presentation.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.testapp.model.News;
import com.epam.testapp.presentation.form.ProcessCommand;

@Controller
@RequestMapping("/News")
public class ActionCommand {
	
	 @InitBinder
	 public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
	     final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
	     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
	 }

	@RequestMapping("/update")
	public String updateNews(@Valid @ModelAttribute("news") News news, BindingResult theBindingResult, Model theModel) {
		
		System.out.println(news.getId() + " " + news.getTitle() + " " + news.getDate() + " " + news.getBrief() + " " + news.getContent());
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(News.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {						    
		    session.beginTransaction();
		    if(news.getId() == 0) {
		    	session.save(news);
		    }else {
		    	session.update(news);
		    }
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
		ProcessCommand.showPage(news, theBindingResult, theModel);
		
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
		
		ProcessCommand.showPage(news, theBindingResult, theModel);
		
		return "newsList";
	}
}
