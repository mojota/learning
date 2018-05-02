package Builder;

/**
 * 指导者
 * @author jamie
 * @date 18-5-2
 */
public class Director {

    public IPersonBuilder createPerson(IPersonBuilder builder) {
        builder.buildHead();
        builder.buildBody();
        builder.buildLimbs();
        return builder;
    }
}
