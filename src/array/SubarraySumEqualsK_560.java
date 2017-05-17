package array;


import java.util.HashMap;

/**
 * @author Qian Shaofeng
 * @created on 2017/5/11.
 */
public class SubarraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {

        int sum = 0, result = 0;
        HashMap<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) {
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

//    public int subarraySum(int[] nums, int k) {
//        int counts = 0;
//        for(int i=0; i < nums.length; ++i){
//            int sum = 0;
//            for(int j=i; j < nums.length; ++j){
//                sum += nums[j];
//                if(sum == k){
//                    ++counts;
//                }
//            }
//        }
//        return counts;
//    }

    public static void main(String[] args) {
        SubarraySumEqualsK_560 sse = new SubarraySumEqualsK_560();
        int[] a = {2, 1, 1, 2};
        System.out.println(sse.subarraySum(a, 2));
    }


}
