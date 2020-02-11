package LeeCode.字符串和数组;

public class 字符串中最长的回文字符串 {
    /**
     * 判断是否是回文字符串
     * @param string
     * @return
     */
    public static boolean isPlalindrome(String string){
        int right = string.length()-1;
        int left = 0;
        char[] array=string.toCharArray();
        if(array.length == 0){
            return true;
        }

        while (left<right){
            if(array[left++]!=array[right--]){
                return false;
            }
        }
        return true;
    }

    /**
     * 求解字符串中的最长回文串-----动态规划法O(n^2)
     * 实现思路:用一个boolean类型的二维数组isPlalindrome[i][j] 来表示i到j之间的字符串是否回文
     * 其中 i>=j
     * 动态规划的初值就是  当i=j时，isPlalindrome[i][j]=true;
     * 动态规划的推导公式为  当i=j+1时，isPlalindrome[i][j]=(oriArray[i]==oriArray[j]),相邻两元素是否相等
     * 					当i>j+1时，需要判断i与j之间的子串是否是回文串,即
     * 							isPlalindrome[i][j]=(oriArray[i]==oriArray[j])&&isPlalindrome[i+1][j-1]
     * PS:状态矩阵赋值过程必须使用左下三角的形式  否则会产生误判 使用了未赋值的位置
     * @param s
     * @return
     */
    public static String maxPlalindrome(String s){
        if(s == null || s.length() ==0){
            return null;
        }

        if(s.length() == 1){
            return s;
        }

        int start = 0;
        int end = 0;
        char[] array = s.toCharArray();
        int length = array.length;
        boolean[][] isPlalindrome=new boolean[array.length][array.length];
        for (int i = 0; i <length; i++) {
            for (int j = 0; j < length; j++) {
                // 这是 i=j 和 i = j+1的情况 即是相邻或者同一个元素
                if(i<j+2){
                    isPlalindrome[i][j]=array[i]==array[j];
                }else{
                    isPlalindrome[i][j] = (array[i]==array[j]&&isPlalindrome[i-1][j+1]);
                }
                //一次动态完成，需要判断当前字符串是否是回文而且 长度要大
                if(isPlalindrome[i][j]&&(i-j)>end-start){
                    start = j;
                    end = i;
                }
            }
        }
        System.out.println(end);
        System.out.println(start);
        return String.valueOf(array,start,end-start+1);
    }

    public static void main(String[] args) {
        String string = "abccba";
        String string2 = "abd";
        String string3 = "aabcdcba";
        System.out.println(isPlalindrome(string));
        System.out.println(isPlalindrome(string2));
        System.out.println(isPlalindrome(string3));
        System.out.println(maxPlalindrome(string3));

    }
}
