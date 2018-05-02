package Builder;

/**
 * @author jamie
 * @date 18-5-2
 */
public class RedPersonBuilder implements IPersonBuilder {

    Person person = new Person();

    @Override
    public void buildHead() {
        String head = "建造红色的头部";
        person.setHead(head);
    }

    @Override
    public void buildBody() {
        String body = "建造红色的身体";
        person.setBody(body);
    }

    @Override
    public void buildLimbs() {
        String limbs = "建造红色的四肢";
        person.setLimbs(limbs);
    }


    @Override
    public Person getPerson() {
        System.out.println(person.getHead() + ";" + person.getBody() + ";" + person.getLimbs());
        return person;
    }
}
