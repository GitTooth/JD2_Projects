package com.epam.testapp.form;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexPageCommand {
	
	@RequestMapping("/")
	public String showNewsList(Model theModel) {
		return "redirect:"+LocaleContextHolder.getLocale()+"/NewsListForm";
	}

}