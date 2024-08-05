package kosa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kosa.model.Board;
import oracle.net.aso.e;

public class BoardDao {
	private static BoardDao dao = new BoardDao();
	//이방식을 싱글톤이라한다. -> 매번 게시글을 쓸때마다 객체를 생성하는게 아니라 기본형식을 남겨두고 글을 추가한다.
	public static BoardDao getInstance() {
		return dao;
	}
	
	// JNDI 기술을 이용해서 DBCP(데이터베이스 커넥션 풀) 구현
	// DataSource객체 (Connection Pool) -> JNDI 이름으로 jdbc/oracle
	public Connection getDBCPConnection() { //해당 메소드를 사용하는 JDBC를 뽑아올 수 있다.
		DataSource ds = null;
		try {
			Context ctx = new InitialContext();
//			ctx.lookup("java:comp/env/jdbc/oracle"); 
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle"); //DataSource객체를 가져올 수 있다.
			//lookup에서 검색
			
			return ds.getConnection();
		} catch (Exception e) {	
			e.printStackTrace();
			
		}
		return null;
	}
	
	//상세보기
	public Board getBoardDetail(int seq) {//글번호 입력받아오기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; //쿼리결과 저장
//		Board board = null; //쿼리결과 생성
		Board board = new Board();
		
		
		String sql = "select * from board where seq = ?";
		
		try {
			conn = getDBCPConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq); //첫번째 매개변수(?)에 seq값을 설정
			rs = pstmt.executeQuery(); //rs쿼리 실행 ResultSet객체에 저장, select를 사용하니까 ~Query를 사용
			

			if(rs.next()) { //row가 하나일경우는 if, 여러개일때는 while이다.
//				board = new Board(); //이것까지는 필요없음
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setHitcount(rs.getInt("hitcount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally { //3개의 객체를 전부 null인지 확인후, 닫아서 자원을 해제해준다. 외부에서하면 못닫는다.
			if(rs != null) {
				try {
					rs.close();
				} catch (Exception e2) {
					
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					
				}
			} // 메인으로 닫아야할것
			if(conn != null) {
				try {
					conn.close();
				} catch (Exception e2) {
					
				}
			}
		}
		return board;
		
	}
	
	
	//글목록 보기 -> 글하나를 board라는 그릇에 담아와야한다. -> 여러개이므로 list
	public List<Board> listBoard(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();
		
		String sql = "select * from board order by seq desc";
		
		try {
			//이미 연결은 완료된 상태
			conn = getDBCPConnection(); //Connection 종료 -> 해당메소드에서 모두 종료
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //여기서 질의문 적용
			
			//한개의 row를 board에 담아야한다. -> 하나의 row는 하나의 자바 객체다
			//이걸 여러개 담아야할때는 List에 담는것이다.
			while(rs.next()) {//next에서 첫번째 row를 가르킴
				Board board = new Board();
				board.setSeq(rs.getInt("seq")); //DB에서 가져온 값을 board에 담는과정
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setHitcount(rs.getInt("hitcount"));
				
				list.add(board); //while문을 돌면서 하나의 board를 list에 반복해서 담아준다.
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {
					
				}
			}
		}
		return list;
	}
	
	
	public int insert(Board board) {
//		System.out.println(board);
		
		//Connection 객체 만들기
		Connection conn = null; //밖에서 선언하면 close 불가
		PreparedStatement pstmt = null;
		
		//URL, user, password
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "kcc";
		String password = "1234";
		int re = -1;
		
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		// ?이건 다음에 넣어준다는뜻
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB 연결 (Connection 객체의 생성유무)
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn : " + conn);
			
			// 3. PrepareStatement 객체 생성 (SQL 질의)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContents()); //가져오기
			
			// 4. SQL 실행(insert, update, delete -> executeUpdate() -> 정수를 리턴(로우 갯수)
			re = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(Exception e2){
					
				}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e2){
					
				}
			}
		}
		return re; // 1성공, -1실패
	}
	
}
