
import java.io.*;

public class TestFileStream {
    
     public static void main(String[] args) {
        //File -> path
        //1.准备文件  文件可以不存在，目录必须有
        File file = new File("D:" + File.separator + "test" + File.separator + "java7" + File.separator + "hello.txt");
        
        OutputStream out = null;
        try {
            //2.创建输出流对象
            out = new FileOutputStream(file);
            
            //3.输出内容
            //字节数组
            out.write("hello java!".getBytes());
            out.write("\n".getBytes());
            out.write("good".getBytes());
            out.write("\n".getBytes());
            
            //单字节
            //49->1
            //65->A
            //97->a
            out.write(49);
            
            //字节数组的部分内容
            out.write("\n".getBytes());
            out.write("hello".getBytes(), 1, 2);
            
            //4.刷新
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭流
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
     public static void main(String[] args) {
        //File -> path
        //1.准备文件  文件可以不存在，目录必须有
        File file = new File("D:" + File.separator + "test" + File.separator + "java7" + File.separator + "hello.txt");
        if (file.isFile() && file.exists()) {
            try (InputStream in = new FileInputStream(file)) {
                
                /*
                int b = in.read();
                System.out.println(b);
                byte[] buff = new byte[5];
                int len = in.read(buff,2,3);
                System.out.println("读取的长度：" + len);
                System.out.println("读取的内容：" + new String(buff));
                */
                //System.out.println(in.available());
                
                /*
                byte[] buff = new byte[in.available()];
                in.read(buff);
                System.out.println(new String(buff));
                */
                
                byte[] buff = new byte[3]; //4 => 3,3,3,2
                int len = -1;
                while ((len = in.read(buff)) != -1) {
                    //Hel
                    //loW
                    //orl
                    //d!l
                    System.out.print(new String(buff, 0, len));
                }
            } catch (IOException e) {
            
            }
        }
    }
} 