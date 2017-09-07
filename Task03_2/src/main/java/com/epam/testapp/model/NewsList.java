package com.epam.testapp.model;

import java.util.List;

public class NewsList {
	private static List<News> list;

	public List<News> getList() {
		return list;
	}

	public void setList(List<News> list) {
		NewsList.list = list;
	}
}
