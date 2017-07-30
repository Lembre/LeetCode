import java.util.ArrayList;
import java.util.Arrays;

/**
 * 给定一个含不同整数的集合，返回其所有的子集
 * <p>
 * 注意事项
 * <p>
 * 子集中的元素排列必须是非降序的，解集必须不包含重复的子集
 * <p>
 * 样例
 * 如果 S = [1,2,3]，有如下的解：
 * <p>
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */


public class Subsets {
    public class Solution {

        public ArrayList<ArrayList<Integer>>way(int[]nums){
            ArrayList<ArrayList<Integer>>results=new ArrayList<>();
            Arrays.sort(nums);
            subsetHelp(nums, 0, new ArrayList<Integer>(), results);
            return  results;
        }

        // 深度优先查找
        public void subsetHelp(int[]nums,
                                             int startIndex,
                                             ArrayList<Integer> subset,
                                             ArrayList<ArrayList<Integer>> results){
            results.add(new ArrayList<>(subset));

            for(int i = startIndex; i < nums.length;i++){
                subset.add(nums[i]);
                subsetHelp(nums,i + 1 , subset, results);
                subset.remove(subset.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Subsets().new Solution();
        ArrayList<ArrayList<Integer>> ans = solution.way(nums);
        System.out.println(ans);
    }
}
