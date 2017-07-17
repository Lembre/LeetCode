/**
 * Created by chenborui on 11/07/2017.
 */
public class Hanoi {

    public static void main(String[] args) {
        new Hanoi().hanoi(3, "left", "right", "middle");
    }

    private void hanoi(int height, String left, String right, String middle) {
        if (height > 0) {
            hanoi(height - 1, left, middle, right);
            System.out.println(left + " to " + right);
            hanoi(height-1, middle, right, left);
        }
        return ;
    }
}
