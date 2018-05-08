package demo.dao;

import demo.pojo.Node;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created By jiabin on 18-5-8.
 */
public interface NodeDao {
    List<Node> getNodeTree(@Param("id") Integer id);
    List<Node> getNextNodeTree();
}
