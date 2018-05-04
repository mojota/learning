package Callback;

/**
 * @author jamie
 * @date 18-4-26
 */
public class ObserverImpl implements IObserverC {
    @Override
    public void onCallback(String action) {
        System.out.println(action);
    }
}
