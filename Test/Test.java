public class Test {
	//class的反射
    
	public static void main(String[] args) throws Exception {
       //正向处理
       Date date = new Date();
       System.out.println(date);
       //取得Date类的Class对象
       Class<Date> cls = (Class<Date>) date.getClass();
       System.out.println(cls);      
       System.out.println(Date.class);        
       Class cls1 = Class.forName("java.util.Date");
       Class<Date> cls2 = Date.class;
       Date date = cls2.newInstance();
       System.out.println(date);
       Class<Test> cls = Test.class;
    }
}
