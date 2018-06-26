import demo.dao.NodeDao;
import demo.dao.UserDao;
import demo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by jiabin on 2018/5/8.
 */
public class Demo {
    static private final Logger logger = LoggerFactory.getLogger(Demo.class);
    static private SqlSessionFactory sqlSessionFactory = null;
    static private SqlSession session = null;
    static private NodeDao nodeDao = null;
    static private UserDao userDao = null;
    User user;
    @Before
    public void before() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        nodeDao = session.getMapper(NodeDao.class);
        userDao = session.getMapper(UserDao.class);

        user = new User();
        user.setNickname("123");
        user.setPassword("123");
        user.setUsername("123");
        user.setRoles("112");
        user.setBirthday(new Date());
        user.setInterests(Arrays.asList("red", "blue", "yellow", "足球"));
    }

    @After
    public void after() {
        session.commit();
        session.close();
    }

    @Test
    public void test1() {
        logger.info(Arrays.toString(nodeDao.getNodeTree(1).toArray()));
    }

    /**
     * 测试自定义TypeHandle, javaType=Date, jdbcType=BIGINT
     */
    @Test
    public void test2() {

        userDao.insert(user);
        logger.info(user.toString());
    }

    @Test
    public void test3() {
        logger.info(userDao.selectUserById(8, "123").toString());
    }

    @Test
    public void test4() {
        logger.info("{}", userDao.selectAllUser().size());

        List<User> users = new ArrayList<>(4);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        userDao.insertBatch(users);

        logger.info("{}", userDao.selectAllUser().size());
    }
}
