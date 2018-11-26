import com.cheer.mybatis.dao.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;


import java.io.IOException;
import java.io.InputStream;

public abstract class AbstractMapperTest {
    InputStream inputStream=null;
    SqlSession sqlSession=null;
    BlogMapper blogMapper=null;

    @Before
    public void before() {
        try {
            inputStream= Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession=sqlSessionFactory.openSession();
            blogMapper=sqlSession.getMapper(BlogMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after(){
        //事务提交
        this.sqlSession.commit();
        this.sqlSession.close();
        if(null!=inputStream){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
