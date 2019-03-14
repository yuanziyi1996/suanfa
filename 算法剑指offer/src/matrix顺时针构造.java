public class matrix顺时针构造 {
    public static int [][] solution(int m,int n){
        int[][] matrix=new int[m][n];
        if(n==0||m==0)
            return matrix;
        int k=1;
        int up=0,down=m-1,left=0,right=n-1;//up 和down用于管理行
        while ((m*n)>=k){
            for(int j=left;j<=right;j++)
                matrix[up][j]=k++;
            up++;
            for(int i=up;i<=down;i++)
                matrix[i][right]=k++;
            right--;
            for(int j=right;j>=left;j--)
                matrix[down][j]=k++;
            down--;
            for(int i=down;i>=up;i--)
                matrix[i][left]=k++;
            left++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int m=5;
        int n=5;
        int a[][]=solution(m,n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(a[i][j]);
            }}
    }
}
