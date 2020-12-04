package LeeCode.树;

import java.util.Arrays;

/**
 * @author xiaoshi on 2018/10/14.
 */
public class 寻找topN {

    // 父节点
    private int parent(int n) {
        return (n - 1) / 2;
    }

    // 左孩子
    private int left(int n) {
        return 2 * n + 1;
    }

    // 右孩子
    private int right(int n) {
        return 2 * n + 2;
    }

    // 构建堆
    public void buildHeap(int n, int[] data) {
        for(int i = 1; i < n; i++) {
            int t = i;
            // 调整堆
            /**
             * 从序号为 1  即使根节点的左孩子开始， 如果  孩子的父亲大于他，就交换，然后把当前的节点
             * 改为 孩子的父节点，再次同样判断，指导 当前节点为根节点或者是 父节点值比他小
             *
             * 之所以没有 用右孩子判断，是因为循环构建的时候总会 遍历到右孩子，
             *
             * 最终，构成最小堆。
             */
            while(t != 0 && data[parent(t)] > data[t]) {
                int temp = data[t];
                data[t] = data[parent(t)];
                data[parent(t)] = temp;
                t = parent(t);
            }
        }
    }

    // 调整data[i]
    private void adjust(int i, int n, int[] data) {
        if(data[i] <= data[0]) {
            return;
        }
        // 置换堆顶
        int temp = data[i];
        data[i] = data[0];
        data[0] = temp;
        // 调整堆顶
        int t = 0;
        //进入循环，左孩子的下表小于n 且当前节点的值大于左孩子  或
        //         右孩子的下表小于n 且当前节点的值大于右孩子
        while( (left(t) < n && data[t] > data[left(t)])
                || (right(t) < n && data[t] > data[right(t)]) ) {
            if(right(t) < n && data[right(t)] < data[left(t)]) {
                // 右孩子更小，置换右孩子
                temp = data[t];
                data[t] = data[right(t)];
                data[right(t)] = temp;
                t = right(t);
            } else {
                // 否则置换左孩子
                temp = data[t];
                data[t] = data[left(t)];
                data[left(t)] = temp;
                t = left(t);
            }
        }
    }

    // 寻找topN，该方法改变data，将topN排到最前面
    public int[] findTopN(int n, int[] data) {
        // 先构建n个数的小顶堆
        buildHeap(n, data);
        // n往后的数进行调整
        System.out.println(Arrays.toString(data));
        for(int i = n; i < data.length; i++) {
            adjust(i, n, data);
            System.out.println("调整::"+Arrays.toString(data));
        }

        int [] result = new int[n];
        for(int j = 0;j<n;j++){
            result[j] = data[j];
        }
        return result;
    }

    // 打印数组
    public void print(int[] data) {
        for(int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }




}

class main {
    public static void main(String[] args) {
        寻找topN topn = new 寻找topN();

        int size = 10;
        int a[] = {8,6,2,7,1,3,9,5,4,10};
//        for (int i = 0; i < size; i++) {
//            a[i]=(int) (Math.random()*size);
//        }
        System.out.println(Arrays.toString(a));

        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(topn.findTopN(6,a)));
        System.out.println("spend time = "+ (System.currentTimeMillis() - start));

        System.out.println(Arrays.toString(a));
    }




}