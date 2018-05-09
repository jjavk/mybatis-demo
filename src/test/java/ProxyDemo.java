import demo.proxy.CustomProxy;
import demo.proxy.IHello;
import org.junit.Test;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.ProxyGenerator;
import sun.reflect.misc.ReflectUtil;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created By jiabin on 18-5-9.
 */
public class ProxyDemo {
    private final Logger logger = LoggerFactory.getLogger(ProxyDemo.class);
    @Test
    public void test() {
        IHello hello = (IHello) CustomProxy.wrap(new IHello() {
            @Override
            public void sayHello() {
                logger.info("hello");
            }
        });
        hello.sayHello();
        logger.info(hello.getClass().toString());
        logger.info(Arrays.toString(hello.getClass().getDeclaredMethods()));
        for (Method m : hello.getClass().getMethods()) {
            logger.info(m.toString());
        }
    }
}
