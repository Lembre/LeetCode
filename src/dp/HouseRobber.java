package dp;

/**
 *
 You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

 */
public class HouseRobber {

    public static void main(String[] args) {
        int[] nums = {8, 3, 6, 15, 4, 9, 7, 10};
        int ans = solution2(nums);
        System.out.println(ans);
    }

    // 一维数组dp问题，正常解法，空间复杂度为一维数组
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] touched = new int[n];
        int[] untouched = new int[n];

        touched[0] = nums[0];
        untouched[0] = 0;

        for (int i = 1; i < n; i++) {
            touched[i] = untouched[i - 1] + nums[i];
            untouched[i] = Math.max(touched[i - 1], untouched[i - 1]);
        }

        return Math.max(touched[n - 1], untouched[n - 1]);
    }

    // 利用滚动数组，降维打击，空间复杂度降低
    public static int solution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }


        int n = nums.length;
        int touched = nums[0];
        int tmp = touched;
        int untouched = 0;

        for (int i = 1; i < n; i++) {
            touched = untouched + nums[i];
            untouched = Math.max(tmp, untouched);
            tmp = touched;
        }

        return Math.max(touched, untouched);
    }
}
