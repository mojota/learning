package Builder;

/**
 * 抽象建造接口
 * @author jamie
 * @date 18-5-2
 */
public interface IPersonBuilder2 {

    IPersonBuilder2 buildHead(String head);
    IPersonBuilder2 buildBody(String body);
    IPersonBuilder2 buildLimbs(String limbs);
    Person getPerson();
}
