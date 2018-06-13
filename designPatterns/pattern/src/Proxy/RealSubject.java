package Proxy;

/**
 * @author jamie
 * @date 18-6-7
 */
public class RealSubject implements ISubject{
    @Override
    public void doSomething1() {
        System.out.println("RealSubject doSomething1");
    }

    @Override
    public void doSomething2() {
        System.out.println("RealSubject doSomething2");
    }
}
