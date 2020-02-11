package LeeCode.字符串和数组;

public class 求逆序对 {
    public static  int InversePairs(int [] array) {
        int count=0;
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    count ++;
                }

            }
        }
        return  count%1000000007;
    }

    public static void main(String[] args) {
        int a[]={1,2,3,4,5,6,7,0};
        System.out.println(InversePairs(a));
    }
}
