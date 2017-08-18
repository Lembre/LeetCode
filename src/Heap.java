/**
 * Created by chenborui on 18/08/2017.
 */
public class Heap<T extends Comparable<T>> {

    public int left(int i) {
        return (i + 1) * 2 - 1;
    }

    public int right(int i) {
        return (i + 1) * 2;
    }

    public int parent(int i) {
        if (i == 0) {
            return -1;
        }
        return (i - 1) / 2;
    }

    // 最大堆 MaxHeap
    public void maxHeapify(T[] a, int i, int heapLength) {
        int l = left(i);
        int r = right(i);
        int largest = -1;

        if (l < heapLength && a[i].compareTo(a[l]) < 0) {
            largest = l;
        } else {
            largest = i;
        }

        if (r < heapLength && a[largest].compareTo(a[r]) < 0) {
            largest = r;
        }

        if (i != largest) {
            T temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            // 交换元素后，以a[i]为根的树可能不满足大根堆的性质，递归调用该方法
            maxHeapify(a, largest, heapLength);
        }
    }

    public void minHeapify(T[] a, int i, int heapLength) {
        int l = left(i);
        int r = right(i);
        int smallest = -1;

        if (l < heapLength && a[i].compareTo(a[l]) > 0) {
            smallest = l;
        } else {
            smallest = i;
        }

        if (r < heapLength && a[smallest].compareTo(a[r]) > 0) {
            smallest = r;
        }

        if (i != smallest) {
            T temp = a[i];
            a[i] = a[smallest];
            a[smallest] = temp;
            minHeapify(a, smallest, heapLength);
        }

    }

    public void buildHeap(T[] a, int heapLength, int type) {
        int lenthParent = parent(heapLength - 1);
        if (type == 1) {
            for (int i = lenthParent; i >= 0; i--) {
                maxHeapify(a, i, heapLength);
            }
        }

        if (type == 0) {
            for (int i = lenthParent; i >= 0; i--) {
                minHeapify(a, i, heapLength);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5, 6, 7};
        new Heap<Integer>().buildHeap(nums, nums.length, 1);
        for (int num : nums) {
            System.out.println(num);
        }
        new  Heap<Integer>().buildHeap(nums, nums.length, 0);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
