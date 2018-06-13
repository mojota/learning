package Facade;

/**
 * @author jamie
 * @date 18-6-13
 */
public class Facade {

    SubSystem1 system1;
    SubSystem2 system2;
    SubSystem3 system3;

    public Facade() {
        system1 = new SubSystem1();
        system2 = new SubSystem2();
        system3 = new SubSystem3();
    }

    public void doManyThings() {
        system1.doSomething();
        system2.doSomething();
        system3.doSomething();
    }
}
