package Observer;


/**
 * 实体观察者类3
 * @author jamie
 * @date 18-4-26
 */
public class ObserverImpl3 implements IObserver {
    @Override
    public void onCallback(String action) {
        System.out.println("ObserverImpl3观察到:" + action);
    }
}
