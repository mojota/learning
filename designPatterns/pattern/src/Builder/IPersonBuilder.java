package Builder;

/**
 * 抽象建造接口
 * @author jamie
 * @date 18-5-2
 */
public interface IPersonBuilder {

    void buildHead();
    void buildBody();
    void buildLimbs();

    Person getPerson();
}
