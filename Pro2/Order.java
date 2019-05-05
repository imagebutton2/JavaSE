package MyJava.Pro.Pro2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private int orderId ;
    private int size;
    private List<Goods> items;
    private List<Integer> itemsNumber;
    private int currentIndex;
    private AtomicInteger integer=new AtomicInteger(0);
    public Order() {
        this.orderId = integer.getAndIncrement();
        this.items = new ArrayList<>();
        this.itemsNumber = new ArrayList<>();
        this.currentIndex = -1;
    }
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void add(int goodsId, int num) {
        Goods goods=CommodityManage.searchGoods(goodsId);
        this.items.add(goods);
        this.itemsNumber.add(num);
        currentIndex++;
        size++;
    }
    public void set(int id,int goodsId, int num){
        int index=search(id);
        if(index>0){
            Goods goods=CommodityManage.searchGoods(goodsId);
            items.set(index,goods);
            itemsNumber.set(index,num);
        }
    }
    private  int search(int id){
        int begin = 0;
        int end = items.size() - 1;
        while (begin <= end) {
            int mid = (begin + end) >> 1;
            if (items.get(mid).getId() == id) {
                return mid;
            } else if (items.get(mid).getId() > id) {
                end = mid - 1;
            } else{
                begin = mid + 1;
            }
        }
        return -1;
    }
    public  void toPrintId(){
        System.out.println(" 订单中商品的id--------商品id");
        if(items!=null){
            for(int i=0;i<items.size();i++){
                System.out.println(i+"   "+items.get(i).getId());
            }
        }
    }


    public int getCurrentIndex() {
        return currentIndex;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderId);
    }

    public int getSize() {
        return this.currentIndex + 1;
    }
    public double getTotalPrice() {
        double var1 = 0.0D;

        for(int i = 0; i < this.items.size(); i++) {
            Goods var = this.items.get(i);
            if (var != null) {
                var1 += (double)this.itemsNumber.get(i) * var.getPrice();
            }
        }

        return var1;
    }



    public void printOrder() {
        System.out.println("===============================");
        System.out.println("编号: " + this.getOrderId());
        System.out.println("打印时间: " + LocalDate.now().toString());
        System.out.println("===============================");
        System.out.println("编号     名称      数量     单价");

        for(int var1 = 0; var1 < this.items.size(); ++var1) {
            Goods var2 = this.items.get(var1);
            if (var2 != null) {
                int var3 = this.itemsNumber.get(var1);
                if (var3 > 0) {
                    System.out.println(String.format("%2d\t%s\t%d\t%.2f", var2.getId(), var2.getGoodsName(), var3, var2.getPrice()));
                }
            }
        }

        System.out.println("===============================");
        System.out.println(String.format("总价: %.2f", this.getTotalPrice()));
        System.out.println("===============================");
    }
}
