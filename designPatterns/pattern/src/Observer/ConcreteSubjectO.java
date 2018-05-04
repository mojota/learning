package Observer;

/**
 * 具体被观察者
 * @author jamie
 * @date 18-5-3
 */
public class ConcreteSubjectO extends SubjectO {

    public void newMessage() {
        super.notify("最新资讯来了");
    }

}
