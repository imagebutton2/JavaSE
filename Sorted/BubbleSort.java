package com.DS.Sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr=new int[] {5,7,2,9,4,1,0,5,7};
		System.out.println(Arrays.toString(arr));
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	//冒泡排序
	/**
	 * 5,7,2,9,4,1,0,5,7		共需要比较length-1轮
	 * 5,7,2,9,4,1,0,5,7	
	 * 5,2,7,9,4,1,0,5,7
	 * 5,2,7,4,1,0,5,7,9
	 * 2,5   
	 */
	//两两比较
	//每轮找出最大或最小的放到后面
	public static void bubbleSort(int[]  arr) {
		//比较多少轮 n-1轮
		for(int i=0;i<arr.length-1;i++){
			boolean sorted=true;
			//控制比较的次数
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
					sorted=false;
				}
			}
			if(sorted){
				break;
			}

		}
	}

}
