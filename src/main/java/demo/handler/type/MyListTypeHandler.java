package demo.handler.type;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * Created By jiabin on 18-5-9.
 */
@MappedJdbcTypes({JdbcType.VARCHAR})
@MappedTypes({List.class})
public class MyListTypeHandler extends BaseTypeHandler<List> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, List list, JdbcType jdbcType) throws SQLException {
        preparedStatement.setString(i, listToString(list, ','));
    }

    @Override
    public List getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return splitResultString(resultSet.getString(s));
    }

    @Override
    public List getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return splitResultString(resultSet.getString(i));
    }

    @Override
    public List getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return Arrays.asList(callableStatement.getString(i).split(","));
    }

    private List splitResultString(String str) {
        List list = null;
        if (str != null && !"".equals(str)) {
            list = Arrays.asList(str.split(","));
        }
        return list;
    }

    private String listToString(List list, char separator) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }
}
