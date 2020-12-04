import java.util.Arrays;

public class 堆排序 {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 4, 7, 6, 5, 9, 8, 10};
//        MSort(arr); //最小堆
        HSort(arr);//最大堆

        for (int a : arr)
            System.out.print(a + " ");
    }

    // 堆排序
    //进行堆排序方法
    private static void HSort(int[] arr) {
        //1、构建大顶堆  parent 以这里开始是因为 完全二叉树，这是最后一个父节点
        System.out.println(arr);
        for (int parent = (arr.length - 1) / 2; parent >= 0; parent--) {
            MaxHeap(arr, parent, arr.length - 1);
        }
        System.out.println("over ；"+Arrays.toString(arr));
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
        // j< m 是因为m 是整个数组中最大的小标
        for (j = 2 * s + 1; j <= m; j = 2 * j + 1) {   //j=2*s+1为s节点的左孩子，j+1为s节点的右孩子
//            j = 2 * j + 1  这是累加条件 一直找 每次都找到孩子的左节点，
            //j=2*j+1是要找到j的孩子节点
            System.out.println("j == "+j);
            if (j < m && arr[j] < arr[j + 1])
                j++;     //将j指向当前左右孩子节点中的较大值
            if (temp > arr[j])
                break;  //如果s节点的值大于其最大的孩子节点值，则，循环结束，本次不做任何改变
            arr[s] = arr[j];  //否则将较大的孩子节点的值赋值给父节点(也就是 s节点)
            s = j;    //将j的值赋值给s，即j成为了下一波的父节点，继续比较
            System.out.println("jaozo "+Arrays.toString(arr));
        }
        // temp 是最大的哪一个
        arr[s] = temp;  //循环结束 把temp(即是当前节点，）给 s点，s点经过一系列的比较可能会在任意一处，这个地方可以理解为交换
//        上面的 arr[s] = arr[j]; 是把最大值给了s,但是s所在的值还没有给j,由于s==j，所以需要把s所在的值给j 即是s，所以把
//        temp = arr[s]; 所在的值给了j arr[s] = temp;
        System.out.println("构建一次大队  "+Arrays.toString(arr));
    }

    public static void MInHeap(int [] arr,int s,int m){
        int temp, j;
        temp = arr[s];
        for (j = 2 * s + 1; j <= m; j = 2 * j + 1) {   //j=2*s+1为s节点的左孩子，j+1为s节点的右孩子
//            j = 2 * j + 1  这是累加条件 一直找 每次都找到孩子的左节点，
            //j=2*j+1是要找到j的孩子节点
            if (j < m && arr[j] > arr[j + 1])
                j++;     //将j指向当前左右孩子节点中的较大值
            if (temp < arr[j])
                break;  //如果s节点的值大于其最大的孩子节点值，则，循环结束，本次不做任何改变
            arr[s] = arr[j];  //否则将较大的孩子节点的值赋值给父节点
            s = j;    //将j的值赋值给s，即j成为了下一波的父节点，继续比较
            System.out.println("jaozo "+Arrays.toString(arr));
        }
        arr[s] = temp;  //循环结束
        System.out.println("构建一次大队  "+Arrays.toString(arr));
    }

    private static void MSort(int[] arr) {
        //1、构建XIAO
        for (int parent = (arr.length - 1) / 2; parent >= 0; parent--) {
            MInHeap(arr, parent, arr.length - 1);
        }
        System.out.println("over");
        for (int t = arr.length - 1; t > 0; t--) {
            swap(arr, 0, t); //交换数据
            MInHeap(arr, 0, t - 1);   //根节点从0开始，继续构建大顶堆。
        }


    }

}

