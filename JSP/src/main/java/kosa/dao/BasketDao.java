package kosa.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kosa.mapper.BasketMapper;
import kosa.model.Basket;

public class BasketDao {
    private static BasketDao dao = new BasketDao();
    
    public static BasketDao getInstance() {
        return dao;
    }
    
    public SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream in = null;
        
        try {
            in = Resources.getResourceAsStream(resource);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new SqlSessionFactoryBuilder().build(in);
    }

    public void addProduct(String userId, String product) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        try {
            Basket basket = new Basket();
            basket.setUserId(userId);
            basket.setProduct(product);
            sqlSession.getMapper(BasketMapper.class).addProduct(basket);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if(sqlSession != null) sqlSession.close();
        }
    }

    public List<Basket> getProductsByUserId(String userId) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        List<Basket> products = null;
        try {
            products = sqlSession.getMapper(BasketMapper.class).getProductsByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(sqlSession != null) sqlSession.close();
        }
        return products;
    }
}
