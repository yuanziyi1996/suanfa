package LeeCode.字符串和数组;

public class 石子y游戏 {
    public static boolean stoneGame(int[] piles) {
        int l = 0;
        int r = piles.length - 1;
        int sum1 = 0;
        int sum2 = 0;
        while (l < r) {
            if (piles[l] > piles[r]) {
                sum1 += piles[l];
                l++;
                if (piles[l] > piles[r]) {
                    sum2 += piles[l];
                    l++;
                } else {
                    sum2 += piles[r];
                    r--;
                }
            } else {
                sum1 += piles[r];
                r--;
                if (piles[l] > piles[r]) {
                    sum2 += piles[l];
                    l++;
                } else {
                    sum2 += piles[r];
                    r--;
                }
            }
        }
        return sum1 > sum2;
    }

    public static void main(String[] args) {
        int a[] = {5, 3, 4, 5, 3, 4};
        System.out.println(stoneGame(a));
    }
}
