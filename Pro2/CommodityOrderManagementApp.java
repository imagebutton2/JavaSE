package MyJava.Pro.Pro2;

public class CommodityOrderManagementApp {
    static CommodityManage  commodityManage=new CommodityManage();
    public void menu_0(){
        System.out.println("----------1.商品管理菜单----------");
        System.out.println();
        System.out.println("----------2.订单管理菜单----------");
        System.out.println();
        System.out.println("-------------3.关于---------------");
        System.out.println();
        System.out.println("-------------4.退出---------------");

    }
    public void menu() {

        boolean Flag = true;
        do {
            menu_0();
            char key = Utility.readMenuSelection();
            switch (key) {
                case '1':
                    menu1();
                    break;
                case '2':
                    menu2();
                    break;
                case '3':
                    System.out.println("GJZ");
                    break;
                case '4':
                    System.out.println("确认是否退出(Y/N)：");
                    char yn = Utility.readConfirmSelection();
                    if (yn == 'Y' || yn == 'y') Flag = false;
                    break;
            }
        } while (Flag);
    }
    private void menu2_2(){
        System.out.println("-----1.创建订单-----");
        System.out.println();
        System.out.println("-----2.添加商品-----");
        System.out.println();
        System.out.println("-----3.修改商品-----");
        System.out.println();
        System.out.println("-----4.查询订单-----");
        System.out.println();
        System.out.println("-----5.返回上层-----");

    }
    private void menu2() {

        boolean Flag2 = true;
        do {
            menu2_2();
            char key = Utility.readMenuSelection();
            switch (key) {
                case '1':
                    System.out.println("创建订单");
                    break;
                case '2':
                    System.out.println("添加商品");
                    break;
                case '3':
                    System.out.println("修改商品");
                    break;
                case '4':
                    System.out.println("查询订单");
                    break;
                case '5':
                    if(key=='5')Flag2 = false;
                    System.out.println("返回上层");
            }
        } while (Flag2);
    }
    private void menu1_1(){
        System.out.println("-----1.添加商品-----");
        System.out.println();
        System.out.println("-----2.修改商品-----");
        System.out.println();
        System.out.println("-----3.删除商品-----");
        System.out.println();
        System.out.println("-----4.查询商品-----");
        System.out.println();
        System.out.println("-----5.返回上层-----");
    }
    private void menu1() {
        boolean Flag1 = true;
        do {
            menu1_1();
            char key = Utility.readMenuSelection();
            switch (key) {
                case '1':
                    System.out.println("添加商品:");
                    System.out.println("请输入商品的名称:");
                    String name=Utility.readLine();
                    System.out.println("请输入商品的价格:");
                    double price=Double.parseDouble(Utility.readLine());
                    commodityManage.addGoods(name,price);
                    System.out.println("商品id"+"\t"+"商品名称"+"\t"+"商品价格");
                    System.out.println(commodityManage.curGood());
                    break;
                case '2':
                    System.out.println("修改商品");
                    System.out.println("商品id"+"\t"+"商品名称"+"\t"+"商品价格");
                    commodityManage.toPrint();
                    System.out.println("请输入商品的id:");
                    int index=Integer.parseInt(Utility.readLine());
                    System.out.println("请输入商品的名称:");
                    String name1=Utility.readLine();
                    System.out.println("请输入商品的价格:");
                    double price1=Double.parseDouble(Utility.readLine());
                    commodityManage.setGoods(index,name1,price1);
                    System.out.println("商品id"+"\t"+"商品名称"+"\t"+"商品价格");
                    System.out.println(commodityManage.curGood());
                    break;
                case '3':
                    System.out.println("删除商品");
                    System.out.println("商品id"+"\t"+"商品名称"+"\t"+"商品价格");
                    commodityManage.toPrint();
                    System.out.println("请输入商品的id:");
                    int index1=Integer.parseInt(Utility.readLine());
                    commodityManage.removeGoods(index1);
                    System.out.println("删除成功");
                    System.out.println("商品id"+"\t"+"商品名称"+"\t"+"商品价格");
                    commodityManage.toPrint();
                    break;
                case '4':
                    System.out.println("查询商品");
                    System.out.println("商品id"+"\t"+"商品名称"+"\t"+"商品价格");
                    commodityManage.toPrint();
                    System.out.println("请输入商品的id:");
                    int index2=Integer.parseInt(Utility.readLine());
                    System.out.println("商品id"+"\t"+"商品名称"+"\t"+"商品价格");
                    System.out.println(commodityManage.searchGoods(index2));
                    break;
                case '5':
                    if(key=='5')Flag1 = false;
                    System.out.println("返回上层");
            }
        } while (Flag1);
    }
}
