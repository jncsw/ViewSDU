package Jsoup;

import java.sql.Timestamp;

public class Article {
	String title;
	int web;
	int category;
	String writer;
	long time;
	Timestamp ts;
	String content,baseUrl;
	

	public Article(String title, int web, int category, String writer,  Timestamp time,
			String content, String baseUrl) {
		super();
		this.title = title;
		this.web = web;
		this.category = category;
		this.writer = writer;
		this.time = time.getTime()/1000;
		this.content = content;
		this.baseUrl = baseUrl;
		this.ts = time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getWeb() {
		return web;
	}
	public void setWeb(int web) {
		this.web = web;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBaseUrl() {
		return baseUrl;
	}
	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}
	public long getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time.getTime();
	}
	
}
