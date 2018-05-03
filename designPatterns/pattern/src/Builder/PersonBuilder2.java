package Builder;

/**
 * 简化的Builder,无Director
 *
 * @author jamie
 * @date 18-5-2
 */
public class PersonBuilder2 implements IPersonBuilder2 {

    private final Person mPerson;

    public PersonBuilder2() {
        mPerson = new Person();
    }

    @Override
    public PersonBuilder2 buildHead(String head) {
        mPerson.setHead(head);
        return this;
    }

    @Override
    public PersonBuilder2 buildBody(String body) {
        mPerson.setBody(body);
        return this;
    }

    @Override
    public PersonBuilder2 buildLimbs(String limbs) {
        mPerson.setLimbs(limbs);
        return this;
    }

    public Person getPerson() {
        System.out.println(mPerson.getHead() + ";" + mPerson.getBody() + ";" + mPerson.getLimbs());
        return mPerson;
    }
}
