import org.junit.Test;

public class 堆排序 {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 4, 7, 6, 5, 9, 8, 10};
        HSort(arr);

        for (int a : arr)
            System.out.print(a + " ");
    }

    // 堆排序
    //进行堆排序方法
    private static void HSort(int[] arr) {
        //1、构建大顶堆
        for (int parent = (arr.length - 1) / 2; parent >= 0; parent--) {
            MaxHeap(arr, parent, arr.length - 1);
        }
        for (int t = arr.length - 1; t > 0; t--) {
            swap(arr, 0, t); //交换数据
            MaxHeap(arr, 0, t - 1);   //根节点从0开始，继续构建大顶堆。
        }
    }

    //交换数据方法
    private static void swap(int[] arr, int i, int t) {
        int temp = arr[i];
        arr[i] = arr[t];
        arr[t] = temp;
    }

    /*
     * 构建大顶堆的方法
     * s 代表拥有左右孩子节点的节点，即本次要调整位置的节点
     * m 代表当前堆的长度
     */
    private static void MaxHeap(int[] arr, int s, int m) {
        int temp, j;
        temp = arr[s];
        for (j = 2 * s + 1; j <= m; j = 2 * j + 1) {   //j=2*s+1为s节点的左孩子，j+1为s节点的右孩子
            //j=2*j+1是要找到j的孩子节点
            if (j < m && arr[j] < arr[j + 1])
                j++;     //将j指向当前左右孩子节点中的较大值
            if (temp > arr[j])
                break;  //如果s节点的值大于其最大的孩子节点值，则，循环结束，本次不做任何改变
            arr[s] = arr[j];  //否则将较大的孩子节点的值赋值给父节点
            s = j;    //将j的值赋值给s，即j成为了下一波的父节点，继续比较
        }
        arr[s] = temp;  //循环结束
    }

}

