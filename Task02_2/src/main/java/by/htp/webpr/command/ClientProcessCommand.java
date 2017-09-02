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
	public String showForm(Model theModel) {

		theModel.addAttribute("client", new Client());
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class).addAnnotatedClass(Doctor.class)
				.buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			List<String> result = session.createQuery("SELECT name FROM Doctor").list();
		     
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
			
			session.beginTransaction();
			
			Doctor doctor = (Doctor)session.createQuery("FROM Doctor WHERE name = '" + theClient.getDoctor().getName() + "'").list().get(0);
			session.getTransaction().commit();
			System.out.println(doctor.getName() + " " + doctor.getId());
			
			session = factory.openSession();
			session.beginTransaction();
			Client client = new Client(theClient.getName(), theClient.getSurname(), theClient.getTelephone(), doctor);

			System.out.println("Saving the client " + theClient.getName() + " " + theClient.getSurname() + " " + theClient.getTelephone() + " " + theClient.getDoctor().getName());

			if (theBindingResult.hasErrors()) {
				return "registration-form";
			}

			session.save(client);
			
			System.out.println("saved");
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
				.addAnnotatedClass(Doctor.class).buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			List<Client> result = session.createQuery("FROM Client").list();
		     
			session.getTransaction().commit();
		     
		    theModel.addAttribute("clients", result);
		    
		    session.beginTransaction();
			List<String> doctors = session.createQuery("SELECT name FROM Doctor").list();
		     
			session.getTransaction().commit();
		     
		    theModel.addAttribute("doctors", doctors);
		    		
		    Messages.message = "";
		} finally {
			factory.close();
		}
		return "clients-list-page";
	}
	
	@RequestMapping("/update")
	public String update(@Valid @ModelAttribute("client") Client newClient, BindingResult theBindingResult, Model theModel) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class)
				.addAnnotatedClass(Doctor.class).buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Doctor doctor = (Doctor)session.createQuery("FROM Doctor WHERE name = '" + newClient.getDoctor().getName() + "'").list().get(0);
			
			System.out.println("Doctor: " + newClient.getDoctor().getName());
						
			session.getTransaction().commit();
			
			session = factory.openSession();
			session.beginTransaction();
			
			newClient.setDoctor(doctor);
			
			if (theBindingResult.hasErrors()) {
				showListOfClientsPage(newClient, theBindingResult, theModel);
			}
			
			session.update(newClient);
						
			session.getTransaction().commit();
			
			showListOfClientsPage(newClient, theBindingResult, theModel); 
			
			Messages.message = "Client was successfully edited";
			Messages.result = "success";
		}catch(Exception e){
			Messages.message = "Failed while trying to edit";
			Messages.result = "danger";
		}finally {
			factory.close();
		}
		
		return "clients-list-page"; 
	}
	
	@RequestMapping("/delete")
	public String delete(@Valid @ModelAttribute("client") Client theClient, BindingResult theBindingResult, Model theModel) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Client.class)
				.addAnnotatedClass(Doctor.class).buildSessionFactory();
		
		Session session = factory.openSession();
		
		try {			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			session.delete(theClient);
						
			System.out.println(theClient.getId());
			
			session.getTransaction().commit();
			
			showListOfClientsPage(theClient, theBindingResult, theModel); 
			
			Messages.message = "Client was successfully removed";
			Messages.result = "success";
		}catch(Exception e){
			Messages.message = "Failed while trying to remove";
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
