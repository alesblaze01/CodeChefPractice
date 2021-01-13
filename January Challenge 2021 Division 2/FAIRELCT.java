import java.util.Scanner;
import java.util.Arrays;

class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int m = s.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];
            for (int i = 0; i < n; i++) {
                arr1[i] = s.nextInt();
            }
            for (int i = 0; i < m; i++) {
                arr2[i] = s.nextInt();
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int sum1 = sum(arr1);
            int sum2 = sum(arr2);
            int index1 = 0, index2 = arr2.length - 1;
            int count = 0;
            while (sum1 <= sum2 && index1 < arr1.length && index2 >= 0) {
                sum1 = (sum1 - arr1[index1]) + arr2[index2];
                sum2 = (sum2 - arr2[index2]) + arr1[index1];
                index2--;
                index1++;
                count++;
            }
            if (sum1 > sum2)
                System.out.println(count);
            else
                System.out.println(-1);
        }
        s.close();
    }

    public static int sum(int[] arr) {
        int sm = 0;
        for (int val : arr) {
            sm += val;
        }
        return sm;
    }
}

