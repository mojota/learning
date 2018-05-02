package Builder;

/**
 * 具体建造类
 * @author jamie
 * @date 18-5-2
 */
public class GreenPersonBuilder implements IPersonBuilder {

    Person person = new Person();

    @Override
    public void buildHead() {
        String head = "建造绿色的头部";
        person.setHead(head);
    }

    @Override
    public void buildBody() {
        String body = "建造绿色的身体";
        person.setBody(body);
    }

    @Override
    public void buildLimbs() {
        String limbs = "建造绿色的四肢";
        person.setLimbs(limbs);
    }


    @Override
    public Person getPerson() {
        System.out.println(person.getHead() + ";" + person.getBody() + ";" + person.getLimbs());
        return person;
    }
}
