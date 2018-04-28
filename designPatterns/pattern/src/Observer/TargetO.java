package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jamie
 * @date 18-4-26
 */
public class TargetO {

    private List<IObserver> mObservers = new ArrayList<IObserver>();

    public void registerObserver(IObserver observer) {
        mObservers.add(observer);
    }

    public void unRegisterObserver(IObserver observer) {
        mObservers.remove(observer);
    }

    public void move() {
        for (IObserver mObserver : mObservers) {
            mObserver.onCallback("move");
        }
    }
}
