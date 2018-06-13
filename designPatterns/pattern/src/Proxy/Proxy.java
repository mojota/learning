package Proxy;

/**
 * @author jamie
 * @date 18-6-7
 */
public class Proxy implements ISubject {

    RealSubject mRealSubject;

    public Proxy() {
        mRealSubject = new RealSubject();
    }

    @Override
    public void doSomething1() {
        mRealSubject.doSomething1();
    }

    @Override
    public void doSomething2() {
        mRealSubject.doSomething2();
    }
}
