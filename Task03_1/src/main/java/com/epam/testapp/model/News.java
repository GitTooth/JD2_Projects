package com.epam.testapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "news")
public class News {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String title;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "brief")
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String brief;
	
	@Column(name = "content")
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String content;
	
	public News() {
	}

	public News(String title, Date date, String brief, String content) {
		this.title = title;
		this.date = date;
		this.brief = brief;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	
}
