import java.util.Objects;

/**
 * 方法1：

 　　对数组A进行排序，然后遍历一遍就可以找到第K大的数字。该方法的时间复杂度为O(N*logN)

 方法2：

 　　利用简单选择排序法的思想，每次通过比较选出最大的数字来，
 比较上K次就能找出第K大的数字来。该方法的时间复杂度为O(N*K)，最坏情况下为O(N^2)。

 方法3：　　

 　　这种方法是本文谈论的重点，可以利用快排的思想，首先快排每次执行都能确定一个元素的最终的位置，
 如果这个位置是n-k(其中n是数组A的长度)的话，那么就相当于找到了第K大的元素。设确定的元素位置m的话，
 如果m > n - k大的话，那么第K大的数字一定

 在A[0]~A[m - 1]之间；如果m < n - k的话，那么第K大的数字一定在A[m+1]~A[n - 1]之间。整个过程可以通过递归实现，具体代码如下：
 */
public class 寻找数组中第K大的数字 {
  public static   int Partition(int arr[],int low ,int high)
    {
        int temp = arr[low];
        while(low < high)
        {
            while(low < high && arr[high] >= temp)
                high--;
            arr[low] = arr[high];
            while(low < high && arr[low] <= temp)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = temp;//确定参考元素的位置
        return low;
    }
   public static int  KthElement(int  arr[],int low, int high,int n ,int k)
    {
        if(Objects.isNull(arr) || low >= high || k > n)//边界条件和特殊输入的处理
            return 0;
        int pos = Partition(arr,low,high);
        while(pos != n  - k)
        {
            if(pos > n - k)
            {
                high = pos - 1;
                pos = Partition(arr,low,high);
            }
            if(pos < n - k)
            {
                low = pos + 1;
                pos = Partition(arr,low,high);
            }
        }
        return arr[pos];

    }

    public static int 获取第几大(int a[], int  k){
      return KthElement(a,0,a.length-1,a.length,k);
    }

    public static void main(String[] args) {
        int a[]={1,5,5,7,88,11};
        System.out.println(获取第几大(a,4));
    }
}

