package com.epam.testapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.testapp.dao.NewsDAO;
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
		
		System.out.println("Saving: " + theNews.getId() + " " + theNews.getTitle() + " " + theNews.getDate() + " " + theNews.getBrief() + " " + theNews.getContent());
		
		newsDAO.save(theNews);
	}

	@Transactional
	public News fetchById(int theId) {
		
		System.out.println("Getting by id: " + theId);
		
		return newsDAO.fetchById(theId);
	}

	@Transactional
	public void remove(int theId) {
		
		System.out.println("Removing: " + theId);
		
		newsDAO.remove(theId);
	}
}
