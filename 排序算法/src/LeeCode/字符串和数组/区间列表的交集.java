package LeeCode.字符串和数组;

import lombok.Builder;
import lombok.Data;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.*;

@Data
@Builder
public class 区间列表的交集 {
    public static int [][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> l = new ArrayList<>();
        Arrays.sort(A,(a,b)->a[0]-b[0]);
        Arrays.sort(B,(a,b)->a[0]-b[0]);
        int i = 0;
        int j = 0;
        while(i < A.length && j < B.length)
        {
            if(A[i][1] < B[j][0])
            {
                i++;
                continue;
            }
            else if(B[j][1] < A[i][0])
            {
                j++;
                continue;
            }
            else
            {
                int left = Math.max(B[j][0],A[i][0]);
                int right = Math.min(B[j][1],A[i][1]);
                l.add(new int[]{left,right});
                if(B[j][1]>A[i][1]) i++;
                else j++;
            }

        }
        System.out.println(l);
        return l.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int A [][] = {{0,2},{5,10},{13,23},{24,25}};
        int B [][] = {{1,5},{8,12},{15,24},{25,26}};
        int [][] result = intervalIntersection(A,B);
        for (int i = 0; i <result.length ; i++) {
            for (int j = 0; j <result[i].length ; j++) {
                System.out.print(result[i][j]+",");
            }
            System.out.println("====");
        }
        System.out.println(Arrays.toString(intervalIntersection(A,B)));
    }

    @Override
    public String toString() {
        return "区间列表的交集{}";
    }
}
