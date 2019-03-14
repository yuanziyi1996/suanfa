import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 冒泡排序 {
    public static void maopao(int a[]){
        //int temp;
        for(int i=0;i<a.length;i++){
            for (int j=0;j<a.length-i-1;j++){
                if(a[j]>a[j+1])
                {
                    /*temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;*/
                    swap(a,j,j+1);

                }
            }
        }
    }
     public static void swap(int a[],int i,int j){
         int temp=a[j];
         a[j]=a[i];
         a[i]=temp;
     }

    public static void main(String[] args) {
        int a[]={1,8,3,6,9,4,5,2,7,9};
        maopao(a);
        System.out.println(Arrays.toString(a));

    }

}

