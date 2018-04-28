import Callback.IObserver;
import Callback.ObserverImpl;
import Callback.TargetC;
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
//        TargetO targetO = new TargetO();
//        ObserverImpl1 observerImpl1 = new ObserverImpl1();
//        ObserverImpl2 observerImpl2 = new ObserverImpl2();
//        ObserverImpl3 observerImpl3 = new ObserverImpl3();
//        targetO.registerObserver(observerImpl1);
//        targetO.registerObserver(observerImpl2);
//        targetO.registerObserver(observerImpl3);
//        targetO.move();
        // 取消观察者1的注册
// //       targetO.unRegisterObserver(observerImpl1);
// //      targetO.move();


    }
}
