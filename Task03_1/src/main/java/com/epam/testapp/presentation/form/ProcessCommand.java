package com.epam.testapp.presentation.form;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.testapp.model.News;
import com.epam.testapp.util.NewsService;

@Controller
@RequestMapping("/News")
public class ProcessCommand {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping("/NewsListForm")
	public String showPage(@Valid @ModelAttribute("news") News news, BindingResult theBindingResult, Model theModel) {
							     	     
		theModel.addAttribute("newsList", newsService.getList());
		
		return "newsList";
	}
	
	@RequestMapping("/showNews")
	public String show(@Valid @ModelAttribute("news") News news, BindingResult theBindingResult, Model theModel) {
			
		theModel.addAttribute("news", newsService.fetchById(news.getId()));
		
		return "newsView";
	}
	
	@RequestMapping("/addNewsForm")
	public String addNews(@Valid @ModelAttribute("news") News news, BindingResult theBindingResult, Model theModel) {
			
		System.out.println(news.getId());	
		if(news.getId() != 0) {					
			theModel.addAttribute("news", newsService.fetchById(news.getId()));	
		}
		
		return "addNews";
	}

}
