package demo.dao;

import demo.pojo.Cascade;
import demo.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by jiabin on 2018/5/7.
 */
public interface UserDao {
    int insert(User record);

    int insertBatch(@Param("users") List<User> users);

    List<User> selectAllUser();

    void updateAgeById(@Param("id") Integer id, @Param("age") Integer age);

    Cascade selectByCasId(@Param("id") Integer id);

    User selectUserById(@Param("id") Integer id, @Param("usernames") String username);
}
