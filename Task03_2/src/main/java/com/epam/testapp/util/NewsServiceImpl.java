package com.epam.testapp.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.testapp.model.News;

@Service
public class NewsServiceImpl implements NewsService{
	@Autowired
	private NewsDAO newsDAO;
	
	@Transactional
	public List<News> getList() {
		return newsDAO.getList();
	}
	
	@Transactional
	public void save(News theNews) {
		
		System.out.println(theNews.getId() + " " + theNews.getTitle() + " " + theNews.getDate() + " " + theNews.getBrief() + " " + theNews.getContent());
		
		newsDAO.save(theNews);
	}

	@Transactional
	public News fetchById(int theId) {
		
		return newsDAO.fetchById(theId);
	}

	@Transactional
	public void remove(int theId) {
		
		newsDAO.remove(theId);
	}
}