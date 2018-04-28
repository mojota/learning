package Callback;

/**
 * @author jamie
 * @date 18-4-26
 */
public class ObserverImpl implements IObserver{
    @Override
    public void onCallback(String methodName) {
        System.out.println(methodName);
    }
}
