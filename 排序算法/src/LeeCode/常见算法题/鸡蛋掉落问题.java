package LeeCode.常见算法题;

/**
 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。

 每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。

 你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。

 每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。

 你的目标是确切地知道 F 的值是多少。

 无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？
 */
public class 鸡蛋掉落问题 {
        /**
         * 如果你有remainTestCount个测试机会（扔鸡蛋的机会 或者移动的次数），eggsCount个鸡蛋，这时我们任意选择在第x层扔鸡蛋，如果鸡蛋没碎，这时你还剩余remainTestCount - 1次机会，eggsCount个鸡蛋，我们可以确定x下面的getConfirmFloors(remainTestCount - 1, eggsCount) 层
         如果鸡蛋碎了，这时你还剩余remainTestCount - 1次机会，eggsCount - 1个鸡蛋，我们可以确定getConfirmFloors(remainTestCount - 1, eggsCount - 1)层，并且x层也被确定了
         因此可以得出规律：

         getConfirmFloors(remainTestCount, eggsCount) = getConfirmFloors(remainTestCount - 1, eggsCount) + getConfirmFloors(remainTestCount - 1, eggsCount - 1) + 1

         其中getConfirmFloors(remainTestCount, eggsCount) 表示的是在remainTestCount个测试机会（扔鸡蛋的机会 或者移动的次数），eggsCount个鸡蛋可以确定的楼层数量
         ————————————————
         版权声明：本文为CSDN博主「hestyle」的原创文章，遵循 CC 4.0 BY 版权协议，转载请附上原文出处链接及本声明。
         原文链接：https://blog.csdn.net/qq_41855420/article/details/91996663
         */
     public  static    int superEggDrop(int K, int N) {
            int remainTestCount = 1;//穷举移动次数（测试的次数）
            while (getConfirmFloors(remainTestCount, K) < N){
                ++remainTestCount;
            }
            return remainTestCount;
        }
    //在remainTestCount个测试机会（扔鸡蛋的机会 或者移动的次数），eggsCount个鸡蛋可以确定的楼层数量
    public static    int getConfirmFloors(int remainTestCount, int eggsCount){
        if (remainTestCount == 1 || eggsCount == 1){
            //如果remainTestCount == 1你只能移动一次，则你只能确定第一楼是否，也就是说鸡蛋只能放在第一楼，如果碎了，则F == 0，如果鸡蛋没碎，则F == 1
            //如果eggsCount == 1鸡蛋数为1，它碎了你就没有鸡蛋了，为了保险，你只能从第一楼开始逐渐往上测试，如果第一楼碎了（同上），第一楼没碎继续测第i楼，蛋式你不可能无限制的测试，因为你只能测试remainTestCount次
            return remainTestCount;
        }
        return getConfirmFloors(remainTestCount - 1, eggsCount - 1) + 1 + getConfirmFloors(remainTestCount - 1, eggsCount);
    }


    public static void main(String[] args) {
        System.out.println(superEggDrop(3,2));
    }
}
