package Observer;


/**
 * 实体观察者类1
 * @author jamie
 * @date 18-4-26
 */
public class ObserverImpl1 implements IObserver{
    @Override
    public void onCallback(String action) {
        System.out.println("ObserverImpl1观察到:" + action);
    }
}
