
import java.io.*;

public class TestFileStream {
    
 
    
     public static void main(String[] args) {
        //字符流
        //1.准备文件
        File file = new File("D:" + File.separator + "test" +
                File.separator + "java7" + File.separator + "writer.txt");
        try (Writer writer = new FileWriter(file)) {
            writer.append('A').append('B');
            writer.write("hello");
            writer.write("\n");
            writer.write("!!");
            writer.write("I老虎U！!");
            //ABhello
            //!!I老虎U！!
            writer.flush();
        } catch (IOException e) {
        
        }
    }
    
   public static void main(String[] args) {
        //字符流
        //1.准备文件
        File file = new File("D:" + File.separator + "test" +
                File.separator + "java7" + File.separator + "writer.txt");
        
        if (file.isFile() && file.exists()) {
            try (Reader reader = new FileReader(file)) {
                //1024 2048 2K 4K
               /*
                char[] buff = new char[1024];
                
                int len = reader.read(buff);
                System.out.println("读取的长度："+len);
                System.out.println("读取的内容：");
                System.out.println(new String(buff));
              */
                //字节流和字符流的输入流的读取，常用模式
                char[] buff = new char[5];
                int len = -1;
                while ((len = reader.read(buff)) != -1) {
                    System.out.print(new String(buff, 0, len));
                }
            } catch (IOException e) {
            
            }
        }
    }
    
    public static void main(String[] args) {
        
        /**
         * 字节流转换字符流
         *
         * byte  stream ----> char stream
         *
         * 编码  byte -> char
         * 解码  char ->  byte
         *

         */
        String file = "D:" + File.separator + "test" +
                File.separator + "java7" + File.separator + "writer.txt";
        try (OutputStream out = new FileOutputStream(file);
           
             //StreamEncoder byte -> char  charset字符编码
             //StreamDecoder
             OutputStreamWriter writer = new OutputStreamWriter(out);) {
           
            writer.write("hello world ！！！");
            writer.flush();
            
        } catch (IOException e) {
        
        }
        
        
    }
    
    
}
