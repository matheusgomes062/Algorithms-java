import java.time.LocalTime;
import java.util.Scanner;

public class MergeSortBottomUp {

    private MergeSortBottomUp() {}
    private static Comparable[] aux;

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

    // save times but uses more memory!
    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz+sz)
            for (int lo = 0; lo < N-sz; lo += sz+sz)
                MergeSortBottomUp.merge (a, aux, lo,lo + sz - 1, Math.min(lo + sz + sz - 1, N-1));
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
        MergeSortBottomUp.sort(a);
        calculateTimePassedInSeconds(before);
        show(a);
    }
}