package com.epam.testapp.util;

import java.util.List;

import com.epam.testapp.model.News;

public interface NewsService {
	public List<News> getList();

	public void save(News theNews);

	public News fetchById(int theId);

	public void remove(int theId);

}
