import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author fanduanjin
 * @program mybatis-3-mybatis-3.5.0
 * @Classname
 * @Description
 * @Date 2022/5/25
 * @Created by fanduanjin
 */
public class MybatisTest {

    public void test(){
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory= builder.build(new Configuration());
        SqlSession sqlSession= sqlSessionFactory.openSession();
        //方式1
        sqlSession.selectList("cn.fan.dao.userDao.selectUser");
        //方式二
        UserDao userDao= sqlSession.getMapper(UserDao.class);
        userDao.selectUser();
    }

    private static interface UserDao{
        void selectUser();
    }
}
