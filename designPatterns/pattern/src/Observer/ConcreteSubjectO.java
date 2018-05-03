package Observer;

/**
 * @author jamie
 * @date 18-5-3
 */
public class ConcreteSubjectO extends SubjectO {

    public void newMessage() {
        super.notify("有新消息来了");
    }

}
