package kosa.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosa.mapper.MemberMapper;
import kosa.mapper.ShoppingMapper;
import kosa.model.Member;
import kosa.model.Shopping;

public class MemberDao {
    private static MemberDao dao = new MemberDao();

    public static MemberDao getInstance() {
        return dao;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream in = null;

        try {
            in = Resources.getResourceAsStream(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new SqlSessionFactoryBuilder().build(in);
    }

    public Member selectMemberById(String id) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        Member member = null;

        try {
            member = sqlSession.getMapper(MemberMapper.class).selectMemberById(id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return member;
    }

    public int insertMember(Member member) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = -1;

        try {
            result = sqlSession.getMapper(MemberMapper.class).insertMember(member);

            if (result > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return result;
    }

    public List<Shopping> selectCartByUserId(String userId) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        List<Shopping> cartList = null;

        try {
            cartList = sqlSession.getMapper(ShoppingMapper.class).selectCartByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return cartList;
    }

    public int insertProductToCart(Shopping shopping) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        int result = -1;

        try {
            result = sqlSession.getMapper(ShoppingMapper.class).insertProductToCart(shopping);

            if (result > 0) {
                sqlSession.commit();
            } else {
                sqlSession.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return result;
    }
}
