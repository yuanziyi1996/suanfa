package LeeCode.字符串和数组;

import java.util.ArrayList;

public class 找最小的k个数 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        for(int i=0;i<input.length-1;i++){
            for(int j=0;j<input.length-1-i;j++){
                if(input[j]>input[j+1]){
                    int temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int a[]={1,5,3,5,8,8,2,6,3,85};
        ArrayList<Integer>list=new ArrayList<>();
        list=GetLeastNumbers_Solution(a,5);
        for (int i=0;i<list.size();i++){
            System.out.println("list = " + list.get(i));
        }
    }
}