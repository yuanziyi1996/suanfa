import java.util.Arrays;

public class 排序之快速排序 {
    public static void sort(int a[], int low, int high){
        int i=low;
        int j=high;
        int key=a[low];

        if (low < high){
            while(i<j){ // 此处的while循环结束，则完成了元素key的位置调整
                while(i<j&&key<=a[j]){
                    j--;
                }
                a[i]=a[j];
                while(i<j&&key>=a[i]){
                    i++;
                }
                a[j]=a[i];
                a[i]=key;  //此处不可遗漏
            }
            sort(a,low,i-1);
            sort(a,i+1,high);
        }
    }

    public static void main(String[] args) {
        int a[]={1,2,5,1,54,9,53,8,3,75};
        sort(a,0,a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
