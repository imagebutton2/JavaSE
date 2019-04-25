package com.DS;


import java.util.Arrays;

//二分查找
//数组必须有序
public class TestBinarySeach {
    public static int binarySeach(int arr[],int key){
        Arrays.sort(arr);
        int begin=0;
        int end=arr.length-1;
        while (begin<=end){
            int mid=(begin+end)>>1;
            if(arr[mid]==key){
                 return mid;
            }else {
                if(arr[mid]>key){
                    end=mid-1;
                }else {
                    begin=mid+1;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int []arr=new int []{10,30,20,5,8,63,50,47,123,55,11};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int index=binarySeach(arr,100);
        System.out.println(index);
    }
}
