package kosa.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosa.mapper.BoardMapper;
import kosa.model.Board;

public class BoardDao2 {
	private static BoardDao2 dao = new BoardDao2();
	
	public static BoardDao2 getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		// mybatis-config-xml  => SqlSessionFactory
		String resource = "mybatis-config.xml";
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	public List<Board> listBoard(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<Board> list = null;
		
		try {
			list = sqlSession.getMapper(BoardMapper.class).listBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	public Board detailBoard(int seq) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Board board = null;
		
		try {
			board = sqlSession.getMapper(BoardMapper.class).detailBoard(seq);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return board;
	}
}
