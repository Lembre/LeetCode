import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 给定一个可能具有重复数字的列表，返回其所有可能的子集

 注意事项

 子集中的每个元素都是非降序的
 两个子集间的顺序是无关紧要的
 解集中不能包含重复子集
 样例
 如果 S = [1,2,2]，一个可能的答案为：

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]

 */

public class Subsets2 {


    public ArrayList<ArrayList<Integer>> solution(int[] nums) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        subsetHelp(nums, 0, new ArrayList<Integer>(), results);
        return  results;
    }

    // 深度优先查找
    // 为什么 i > startIndex?
    // 因为 i = startIndex 时，元素不重复
    public void subsetHelp(int[] nums,
                                         int startIndex,
                                         ArrayList<Integer> subset,
                                         ArrayList<ArrayList<Integer>> results) {

        results.add(new ArrayList<>(subset));

        for (int i = startIndex; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1] && i > startIndex) {
                continue;
            }

            subset.add(nums[i]);
            System.out.print(startIndex);
            System.out.print(i);
            System.out.println(subset);
            subsetHelp(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3};
        ArrayList<ArrayList<Integer>> ans = new Subsets2().solution(nums);
        System.out.println(ans);
    }
}
