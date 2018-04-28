package Callback;

/**
 * @author jamie
 * @date 18-4-26
 */
public class TargetC {

    private IObserver mObserver;

    public void setObserver(IObserver observer) {
        mObserver = observer;
    }

    public void move() {
        if (mObserver != null) {
            mObserver.onCallback("move");
        }
    }
}
