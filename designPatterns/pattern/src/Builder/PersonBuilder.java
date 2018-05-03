package Builder;

/**
 * 简化的Builder,三合一
 * @author jamie
 * @date 18-5-2
 */
public class PersonBuilder {

    private final Person mPerson;

    public PersonBuilder(){
        mPerson = new Person();
    }

    public PersonBuilder buildHead(String head) {
        mPerson.setHead(head);
        return this;
    }

    public PersonBuilder buildBody(String body) {
        mPerson.setBody(body);
        return this;
    }

    public PersonBuilder buildLimbs(String limbs) {
        mPerson.setLimbs(limbs);
        return this;
    }


    public Person getPerson() {
        System.out.println(mPerson.getHead() + ";" + mPerson.getBody() + ";" + mPerson.getLimbs());
        return mPerson;
    }
}
