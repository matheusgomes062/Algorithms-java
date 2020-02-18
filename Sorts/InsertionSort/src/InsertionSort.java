import java.time.LocalTime;
import java.util.Comparator;
import java.util.Scanner;
import edu.princeton.cs.algs4.StdOut;

public class InsertionSort {
    private InsertionSort() {}

    public static void sort(Comparable[] a) {
        int n = a.length;
        for(int i = 1; i < n; i++) {
            for(int j= i; j > 0 && less(a[j], a[j-1]); j--) {
                exchange(a, j, j-1);
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo((w)) < 0;
    }

    private static void exchange(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public static void calculateTimePassedInSeconds(int before) {
        System.out.println("Time spent in seconds: " + (LocalTime.now().getNano() - before) / 1000000);
    }

    public static void main(String[] args) {
        Scanner comp = new Scanner(System.in);
        String b = comp.nextLine();
        Comparable[] a = b.split(" ");

        int before = LocalTime.now().getNano();
        InsertionSort.sort(a);
        calculateTimePassedInSeconds(before);
        show(a);
    }
}
