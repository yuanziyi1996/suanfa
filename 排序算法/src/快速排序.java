import java.util.Arrays;

public class 快速排序 {
    public static void sort(int a[], int low, int high){
        if(low>high)
            return;
        int i=low;
        int j=high;
        int key=a[low];
            while(i<j){
                while(i<j&&key<=a[j]){
                    j--;
                }
                while(i<j&&key>=a[i]){
                    i++;
                }
                if(i<j){//把从右往前比key小的第一个数和，从左往后比key大的第一个数进行交换
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=a[i];
                }
            }
            //交换key的值，这时候把i处的值设置为key
        int temp=a[i];
            a[i]=a[low];
            a[low]=temp;
            sort(a,low,i-1);
            sort(a,i+1,high);

    }

    public static void main(String[] args) {
        int a[]={1,3,2,5,4,6,9,7,8};
        sort(a,0,8);
        System.out.println(Arrays.toString(a));
    }
    }

