
import cn.bitten.java.Reflex.bit.BeanCopy;

class Person{
    private String name=null;
    private Integer age;
    private boolean gander;

    public Person(String name, Integer age, boolean gander) {
        this.name = name;
        this.age = age;
        this.gander = gander;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gander=" + gander +
                '}';
    }
}
class School{
    private String name;
    private String skill;
    private Integer age;

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", skill='" + skill + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TestBeanCopy {
    public static void main(String[] args) throws IllegalAccessException {
        Person person = new Person("Jack", 18, true);
        School school=new School();
        BeanCopy.copy(person,school);
        System.out.println(school);
    }
}
