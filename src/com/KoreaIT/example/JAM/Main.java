package com.KoreaIT.example.JAM;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);
		List<Article> articles = new ArrayList<>();

		int lastArticleId = 0;


		while (true) {

			System.out.printf("명령어 ) ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("exit")) {
				break;
			}
			if (cmd.equals("article write")) {
				System.out.println("==게시물 작성==");
				int id = lastArticleId + 1;

				System.out.printf("제목 : ");
				String title = sc.nextLine();
				System.out.printf("내용 : ");
				String body = sc.nextLine();
				String regDate = "";

				Article article = new Article(id, title, body, regDate);
				articles.add(article);
				
//				System.out.println(article); >> Article [id=1, title=aa, body=aa, regDate=, hit=null]
				System.out.printf("%d / %s \n", article.id, article.title);

				System.out.printf("%d번 글이 생성되었습니다.\n", id);
				lastArticleId++;
			} else if (cmd.equals("article list")) {
				System.out.println("==게시물 리스트==");
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다.");
				} else {
					System.out.printf("번호  / 제목  \n");

					for (int i = articles.size() - 1; i >= 0; i--) {
						Article article = articles.get(i);

						System.out.printf("%d / %s \n", article.id, article.title);
					}
				}
			}
			else {
				System.out.println("존재하지 않는 명령어 입니다.");
			}

		}
		System.out.println("==프로그램 종료==");
		sc.close();
	}
}

