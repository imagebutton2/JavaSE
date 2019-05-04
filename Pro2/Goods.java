package MyJava.Pro.Pro2;

public class Goods {
    private Integer id;
    private String goodsName;
    private double price;

    public Goods(int id, String goodsName, double price) {

        this.id = id;
        this.goodsName = goodsName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getPrice() {
        return price;
    }



    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "  "+id+"\t\t"+"  "+goodsName+"\t"+price;
    }

}
