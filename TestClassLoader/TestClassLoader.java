
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestClassLoader {
    

    public static void main(String[] args) {
		
        String className = "com.bittech.classloader.Member";
		
        Class classz = new MyClassLoader().loadData(className);
        
        try {
            Class classz2 = Class.forName(className);
            
            //同一个类，由不同的类加载器所加载
			
            //Class对象就不相等了
			
            System.out.println(classz.getClassLoader());
			
            System.out.println(classz2.getClassLoader());
			
            System.out.println(classz == classz2);
            
        } catch (ClassNotFoundException e) {
			
            e.printStackTrace();
        }
    }
}

class Member {
    
    @Override
    public String toString() {
        return "Member";
    }
}


// className -> class fil e -> byte[] -> defineClass Class
class MyClassLoader extends ClassLoader {
    
    public Class loadData(String className) {
		
        byte[] data = classBytes(className);
		
        return super.defineClass(className, data, 0, data.length);
    }

    private byte[] classBytes(String className) {

        String classPath = "E:\\worskpace\\java7_code\\javase-329";
        
        String classFile = classPath + "\\" + className.replace(".", "\\") + ".class";

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        
		try (FileInputStream in = new FileInputStream(classFile)) {
            
			byte[] buff = new byte[1024];
            
			int len = -1;
            
			while ((len = in.read(buff)) != -1) {
                
				out.write(buff, 0, len);
            
			}
        } 
		catch (IOException e) {
			
        }
        return out.toByteArray();
        
    }
}
