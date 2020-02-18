import java.time.LocalTime;
import java.util.Scanner;

public class MergeSort {

    private MergeSort() {}

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for(int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
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
        MergeSort.sort(a);
        calculateTimePassedInSeconds(before);
        show(a);
    }
}
