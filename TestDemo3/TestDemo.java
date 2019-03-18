//Lambda表达式方法引用
//3. 引用类中普通方法
interface IUi<R，P>{
    R compare(P p1, P p2)；
   
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
      
     //引用类的普通方法  public int compareTo(String str1,String str2)
          IUi<Integer, String> iUi = String::compareTo;
          System.out.println(iUi.compare("LIU","LI"));

        
    }
}
