import java.time.LocalTime;
import edu.princeton.cs.algs4.StdOut;
import java.util.Scanner;
import java.lang.*;
import java.util.Comparator;

public class ShellSort {
    private ShellSort() {}

    public static void sort(Comparable[] a) {
        int n = a.length;

        //3x+1 increment sequence: 1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < n/3) h = 3*h + 1;

        while(h >= 1) {
            //h-sort the array
            for(int i = h; i < n; i++) {
                for(int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exchange(a, j, j-h);
                }
            }
            h /= 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {

        return v.compareTo(w) < 0;
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

        String b  = comp.nextLine();

        Comparable[] a = b.split(" ");

        int before = LocalTime.now().getNano();
//        Comparable[] a = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        ShellSort.sort(a);
        calculateTimePassedInSeconds(before);
        show(a);
    }
}
