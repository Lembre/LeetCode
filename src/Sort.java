import java.util.Random;

/**
 * Created by chenborui on 02/08/2017.
 */
public class Sort {

    public static void main(String[] args) {
        int[] sort = {4, 3, 5, 2, 1, 8, 6};
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + " ");
        }
//        new Sort().quicksort(sort, 0, sort.length - 1);
        directInsertSort(sort);
        System.out.println();
        for (int i = 0; i < sort.length; i++) {
            System.out.print(sort[i] + " ");
        }
    }

    public void quicksort(int[] sort, int start, int end) {
        if (start >= end) {
            return;
        }

        int key = sort[start];
        int i = start;
        int j = end;

        // 关键点
        while(i < j) {
            // 大于k的移到右边，小于k的移动左边
            while(sort[i] < key && i < end) {
                i++;
            }

            while(sort[j] > key && j > start) {
                j--;
            }

            if (i < j) {
                sort[i] = sort[i] ^ sort[j];
                sort[j] = sort[i] ^ sort[j];
                sort[i] = sort[i] ^ sort[j];
            }
        }

        quicksort(sort, start, j-1);
        quicksort(sort, j+1, end);

    }

    private static void directInsertSort(int[] sort) {
        for (int i = 1; i < sort.length; i++) {
            int index = i - 1;
            int temp = sort[i];
            while (index >= 0 && sort[index] > temp) {
                sort[index + 1] = sort[index];
                index--;
            }
            sort[index + 1] = temp;
        }
    }

}
