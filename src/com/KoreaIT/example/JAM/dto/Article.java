package com.KoreaIT.example.JAM.dto;


import java.time.LocalDateTime;
import java.util.Map;

public class Article extends Object {
	public int memberId;
	public int id;
	public LocalDateTime regDate;
	public LocalDateTime updateDate;
	public String title;
	public String body;
	
	public int hit;
	public String extra__writer;

	public Article(int id , String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}

	public Article(int id, int memberId, LocalDateTime regDate, LocalDateTime updateDate, String title, String body) {
		this.id = id;
		this.memberId = memberId;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.title = title;
		this.body = body;
	}

	public Article(Map<String, Object> articleMap) {
		this.extra__writer = (String) articleMap.get("extra__writer");
		this.hit = (int) articleMap.get("hit");
//		this.memberId = (int) articleMap.get("memberId");
		this.id = (int) articleMap.get("id");
		this.regDate = (LocalDateTime) articleMap.get("regDate");
		this.updateDate = (LocalDateTime) articleMap.get("updateDate");
		this.title = (String) articleMap.get("title");
		this.body = (String) articleMap.get("body");

	}

	@Override
	public String toString() {
		return "Article [memberId=" + memberId + ", extra__writer=" + extra__writer + ", id=" + id + ", regDate=" + regDate
				+ ", updateDate=" + updateDate + ", title=" + title + ", body=" + body + "]";
	}

}