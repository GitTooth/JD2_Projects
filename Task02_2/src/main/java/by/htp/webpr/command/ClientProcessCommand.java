package by.htp.webpr.command;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import by.htp.webpr.domain.Client;
import by.htp.webpr.domain.Doctor;
import by.htp.webpr.domain.Messages;

@Controller
@RequestMapping("/client")
public class ClientProcessCommand {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showRegistrationForm")
	public String showForm(@ModelAttribute("doctor") Doctor theDoctor, Model theModel) {

		theModel.addAttribute("client", new Client());
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Doctor.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			List<Doctor> result = session.createQuery("SELECT name FROM Doctor").list();
		     
			session.getTransaction().commit();
		     
		    theModel.addAttribute("doctors", result);
		} finally {
			factory.close();
		}
		
		return "registration-form";
	}

	@RequestMapping("/processRegistrationForm")
	public String processForm(@Valid @ModelAttribute("client") Client theClient, BindingResult theBindingResult, Model theModel) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class)
				.addAnnotatedClass(Doctor.class).buildSessionFactory();
		Session session = factory.getCurrentSession();

		try {
			Client client = new Client(theClient.getName(), theClient.getSurname(), theClient.getTelephone());

			session.beginTransaction();

			System.out.println("Saving the client " + theClient.getName() + " " + theClient.getSurname() + " " + theClient.getTelephone() + " " );

			if (theBindingResult.hasErrors()) {
				return "registration-form";
			}
			
			session.save(client);
			session.getTransaction().commit();
			
			showListOfClientsPage(theClient, theBindingResult,theModel);
			
			Messages.message = "Client was successfully added";
			Messages.result = "success";
			
		} finally {
			factory.close();
		}
		
		return "clients-list-page";
		
	}
	
	@RequestMapping("/showClientsListPage")
	public String showListOfClientsPage(@Valid @ModelAttribute("client") Client theClient, BindingResult theBindingResult, Model theModel) {
				
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			List<Client> result = session.createQuery("FROM Client").list();
		     
			session.getTransaction().commit();
		     
		    theModel.addAttribute("clients", result);
		    		
		    Messages.message = "";
		} finally {
			factory.close();
		}
		return "clients-list-page";
	}
	
	@RequestMapping("/update")
	public String update(@Valid @ModelAttribute("client") Client newClient, BindingResult theBindingResult, Model theModel) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("UPDATE Client set "
					+ "name = :name, "
					+ "surname = :surname, "
					+ "telephone = :telephone "
					+ "WHERE id = :id"
				);
			
			query.setParameter("name", newClient.getName());
			query.setParameter("surname", newClient.getSurname());
			query.setParameter("telephone", newClient.getTelephone());
			query.setParameter("id", newClient.getId());
			
			query.executeUpdate();
			
			session.getTransaction().commit();
			
			showListOfClientsPage(newClient, theBindingResult,theModel); 
			
			Messages.message = "Client was successfully edited";
			Messages.result = "success";
		}catch(Exception e){
			Messages.message = e.getMessage();
			Messages.result = "danger";
		}finally {
			factory.close();
		}
		
		return "clients-list-page"; 
	}
	
	@RequestMapping("/delete")
	public String delete(@Valid @ModelAttribute("client") Client theClient, BindingResult theBindingResult, Model theModel) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery("DELETE FROM Client "
					+ "WHERE id = :id"
				);
			
			System.out.println(theClient.getId());
			
			query.setParameter("id", theClient.getId());
			
			query.executeUpdate();
			
			session.getTransaction().commit();
			
			showListOfClientsPage(theClient, theBindingResult, theModel); 
			
			Messages.message = "Client was successfully removed";
			Messages.result = "success";
		}catch(Exception e){
			Messages.message = e.getMessage();
			Messages.result = "danger";
		}finally {
			factory.close();
		}
		return "clients-list-page"; 
	}
	
	@RequestMapping("/agreement-page")
	public String agreementForm() {
		return "agreement-page";
	}

}
