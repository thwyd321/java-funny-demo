package simple;

import java.util.Arrays;

/**
 * @ClassName :No136
 * @Description : 只出现一次的数字
 * @Author : wangyudi
 * @Date : 2019/7/30 16:24
 * @Version :1.0
 */
public class No136 {


    public static void main(String[] args) {
        int [] a = {1,2,3,3,2,4,4};
        int b = 7;
        System.out.println(b/2+1);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
    public int singleNumber1(int[] nums) {
        int a = nums[0];
        for(int i=1;i<nums.length;i++){
            a = a^nums[i];
        }
        return a;
    }







}
