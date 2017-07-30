/**

 对于一个给定的 source 字符串和一个 target 字符串，你应该在 source 字符串中找出 target 字符串出现的第一个位置(从0开始)。
 如果不存在，则返回 -1。

 样例
 如果 source = "source" 和 target = "target"，返回 -1。

 如果 source = "abcdabcdefg" 和 target = "bcd"，返回 1。
 */
public class StrStr {

    public class Solution {
        public final int BASE = 1000000;

        // brute force O(m * n)
        public int way1(String source, String target) {
            if(source == null || target == null) {
                return -1;
            }

            int sl = source.length();
            int tl = target.length();

            for (int i = 0; i < sl; i++) {
                for (int j = 0; j < tl; j++) {
                    if (source.charAt(i+j) != target.charAt(j)) {
                        break;
                    }
                    if (sl - i < tl) {
                        return -1;
                    }
                    if (j == tl -1) {
                        return 1;
                    }
                }
            }
            return -1;
        }

        // Rabin-Karp O(m * n) 实际匹配时间 O(m + n) 预处理时间O(m)
        public int way2(String source, String target) {
            if(source == null || target == null) {
                return -1;
            }

            int sl = source.length();
            int tl = target.length();

            int power = 1;
            for (int i = 0; i < tl; i++) {
                power = power * 31 % BASE;
            }

            int targetCode = 0;
            for (int i = 0; i < tl; i++) {
                targetCode = (31 * targetCode + target.charAt(i)) % BASE;
            }

            int hashCode = 0;
            for (int i = 0; i < sl - tl; i++) {
                hashCode = (31 * hashCode + source.charAt(i)) % BASE;
                if (i < tl - 1) {
                    continue;
                }

                if (i >= tl) {
                    hashCode = hashCode - power * source.charAt(i - tl) % BASE;
                    if (hashCode < 0) {
                        hashCode += BASE;
                    }
                }

                if (targetCode == hashCode) {
                    if (source.substring(i - tl + 1, i + 1).equals(target)) {
                        return i - tl + 1;
                    }
                }
            }
            return -1;
        }
    }

    public Solution getSolution() {
        return new Solution();
    }

    public static void main(String[] args) {
        String source = "abcdabcdefg";
        String target = "bcd";

        Solution solution = new StrStr().getSolution();
        //int ans = solution.way1(source, target);
        int ans = solution.way2(source, target);
        System.out.println(ans);
    }
}


