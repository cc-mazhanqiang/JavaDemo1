package cnn.whoops.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: whoops
 * @date: 2021/8/4 - 16:09
 * @description:
 *
 * 动态代理举例
 *
 */
interface Human{
    String getBelief();
    void eat(String food);
}

//被代理类
class SuperMan implements Human{

    @Override
    public String getBelief() {
        return "I want to fly！";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃：" + food);
    }
}

class ProxyFactorys{
    //调用此方法，返回一个代理类的对象
    public static Object getProxyInstance(Object obj){  //obj:被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();

        handler.bind(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}

class MyInvocationHandler implements InvocationHandler{

    private Object obj;//需要使用被代理类的对象进行赋值

    public void bind(Object obj){
        this.obj = obj;
    }

    //将被代理类要执行的方法声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //代理类调用的方法，也是被代理类调用的方法
        //obj：被代理类的对象
        Object invoke = method.invoke(obj, args);

        return  invoke;
    }
}

public class DynamicProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human proxyInstance = (Human) ProxyFactorys.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("麻辣烫");
        System.out.println("************************");
        NikeFactory nikeFactory = new NikeFactory();
        ProxyFactory proxyInstance1 = (ProxyFactory) ProxyFactorys.getProxyInstance(nikeFactory);
        proxyInstance1.produceCloth();
    }

}
