package demo.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.*;

/**
 * Created By jiabin on 18-5-9.
 */
public class CustomProxy implements InvocationHandler {
    private final Logger logger = LoggerFactory.getLogger(CustomProxy.class);
    private final Object target;

    private CustomProxy(Object target) {
        this.target = target;
    }

    public static Object wrap(Object target) {
        Class proxyClass = Proxy.getProxyClass(CustomProxy.class.getClassLoader(), target.getClass().getInterfaces());
        Constructor constructor = null;
        try {
            constructor = proxyClass.getConstructor(InvocationHandler.class);
            return constructor.newInstance(new CustomProxy(target));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return Proxy.newProxyInstance(CustomProxy.class.getClassLoader(),
                target.getClass().getInterfaces(),
                new CustomProxy(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("before");
        logger.info(proxy.getClass().toString());
        Object invoke = method.invoke(target, args);
        logger.info("after");
        return invoke;
    }
}
