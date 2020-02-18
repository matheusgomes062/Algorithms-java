import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import java.util.Scanner;

public class SelectionSort {
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for(int i = 0; i < N; i++)
        {
            int min = i;
            for(int j = i + 1; j < N; j++)
                if(less(a[j], a[min]))
                    min = j;
                exchange(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w)
    {
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

    public static void main(String[] args)throws IOException {
        Scanner comp = new Scanner(System.in);

        String b  = comp.nextLine();

        Comparable[] a = b.split(" ");

        int before = LocalTime.now().getNano();
        SelectionSort.sort(a);
        calculateTimePassedInSeconds(before);
        show(a);
    }
}
