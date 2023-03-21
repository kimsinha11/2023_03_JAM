package com.KoreaIT.example.JAM;

public class Article extends Object {
	int id;
	String title;
	String body;
	String regDate;
	String updateDate;


	public Article(int id, String regDate, String updateDate, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.updateDate = updateDate;
	}
	
	public Article(int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", body=" + body + ", regDate=" + regDate + ", updateDate=" + updateDate
				+ "]";
	}
}
