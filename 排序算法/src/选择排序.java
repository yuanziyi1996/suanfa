import java.util.Arrays;

public class 选择排序 {
    public static void selectSort(int [] arr){
        int length = arr.length;
        for (int i = 0; i < length-1; i++) {
            int min = i;
            for (int j = i+1; j <length ; j++) {
                if(arr[j]<arr[min]){
                    min =j;
                }
            }
            Swap.swap(arr,i,min);

        }
        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {

        int [] arr = {49,38,65,97,76,13,27,49};
        selectSort(arr);
    }
}
