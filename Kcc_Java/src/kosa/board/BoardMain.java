package kosa.board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BoardManager boardManager = new BoardManager();
		xx: while (true) {
			System.out.println("1.작성 2.게시판 목록  3.수정 4.삭제 5.종료");
			String num = sc.nextLine();
			switch (num) {
			case "1":
				boardManager.insert();
				break;
			case "2":
				if (boardManager.printBoardList()) {
					System.out.println("번호를 입력하세요");
					String contentNum = sc.nextLine();

					boardManager.printBoardContent(contentNum);
				}
				break;
			case "3":
				System.out.println("수정할 번호를 입력하세요");
				boardManager.printBoardList();
				String updateNum = sc.nextLine();
				System.out.println("1.제목 2.내용");
				String selectNum = sc.nextLine();
				System.out.println("수정할 내용을 입력하세요");
				String content = sc.nextLine();
				
				if (Integer.parseInt(selectNum) == 1) {
					boardManager.updateTitle(updateNum, content);
				} else if (Integer.parseInt(selectNum) == 2) {
					boardManager.updateContent(updateNum, content);
				} else {
					System.out.println("다시 입력하세요");
				}
				break;
			case "4":
				System.out.println("삭제 할 번호 입력하세요");
				boardManager.printBoardList();
				String titleNum = sc.nextLine();

				boardManager.deleteBoard(titleNum);
				break;
			case "5":
				break xx;
			default:
				System.out.println("다시 입력하세요");
			}
		}
	}
}