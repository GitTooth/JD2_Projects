package com.epam.testapp.presentation.form;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String show(@RequestParam("getId") int getId, Model theModel) {
			
		
		
		theModel.addAttribute("news", newsService.fetchById(getId));
		
		return "newsView";
	}
	
	@RequestMapping("/addNewsForm")
	public String addNews(@RequestParam("getId") int getId, Model theModel) {
			
		System.out.println(getId);	
		if(getId != 0) {					
			theModel.addAttribute("news", newsService.fetchById(getId));	
		}else {
			theModel.addAttribute("news", new News());
		}
		
		return "addNews";
	}

}
