//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public static void main(String[] args) {
        int[] array={2,4,3,6,3,2,5,5};
        int num1[] =new int[1];
        int num2[]=new int[1];
        long start = System.currentTimeMillis();
        FindNumsAppearOnce(array,num1,num2);
        System.out.println("num1 = " + num1[0]);
        System.out.println("num2 = " + num2[0]);
        for(int x=1;x<100000;x++){
            if(x==100000){
                break;
            }
        }
        System.out.println(System.currentTimeMillis()-start);
        System.out.println("haha");
    }

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        for(int i=0;i<array.length;i++){
            int count=0;
            for(int j=0;j<array.length;j++){
                if(array[i]==array[j]){
                    count++;
                }
            }
            if(count==1){
                if(num1[0]>0){
                    num2[0]=array[i];
                }else{
                    num1[0]=array[i];
                }
            }

        }
    }
}