package MyJava.Pro.Pro2;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class CommodityManage {
    private static AtomicInteger atomicInteger;
    private static ArrayList<Goods> goodsArrayList;

    public CommodityManage() {
        atomicInteger=new AtomicInteger(0);
        goodsArrayList=new ArrayList<>();
    }


    public void addGoods(String goodsName, double price){
        Goods goods=new Goods(atomicInteger.getAndIncrement(),goodsName,price);
        if(goods!=null){
            goodsArrayList.add(goods);
        }

    }
    public  void removeGoods(int index){
        if(index<=goodsArrayList.size()-1) {
            int move=goodsArrayList.size()-1-index;
            goodsArrayList.remove(index);
            atomicInteger.getAndDecrement();
        }else {
            System.out.println("商品ID不存在");
        }
    }
    public Goods searchGoods(int index){
        Goods goods=null;
        if(index<=goodsArrayList.size()-1) {
          goods=goodsArrayList.get(index);
        }else {
            System.out.println("商品ID不存在");
        }
        return goods;
    }
//    public Goods searchGoods(String name){
//       if(goodsArrayList.contains(name)){
//           if(null==name){
//               for (int i=0;i<goodsArrayList.size();i++){
//                   if(goodsArrayList.get(i)==null)
//                       return goodsArrayList.get(i);
//               }
//           }
//           else{
//               for(int i=0;i<goodsArrayList.size();i++){
//                   if(name.equals(goodsArrayList.get(i).getGoodsName()))
//                       return goodsArrayList.get(i);
//               }
//           }
//       }
//       return null;
//    }
    public void setGoods(int index,String name,double price){
        if(index<=goodsArrayList.size()-1) {
          Goods goods= goodsArrayList.get(index);
          goods.setGoodsName(name);
          goods.setPrice(price);
        }else {
            System.out.println("商品ID不存在");
        }

    }
    public void toPrint(){
        Goods goods=null;
      for(int i=0;i<goodsArrayList.size();i++){
          goods=goodsArrayList.get(i);
          System.out.println(goods);
      }
    }
    public  Goods curGood(){
        if(goodsArrayList.size()!=0){
            return goodsArrayList.get(goodsArrayList.size()-1);
        }else {
            return null;
        }
    }

}
