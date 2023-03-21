package com.KoreaIT.example.JAM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				
				
				
				String updateDate = "";
				Article article = new Article(id, title, body);
				articles.add(article);
				
//				System.out.println(article); >> Article [id=1, title=aa, body=aa, regDate=, hit=null]
				System.out.printf("%d / %s \n", article.id, article.title);

				System.out.printf("%d번 글이 생성되었습니다.\n", id);
				
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://127.0.0.1:3306/JAM?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
					
					conn = DriverManager.getConnection(url, "root", "");
					System.out.println("연결 성공!");
					
					String sql = "INSERT INTO article";
					sql += " SET regDate = NOW(),";
					sql += "updateDate = NOW(),";
					sql += "title = '" + title + "',";
					sql += "`body` = '" + body + "';";
					
					System.out.println(sql);
					
					pstmt = conn.prepareStatement(sql);
					
					int affectedRow = pstmt.executeUpdate();
					
					System.out.println("affectedRow : " + affectedRow);
					
				} catch (ClassNotFoundException e) {
					System.out.println("드라이버 로딩 실패");
					
				} catch (SQLException e) {
					System.out.println("에러 : " + e);
					
				} finally {
					try {
						if (pstmt != null && !pstmt.isClosed()) {
							pstmt.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
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
				Connection conn = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					String url = "jdbc:mysql://127.0.0.1:3306/JAM?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
					
					conn = DriverManager.getConnection(url, "root", "");
					System.out.println("연결 성공!");
					
					String sql = "SELECT id, title";
					sql += " FROM article";
					sql += " ORDER BY id DESC;";
					
					
					System.out.println(sql);
					
					pstmt = conn.prepareStatement(sql);
					
					rs = pstmt.executeQuery();
					System.out.println("번호 | 제목");
					while (rs.next()) {
						
						String id = rs.getString("id");
						String title = rs.getString("title");
						
						
						System.out.println(id + "  |  " + title);
					}
					System.out.println("rs : " + rs);
					
				} catch (ClassNotFoundException e) {
					System.out.println("드라이버 로딩 실패");
				} catch (SQLException e) {
					System.out.println("에러 : " + e);
				} finally {
					try {
						if (rs != null && !rs.isClosed()) {
							rs.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						if (pstmt != null && !pstmt.isClosed()) {
							pstmt.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					try {
						if (conn != null && !conn.isClosed()) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
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

