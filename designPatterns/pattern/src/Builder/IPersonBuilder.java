package Builder;

/**
 *
 * @author jamie
 * @date 18-5-2
 */
public interface IPersonBuilder {

    void buildHead();
    void buildBody();
    void buildLimbs();

    Person getPerson();
}
