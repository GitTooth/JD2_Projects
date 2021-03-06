package com.epam.testapp.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.epam.testapp.model.News;
import com.epam.testapp.service.NewsService;

@Controller
@RequestMapping("/{locale}")
public class ProcessCommand {
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping("/NewsListForm")
	public String showPage(Model theModel) {		
		theModel.addAttribute("newsList", newsService.getList());
		
		return "newsList";
	}
	
	@RequestMapping("/NewsListForm/{id}")
	public String show(@PathVariable("id") int id, Model theModel) {
		
		theModel.addAttribute("news", newsService.fetchById(id));
		
		return "newsView";
	}
	
	@RequestMapping("/addNewsForm/{id}")
	public String addNews(@PathVariable("id") int id, Model theModel) {
		
		if(id != 0) {					
			theModel.addAttribute("news", newsService.fetchById(id));	
		}else {
			theModel.addAttribute("news", new News());
		}
		
		return "addNews";
	}

}
