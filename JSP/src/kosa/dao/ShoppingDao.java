package kosa.dao;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import kosa.mapper.ShoppingMapper;
import kosa.model.Shopping;

public class ShoppingDao {
    private static ShoppingDao dao = new ShoppingDao();
    
    public static ShoppingDao getInstance() {
        return dao;
    }
    
    private SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream in = null;
        
        try {
            in = Resources.getResourceAsStream(resource);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return new SqlSessionFactoryBuilder().build(in);
    }
    
    public void insertProductToCart(Shopping shopping) {
        SqlSession sqlSession = getSqlSessionFactory().openSession();
        
        try {
            ShoppingMapper mapper = sqlSession.getMapper(ShoppingMapper.class);
            mapper.insertProductToCart(shopping);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
