package Observer;


/**
 * @author jamie
 * @date 18-4-26
 */
public class ObserverImpl3 implements IObserver {
    @Override
    public void onCallback(String methodName) {
        System.out.println("ObserverImpl3观察到:" + methodName);
    }
}
