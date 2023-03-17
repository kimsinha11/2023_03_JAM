package com.KoreaIT.example.JAM;

public class Article extends Object {
	int id;
	String title;
	String body;
	String regDate;
	String hit;

	public Article(int id, String title, String body, String regDate) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", body=" + body + ", regDate=" + regDate + ", hit=" + hit
				+ "]";
	}
}
