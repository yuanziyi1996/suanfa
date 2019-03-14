import java.util.Arrays;

public class 直接选择排序 {
    public static void selectsort(int[] a)
    {
        int temp;
        for(int i=0;i<a.length;i++)
        {
            //内层循环j=i+1,外层循环控制着循环次数。即每趟中a[i]这个值就是本趟的最小值。i位置上是最小值
            for(int j=i+1;j<a.length;j++)
            {
                if(a[i]>a[j])
                {
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int a[]={1,8,3,6,4,5,2,7,9,0};
        selectsort(a);
        System.out.println(Arrays.toString(a));
    }
}

