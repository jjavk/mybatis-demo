package demo.datasource;

import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created By jiabin on 18-5-9.
 */
public class DruidDataSourceFactory implements DataSourceFactory{

    @Override
    public void setProperties(Properties properties) {

    }

    @Override
    public DataSource getDataSource() {
        return null;
    }
}
