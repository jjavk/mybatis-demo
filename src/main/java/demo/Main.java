package demo;

import demo.dao.NodeDao;
import demo.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by jiabin on 2018/5/7.
 */
public class Main {
    static private final Logger logger = LoggerFactory.getLogger(Main.class);
    static private SqlSessionFactory sqlSessionFactory = null;
    static private SqlSession session = null;

    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();

        //nodeDemo();
        userDemo();
        session.close();
    }

    public static void nodeDemo() {
        NodeDao nodeDao = session.getMapper(NodeDao.class);
        logger.info(Arrays.toString(nodeDao.getNodeTree(1).toArray()));
    }

    public static void userDemo() {
        UserDao userDao = session.getMapper(UserDao.class);
        logger.info(userDao.selectByCasId(8).toString());
    }
}
