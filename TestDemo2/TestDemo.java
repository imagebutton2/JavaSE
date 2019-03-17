//Lambda表达式方法引用
//2.引用对象方法
interface IUi<P>{
     P ItoUpperCase();
   
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
      
	 //引用对象方法 public String toUpperCase()
      IUi<String>iUi= "hello"::toUpperCase;
      System.out.println(iUi.ItoUpperCase());

        
    }
}
