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
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.testapp.model.News;
import com.epam.testapp.util.NewsService;

@Controller
@RequestMapping("/News")
public class ActionCommand {
	
	@Autowired
	private NewsService newsService;
	
	 @InitBinder
	 public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
	     final SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy", locale);
	     binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));    
	 }

	@RequestMapping("/update")
	public String updateNews(@Valid @ModelAttribute("news") News news, BindingResult theBindingResult, Model theModel) {
						
	    newsService.save(news);
		
		return "redirect:/News/showNews/"+news.getId();
	}
	
	@RequestMapping("/delete")
	public String deleteNews(@Valid @ModelAttribute("news") News news, BindingResult theBindingResult, Model theModel) {
		
		newsService.remove(news.getId());
		
		return "redirect:/News/NewsListForm";
	}
	
	@RequestMapping("/deleteList")
	public String deleteNewsList(@RequestParam("Btn002") int[] checkedIds, Model theModel) {
		
		for(int i = 0; i < checkedIds.length; i++) {
			newsService.remove(checkedIds[i]);
		}
				
		return "redirect:/News/NewsListForm";
	}
	
	@RequestMapping("/cancel")
	public String cancel() {		
		return "redirect:/News/NewsListForm";
	}
}
