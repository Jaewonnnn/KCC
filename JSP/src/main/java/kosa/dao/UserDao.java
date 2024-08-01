package kosa.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosa.mapper.BoardMapper;
import kosa.mapper.UserMapper;
import kosa.model.User;

public class UserDao {
private static UserDao dao = new UserDao();
	
	public static UserDao getInstance() {
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
	
	public int signup(User user) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1; // -1 : 실패, 1 : 성공
		
		try {
			re = sqlSession.getMapper(UserMapper.class).signUp(user);
			if(re > 0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	public User login(User user) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		User re = null; // -1 : 실패, 1 : 성공
		
		try {
			re = sqlSession.getMapper(UserMapper.class).login(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return re;
	}
}
