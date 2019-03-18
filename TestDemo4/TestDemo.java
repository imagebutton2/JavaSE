//Lambda表达式方法引用
//4.引用构造方法
interface IUi<R，P1，P2>{

    R createPerson(P1 p1,P2 p2);
   
}
class Person{
    private String name ;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
}




public class TestDemo {

    public static void main(String[] args) {
      
        //引用Person的构造方法

        IUi<Person,String,Integer>iUi=Person::new;

        System.out.println(iUi.createPerson("libao", 10));

        
    }
}
