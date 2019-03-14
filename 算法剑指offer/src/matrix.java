import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Stack;

public class matrix {
    public static void printMatrix(int[][] matrix) {
        //先得到行列长度；

        int row = matrix.length;//行
        int col = matrix[0].length;//列
        if(row<1||col<1)
            return;

        //先打印最上边那一列，根据有多少列来打印
        for (int i = 0; i < col; i++) {
            System.out.println(matrix[0][i]);
        }
        //打印最右边的那一列,根据行数来打印，注意最后一列第一个数字不用打
        for (int i = 0; i < row - 1; i++) {
            System.out.println(matrix[i + 1][col - 1]);
        }
        //打印最下边那一列，根据列数来打印，右下角那个不用打印
        if(col>0){
            for (int i = col - 1; i > 0; i--) {
                System.out.println(matrix[row - 1][i - 1]);
            }
        }

        //打印最左边的那一列，左上角，右上角不用打印
        if(row>1){
            for (int i = row - 2; i > 0; i--) {
                System.out.println(matrix[i][0]);
            }
        }

        if (row > 2 && col > 2) {
            int matrix1[][] = new int[row - 2][col - 2];
            //重新定义这个矩阵。
            for (int i = 0; i < row - 2; i++) {
                for (int j = 0; j < col - 2; j++) {
                    matrix1[i][j] = matrix[i + 1][j + 1];
                }
            }
            printMatrix(matrix1);
        }

    }





    public static void main(String[] args) {
        int matrix[][]=new int[5][5];
        int count=1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j]=count++;
            }}

        printMatrix(matrix);

    }
}
