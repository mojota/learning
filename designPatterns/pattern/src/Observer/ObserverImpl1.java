package Observer;


/**
 * @author jamie
 * @date 18-4-26
 */
public class ObserverImpl1 implements IObserver{
    @Override
    public void onCallback(String methodName) {
        System.out.println("ObserverImpl1观察到:" + methodName);
    }
}
