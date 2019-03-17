
//Lambda表达式方法引用
//1.引用静态方法

interface IUi<R,P1,P2>{
     R Ivalueof(P p);
  
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
       // public static String valueOf(Object obj)
	   //引用静态方法
		IUi <Integer,String>iUi=String::valueOf;
        System.out.println(iUi.Ivalueof(10));

    }
}
