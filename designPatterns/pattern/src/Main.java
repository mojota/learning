import Adapter.AdapterTargetO;
import Adapter.Target;
import Builder.*;
import Callback.IObserverC;
import Callback.ObserverImpl;
import Callback.SubjectC;
import Facade.Facade;
import Facade.SubSystem1;
import Facade.SubSystem2;
import Facade.SubSystem3;
import Observer.*;
import Proxy.Proxy;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");

        // 回调
//        SubjectC subjectC = new SubjectC();
//        subjectC.setObserver(new IObserverC() {
//            @Override
//            public void onCallback(String action) {
//                System.out.println(action);
//            }
//        });
////         subjectC.setObserver(new ObserverImpl());
//        subjectC.newMessage();

        // 观察者模式
//        ConcreteSubjectO subjectO = new ConcreteSubjectO();
//        ObserverImpl1 observerImpl1 = new ObserverImpl1();
//        ObserverImpl2 observerImpl2 = new ObserverImpl2();
//        ObserverImpl3 observerImpl3 = new ObserverImpl3();
//        subjectO.registerObserver(observerImpl1);
//        subjectO.registerObserver(observerImpl2);
//        subjectO.registerObserver(observerImpl3);
//        subjectO.newMessage();
//         取消观察者1的注册
 //       subjectO.unRegisterObserver(observerImpl1);
 //      subjectO.newMessage();


        // 适配器模式
//        Target normalTarget = new NormalTarget();
//        normalTarget.request();
//        // 对象适配器
//        Target adapterO = new AdapterTargetO();
//        adapterO.request();
////        // 也可适配多种
////        Target adapterO2 = new AdapterTargetO(new Adaptee());
////        adapterO2.request();
////        // 类适配器
////        Target adapterC = new AdapterTargetC();
////        adapterC.request();

        // 建造者模式
//        Director director = new Director();
//        IPersonBuilder greenPerson = new GreenPersonBuilder();
//        director.createPerson(greenPerson);
//        greenPerson.getPerson();
//        IPersonBuilder redPerson = new RedPersonBuilder();
//        director.createPerson(redPerson);
//        redPerson.getPerson();

//        PersonBuilder builder = new PersonBuilder();
//        builder.buildHead("蓝色的头").buildBody("蓝色身体").buildLimbs("蓝色四肢").getPerson();

//        PersonBuilder2 builder2 = new PersonBuilder2();
//        builder2.buildHead("黄色的头").buildBody("黄色的身体").buildLimbs("黄色的四肢").getPerson();

        // 代理模式
//        Proxy proxy = new Proxy();
//        proxy.doSomething1();
//        proxy.doSomething2();

        // 外观模式
//        SubSystem1 system1 = new SubSystem1();
//        SubSystem2 system2 = new SubSystem2();
//        SubSystem3 system3 = new SubSystem3();
//        system1.doSomething();
//        system2.doSomething();
//        system3.doSomething();

        Facade facade = new Facade();
        facade.doManyThings();

    }
}
