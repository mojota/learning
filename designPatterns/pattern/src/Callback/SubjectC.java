package Callback;

/**
 * @author jamie
 * @date 18-4-26
 */
public class SubjectC {

    private IObserverC mObserver;

    public void setObserver(IObserverC observer) {
        mObserver = observer;
    }

    public void newMessage() {
        if (mObserver != null) {
            mObserver.onCallback("有新数据来了");
        }
    }
}
