package kosa.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosa.mapper.BlogMapper;
import kosa.mapper.BoardMapper;
import kosa.model.Blog;
import kosa.model.Board;
import kosa.model.Search;

public class BoardDao2 {
	private static BoardDao2 dao = new BoardDao2();
	
	public static BoardDao2 getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		// mybatis-config.xml -> 모든 정보를 가지고 있다. -> 객체화 시켜야한다. (SqlSessionFactory)
		String resource = "mybatis-config.xml"; // 이걸 Mybatis에서 Dao로 보낸다
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
//			import org.apache.ibatis.io.Resources; -> Resources는 이걸로
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	//mybatis-config.xml -> SqlSessionFactory이걸 만들어냄
	
	public List<Board> listBoard(/* Map map */Search search){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		List<Board> list = null;
		
		try {
			list = sqlSession.getMapper(BoardMapper.class).listBoard(/* map */search);
			
//			list= sqlSession.selectList("kosa.mapper.BoardMapper.listBoard");
//			-> 이렇게도 가능하다
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
//	============================================================================
	
	public Blog selectBlog(int id) {
		SqlSession sqlSession = getSqlSessionFactory().openSession(); 
	       //sqlSession객체가 있어야함
	       Blog blog = null; 
	        
	       try {
	           blog = sqlSession.getMapper(BlogMapper.class).selectBlog(id);
	       } catch (Exception e) {
	           e.printStackTrace();
	       } finally {
	           if (sqlSession != null) {
	               sqlSession.close();
	           }
	       }
	       return blog;
	}
//	============================================================================	
	
	
	 public Board detailBoard(int seq) {  // 상세 보기 메서드 추가
	       SqlSession sqlSession = getSqlSessionFactory().openSession(); 
	       //sqlSession객체가 있어야함
	       Board board = null; //하나니까 List 아님
	        
	       try {
	           board = sqlSession.getMapper(BoardMapper.class).detailBoard(seq);//board를 생성
	       } catch (Exception e) {
	           e.printStackTrace();
	       } finally {
	           if (sqlSession != null) {
	               sqlSession.close();
	           }
	       }
	       return board;
	  }
	 
	 public int insertBoard(Board board) {
		 SqlSession sqlSession = getSqlSessionFactory().openSession();
		 int re = -1;
		 
		 try {
			re = sqlSession.getMapper(BoardMapper.class).insertBoard(board);
			
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		 return re;
	 }
	 
	 
	 public int updateBoard(Board board) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		 
		 
		try {
			re = sqlSession.getMapper(BoardMapper.class).updateBoard(board);
			
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		 return re;
	 }
	
}
