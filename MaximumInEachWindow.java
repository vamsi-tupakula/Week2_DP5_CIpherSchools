import java.util.*;

public class MaximumInEachWindow {
    private static void printMax(int[] arr, int n, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        int j = 0;

        // adding all initial window elements in the deque
        while (j < k) {
            while (!dq.isEmpty() && arr[j] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(j);
            j++;
        }
        System.out.print(arr[dq.peekFirst()] + " ");
        i++;

        while (j < n) {
            dq.remove(i - 1);
            while (!dq.isEmpty() && arr[j] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            dq.addLast(j);
            System.out.print(arr[dq.peekFirst()] + " ");
            i++;
            j++;
        }

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 1 };
        int k = 3;
        printMax(arr, arr.length, k);
    }
}
