import Adapter.*;
import Builder.Director;
import Builder.GreenPersonBuilder;
import Builder.IPersonBuilder;
import Builder.RedPersonBuilder;
import Observer.ObserverImpl1;
import Observer.ObserverImpl2;
import Observer.ObserverImpl3;
import Observer.TargetO;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // 回调
//        TargetC targetc = new TargetC();
//        targetc.setObserver(new IObserver() {
//            @Override
//            public void onCallback(String methodName) {
//                System.out.println(methodName);
//            }
//        });
// //        targetc.setObserver(new ObserverImpl());
//        targetc.move();

        // 观察者
        TargetO targetO = new TargetO();
        ObserverImpl1 observerImpl1 = new ObserverImpl1();
        ObserverImpl2 observerImpl2 = new ObserverImpl2();
        ObserverImpl3 observerImpl3 = new ObserverImpl3();
        targetO.registerObserver(observerImpl1);
        targetO.registerObserver(observerImpl2);
        targetO.registerObserver(observerImpl3);
        targetO.move();
//         取消观察者1的注册
 //       targetO.unRegisterObserver(observerImpl1);
 //      targetO.move();


        // 适配器
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

        // 建造者
//        Director director = new Director();
//        IPersonBuilder greenPerson = new GreenPersonBuilder();
////        greenPerson.getPerson();
//        director.createPerson(greenPerson);
//        greenPerson.getPerson();
//
////        IPersonBuilder redPerson = new RedPersonBuilder();
////        redPerson.getPerson();
////        director.createPerson(redPerson);
////        redPerson.getPerson();


    }
}
