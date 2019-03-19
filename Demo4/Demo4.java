public class Demo4 {
	public static void main(String[]args){
		Cfb jiu=new Cfb();
		jiu.cf();

}
}
class Cfb{
	public  void cf(){
		try{
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			System.out.println("请输入1-9，按0退出：");
			String al=br.readLine();
			int num1=Integer.decode(al);
			for(int i=1;i<num1;i++){
				for(int j=1;j<=i;j++){
					System.out.print(i+"*"+j+"="+(i*j)+"\t");
				}
				System.out.println();
			}
		}catch(Exception e){
			e.printStackTrace();
				}
			}
		}
