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

public class BoardDao {
	private static BoardDao dao = new BoardDao();
	
	public static BoardDao getInstance() {
		return dao;
	}
	// JNDI 기술을 이용해서 DBCP구현
	// DataSource객체(Connection Pool) => JNDI 이름으로 jdbc/oracle
	public Connection getDBCPConnection() {
		DataSource ds = null;
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/oracle");
			
			return ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Board detailBoard(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = new Board();
		
		String sql = "select * from Board where seq = ?";
		
		try {
			conn = getDBCPConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setHitcount(rs.getInt("hitcount"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {}
			}
		}
		return null;
	}
	
	// 글목록 보기
	public List<Board> listBoard(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Board> list = new ArrayList<Board>();
		
		String sql = "select * from board order by seq desc";
		
		try {
			conn = getDBCPConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Board board = new Board();
				board.setSeq(rs.getInt("seq"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContents(rs.getString("contents"));
				board.setRegdate(rs.getString("regdate"));
				board.setHitcount(rs.getInt("hitcount"));
				
				list.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {}
			}
		}
		
		return null;
	}
	
	public int insert(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// url, username, password
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "KCC";
		String password = "1234";
		int re = -1;
		
		String sql = "insert into board values(board_seq.nextval, ?, ?, ?, sysdate, 0)";
		try {
			// 1. JDBC 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB와 연결(Connection 객체 생성)
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn: " + conn);
			
			// 3. PrepareStatement 객체 생성(SQL 질의)
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2,  board.getWriter());
			pstmt.setString(3, board.getContents());
			
			// 4. SQL 실행(insert, update, delete => executeUpdate() => 정수리턴(로우 갯수)
			re = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e2) {}
			}
			if(conn != null) {
				try {
					conn.close();
				}catch(Exception e2) {}
			}
		}
		
		return re;
	}
}
