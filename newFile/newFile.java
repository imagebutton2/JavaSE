//创建一个新文件
public class TestFile {

    public static void main(String[] args) {
        File file = new File("D:\\Test\\java.java");
        //File file = new File("D:\\Test","java.java");
        boolean rs = false;
        try {
            rs=file.createNewFile();//创建一个新文件

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(rs){
            System.out.println("文件创建成功");
        }else {
            System.out.println("文件创建失败");
        }

    }
}