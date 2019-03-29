

//10个人投票选班长，有三个侯选人(张三，李四，王五)，通过编号投票，要求最后显示班长姓名。
import java.util.*;
public class Work {
	public static void main(String[] args) {
		//设定投票人数
		System.out.print("设定投票人数：");
		Scanner sr=new Scanner(System.in);
		int a=sr.nextInt();
		System.out.print("请输入第1位侯选人的名字：\n");
		Scanner sr1=new Scanner(System.in);
		String i1=sr1.nextLine();//键盘接收字符串
		System.out.print("请输入第2位侯选人的名字：\n");
		Scanner sr2=new Scanner(System.in);
		String i2=sr2.nextLine();
		System.out.print("请输入第3位侯选人的名字：\n");
		Scanner sr3=new Scanner(System.in);
		String i3=sr3.nextLine();
		System.out.println("本次选举将有"+ a +"人参与!");
		System.out.println("1号:"+i1+"\t2号:"+i2+"\t3号:"+i3);
		Xuanju tp=new Xuanju();
		tp.tp(a,i1,i2,i3);
	}
}
class Xuanju{
	public void tp(int a,String i1,String i2,String i3){
		int j1=0,j2=0,j3=0,qq=0;//计票器
		for (int i=1;i<=a;i++){ //统计投票
			System.out.println("请投票，投票请按1,2,3：");
			Scanner tp=new Scanner(System.in);
			int b=tp.nextInt();
			System.out.println("已有"+ i +"人投票");
			switch (b){
				case 1:
					j1++;
					break;
				case 2:
					j2++;
					break;
				case 3:
					j3++;
					break;
				default:
					qq++;
					break;
			}
		}
		
		if(j1>j2&&j1>j3){
			System.out.println(i1 +"得"+ j1 +"票\n"+ i2 +"得"+ j2 +"票\n"+ i3 +"得"+ j3 +"票\n"+"弃权票数"+qq);
			System.out.println("恭喜" + i1 + "当选班长!");
		}else if(j1<j2&&j2>j3){
			System.out.println(i1 +"得"+ j1 +"票\n"+ i2 +"得"+ j2 +"票\n"+ i3 +"得"+ j3 +"票\n"+"弃权票数"+qq);
			System.out.println("恭喜" + i2 + "当选班长!");
		}else if(j3>j1&&j2<j3){
			System.out.println(i1 +"得"+ j1 +"票\n"+ i2 +"得"+ j2 +"票\n"+ i3 +"得"+ j3 +"票\n"+"弃权票数"+qq);
			System.out.println("恭喜" + i3 + "当选班长!");
		}else {
			System.out.println(i1 +"得"+ j1 +"票\n"+ i2 +"得"+ j2 +"票\n"+ i3 +"得"+ j3 +"票\n"+"弃权票数"+qq);
			System.out.println("有同等票数，投票无效重新投票!");
		}
	}
}