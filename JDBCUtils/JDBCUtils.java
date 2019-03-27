import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 这个类是jdbc的工具类
 * 提供getConnection方法
 * 提供close方法
 * 开发步骤：
 * 1.私有化构造函数，防止外界直接new对象
 * 2.提供getConnection，用来对外界提供获取数据连接
 * 3.提供close方法，用来关闭资源
 * 4.测试
 * @date 
 *
 */
public class JDBCUtils {
    //将读取属性文件放在静态代码块中
    //保证文件只被读取一次，节省资源
    static Properties prop =null;
    static{
        try{
            //读取配置文件jdbc.properties
            prop = new Properties();
            String pathname="jdbc.properties";
            prop.load(new FileInputStream(pathname));
        }catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    //1.私有化构造函数，
    // 防止外界直接new对象
    private JDBCUtils(){}
    //2.提供getConnection，
    // 用来对外界提供获取数据连接
    public static Connection getConnection(){
        try {
            //1.注册驱动
            Class.forName(
                    prop.getProperty("driverClass"));
            //2.获取数据库连接
            Connection conn = DriverManager.getConnection(
                    prop.getProperty("jdbcUrl"),
                    prop.getProperty("user"),
                    prop.getProperty("password"));
            return conn;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    // 3.提供close方法，用来关闭资源
    public static void close(Connection conn,Statement st,ResultSet rs){

        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                //保证资源一定会被释放
                conn=null;
            }
        }

        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                //保证资源一定会被释放
                st=null;
            }
        }

        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally{
                //保证资源一定会被释放
                rs=null;
            }
        }
    }
}
