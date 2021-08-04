package cnn.whoops.proxy;

/**
 * @author: whoops
 * @date: 2021/8/4 - 16:00
 * @description:
 *
 * 静态代理举例：
 * 特点：代理类和被代理类在编译期间，就确定下来了。
 *
 */
interface ProxyFactory{
    void produceCloth();
}

//创建代理类
class ProxyClothFactory implements ProxyFactory{

    private ProxyFactory factory;//用被代理类对象进行实例化

    public ProxyClothFactory(ProxyFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂准备前期工作");
        factory.produceCloth();
        System.out.println("代工厂准备收尾工作");
    }
}

//创建被代理类
class NikeFactory implements ProxyFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike生产了衣服");
    }
}

class ProxyTest {
    public static void main(String[] args) {
        NikeFactory nikeFactory = new NikeFactory();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeFactory);
        proxyClothFactory.produceCloth();
    }
}
