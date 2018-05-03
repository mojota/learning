import Builder.*;
import Observer.*;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");

        // 回调
//        SubjectC subjectC = new SubjectC();
//        subjectC.setObserver(new IObserver() {
//            @Override
//            public void onCallback(String methodName) {
//                System.out.println(methodName);
//            }
//        });
// //        subjectC.setObserver(new ObserverImpl());
//        subjectC.move();

        // 观察者
        ConcreteSubjectO subjectO = new ConcreteSubjectO();
        ObserverImpl1 observerImpl1 = new ObserverImpl1();
        ObserverImpl2 observerImpl2 = new ObserverImpl2();
        ObserverImpl3 observerImpl3 = new ObserverImpl3();
        subjectO.registerObserver(observerImpl1);
        subjectO.registerObserver(observerImpl2);
        subjectO.registerObserver(observerImpl3);
        subjectO.newMessage();
//         取消观察者1的注册
 //       subjectO.unRegisterObserver(observerImpl1);
 //      subjectO.newMessage();


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
//        director.createPerson(greenPerson);
//        greenPerson.getPerson();
//        IPersonBuilder redPerson = new RedPersonBuilder();
//        director.createPerson(redPerson);
//        redPerson.getPerson();

//        PersonBuilder builder = new PersonBuilder();
//        builder.buildHead("蓝色的头").buildBody("蓝色身体").buildLimbs("蓝色四肢").getPerson();

//        PersonBuilder2 builder2 = new PersonBuilder2();
//        builder2.buildHead("黄色的头").buildBody("黄色的身体").buildLimbs("黄色的四肢").getPerson();

    }
}
