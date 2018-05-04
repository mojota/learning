package Observer;


/**
 * 实体观察者类2
 * @author jamie
 * @date 18-4-26
 */
public class ObserverImpl2 implements IObserver{
    @Override
    public void onCallback(String action) {
        System.out.println("ObserverImpl2观察到:" + action);
    }
}
