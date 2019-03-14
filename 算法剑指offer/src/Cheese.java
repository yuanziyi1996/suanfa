import org.apache.xmlbeans.SystemProperties;

import java.util.Arrays;
import java.util.Scanner;
/*      3
        3
        x
        .
        o
        .
        o
        x
        o
        x
        .*/
public class Cheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        String cheese[][] = new String[m][n];
        int index[] = new int[n];//记录第一个x的位置
        int oAndx []= new int[n];//记录一列中x和O的总个数
        for(int i=0;i<n;i++) {
            index[i]=-1;
            oAndx[i]=0;
        }
        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < cheese[i].length; j++) {
                cheese[i][j] = scanner.next();
            }
        }

        //记录第几个开始有的x，如果找到了那么就把每一列的x和O的总个数加1
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >=0; j--) {
                if (cheese[j][i].equals("x")) {
                    cheese[m-1][i]="x";
                    index[i] = j;
                    oAndx[i]=1;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(index));
        //如果这一行没有找到有x的，那么就全部为 .
		for (int i = 0; i < n; i++) {
			if (index[i] == -1) {
				for (int j = m - 1; j >= 0; j--) {
					cheese[j][i] = ".";
				}
			}
			else {
			    int count=0;//由下往上记录个数,以便把右下至上的o或x填进去
				for (int j = index[i]; j > 0; j--) {

					if(cheese[j-1][i].equals("x")) {
					    count++;
						cheese[m-1-count][i]="x";
						oAndx[i]++;
                    }
                    if(cheese[j-1][i].equals("o")) {
                        count++;
                        cheese[m-1-count][i]="o";
                        oAndx[i]++;
                    }
				}
			}
		}

		//把箱子掉落以后的那些空白补齐为.
		for(int i = 0; i < n; i++) {
            System.out.println("oAndx[i] = " + oAndx[i]);
            for (int j = 0; j < (m-oAndx[i]); j++) {
                cheese[j][i]=".";
            }
        }
        for (int i = 0; i < cheese.length; i++) {
			for (int j = 0; j < cheese[i].length; j++) {
				System.out.print(cheese[i][j]);
			}
            System.out.println();
        }
    }
}
