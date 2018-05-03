package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象被观察者
 *
 * @author jamie
 * @date 18-4-26
 */
public abstract class SubjectO {

    // 观察者集合
    private List<IObserver> mObservers = new ArrayList<IObserver>();

    // 注册
    public void registerObserver(IObserver observer) {
        mObservers.add(observer);
    }

    // 注销
    public void unRegisterObserver(IObserver observer) {
        mObservers.remove(observer);
    }

    // 通知观察者们
    public void notify(String action) {
        for (IObserver mObserver : mObservers) {
            mObserver.onCallback(action);
        }
    }
}
