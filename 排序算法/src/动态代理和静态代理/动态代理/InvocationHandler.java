package 动态代理和静态代理.动态代理;

import java.lang.reflect.Method;

//Object proxy:被代理的对象
//Method method:要调用的方法
//Object[] args:方法调用时所需要参数
public interface InvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
