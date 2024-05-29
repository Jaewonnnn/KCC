package kosa.board;

import java.util.Scanner;

public class BoardManager {
	private Board[] board = new Board[10];
	private int idx;
	
	Scanner sc = new Scanner(System.in);
	
	public void insert() {
		System.out.println("제목 : ");
		String title = sc.nextLine();
		System.out.println("작성자 : ");
		String writer = sc.nextLine();
		System.out.println("내용 : ");
		String content = sc.nextLine();
		board[idx++] = new Board(title, content, writer);
	}
	public boolean printBoardList() {
		if(idx == 0) {
			System.out.println("글 없음");
			return false;
		}
		for(int i = 0; i < idx; i++) {
			System.out.println((i+1) +". "+ board[i].getTitle());
		}
		return true;
	}
	public void printBoardContent(String num) {
		int i = Integer.parseInt(num);
		if((i-1) <= idx) {
			System.out.println("제목 : " + board[i-1].getTitle());
			System.out.println("작성자 : " + board[i-1].getWriter());
			System.out.println("내용 : " + board[i-1].getContent());
		}else {
			System.out.println("찾을 수 없음");
		}
	}
	public void updateTitle(String num, String title) {
		int i = Integer.parseInt(num);
		board[i-1].setTitle(title);
		System.out.println("수정 완료");
	}
	public void updateContent(String num, String content) {
		int i = Integer.parseInt(num);
		board[i-1].setContent(content);
		System.out.println("수정 완료");
	}
	public void deleteBoard(String num) {
		int i = Integer.parseInt(num);
		for(int j = i; board[j] != null ;j++) {
			board[j-1] = board[j];
		}
		idx--;
		System.out.println("삭제 완료");
	}
}
