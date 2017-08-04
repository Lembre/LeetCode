import javafx.beans.binding.StringBinding;

/**

 Given a positive integer n, find the number of non-negative integers less than or equal to n, whose binary representations do NOT contain consecutive ones.

 Example 1:
 Input: 5
 Output: 5
 Explanation:
 Here are the non-negative integers <= 5 with their corresponding binary representations:
 0 : 0
 1 : 1
 2 : 10
 3 : 11
 4 : 100
 5 : 101
 Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule.
 Note: 1 <= n <= 109

 */
public class NonNegativeIntegersWithoutConsecutiveOnes {

    public static void main(String[] args) {
        int num = 26;
//        brute force
//        int count = 0;
//        for (int i = 0; i <= num; i++)
//            if (new NonNegativeIntegersWithoutConsecutiveOnes().check(i))
//                count++;

        int ans = new NonNegativeIntegersWithoutConsecutiveOnes().solution(num);
        System.out.println("ans= " + ans);
    }

    // brute force O(n*32)
    public boolean check(int n) {
        int i = 31;
        while (i > 0) {
            if ((n & (1 << i)) != 0 && (n & (1 << (i - 1))) != 0)
                return false;
            i--;
        }
        return true;
    }


    public int solution(int num) {

        StringBuilder str = new StringBuilder(Integer.toBinaryString(num)).reverse();
        System.out.println(str.toString());
        int k = str.length();
        int f[] = new int[k];
        f[0] = 1;
        f[1] = 2;
        for(int i = 2; i < k; i++) {
            f[i] = f[i-1] + f[i-2];
        }

        int ans = 0;
        for(int i = k - 1; i >= 0; i--) {
            if(str.charAt(i) == '1') {
                ans += f[i];
                if (i < k - 1 && str.charAt(i + 1) == '1') {
                    return ans;
                }
            }
        }
        ans++;
        return ans;

//        int i = 30, sum = 0, prev_bit = 0;
//        while (i >= 0) {
//            if ((num & (1 << i)) != 0) {
//                sum += f[i];
//                if (prev_bit == 1) {
//                    sum--;
//                    break;
//                } else {
//                    prev_bit = 1;
//                }
//            } else
//                prev_bit = 0;
//            i--;
//        }

    }

}
