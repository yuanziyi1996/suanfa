package LeeCode.常见算法题;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;

public class 只出现一次的数字 {
    public static int singleNumber(int[] nums){
        int length = nums.length;
        if (length == 0){
            return 0;
        }

        if(length == 1){
            return nums[0];
        }

        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i <length ; i++) {

            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.get(nums[i])+1);

            }

    }

        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int a[] = {4,1,2,1,2};
        System.out.println(singleNumber(a));
    }
}
