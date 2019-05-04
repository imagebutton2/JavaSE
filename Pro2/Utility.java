package MyJava.Pro.Pro2;

import java.util.Scanner;

public class Utility {
    private static Scanner scanner = new Scanner(System.in);

    /*
     * 用于界面菜单的选择，该方法读取键盘，如果用户输入‘1’-‘4’中的任意字符
     * 则方法返回。返回值为用户输入字符*/
    public static char readMenuSelection() {
        char c;
        for (; ; ) {
            String s = readKeyBoard(1);
            c=s.charAt(0);
            if (c != '1' && c != '2' && c != '3' && c != '4'&& c != '5') {
                System.out.println("输入错误，请重新输入");
            }
            else break;

        }
        return c;
    }
    /*
     * 用于确认选择的输入。该方法从键盘读取‘Y’或者‘N’
     * 并将其作为方法的返回值*/
    public static char readConfirmSelection() {
        char c;
        for (; ; ) {
            String str = readKeyBoard(1).toString();
            c = str.charAt(0);
            if (c == 'Y' || c == 'N'||c == 'y'||c == 'n') {
                break;
            } else {
                System.out.println("选择错误，请重新输入：");

            }
        }
        return c;
    }

    private static String readKeyBoard(int limit) {
        String line = "";

        while (scanner.hasNext()) {
            line = scanner.nextLine();
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
                continue;
            }
            break;
        }

        return line;
    }
    public static String readLine(){
        String line = "";
        if(scanner.hasNext()){
            line = scanner.nextLine();
        }else {
            System.out.println("输入格式不正确");
        }
        return line;
    }
}
