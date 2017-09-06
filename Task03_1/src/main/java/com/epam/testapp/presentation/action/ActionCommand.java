package com.epam.testapp.presentation.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.testapp.model.News;
import com.epam.testapp.util.NewsService;

@Controller
@RequestMapping("/News")
public class ActionCommand {
	
	@Autowired
	private NewsService newsService;
	
	 @InitBinder
	 public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
	     final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
	     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
	 }

	@RequestMapping("/update")
	public String updateNews(@Valid @ModelAttribute("news") News news, BindingResult theBindingResult, Model theModel) {
						
	    newsService.save(news);
		
		return "redirect:/News/NewsListForm";
	}
	
	@RequestMapping("/delete")
	public String deleteNews(@Valid @ModelAttribute("news") News news, BindingResult theBindingResult, Model theModel) {
		
		newsService.remove(news.getId());
		
		return "redirect:/News/NewsListForm";
	}
	
	@RequestMapping("/cancel")
	public String cancel() {		
		return "redirect:/News/NewsListForm";
	}
}
