package LeeCode.字符串和数组;

import java.util.ArrayList;

public class 和为某个值得连续正数序列 {

        public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

            ArrayList<ArrayList<Integer> > list2 = new ArrayList<ArrayList<Integer> >();
            for(int i =1;i<=(sum+1)/2;i++){
                ArrayList<Integer> list1=new ArrayList<Integer>();
                if(!list1.isEmpty())
                    list1.clear();
                int temp=0;
                for(int j =i;j<=(sum+1)/2;j++){
                    list1.add(j);
                    temp+=j;
                    if(temp==sum&&list1.size()>1){
                        list2.add(list1);

                    }
                }
            }
            return list2;
        }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        list =FindContinuousSequence(80);
        System.out.println("list = " + list.size());
        /*for (int i=0;i<list.size();i++) {
            for (ArrayList<Integer> integers : list) {
                System.out.println("integers = " + integers);
            }
        }*/

    }

}
