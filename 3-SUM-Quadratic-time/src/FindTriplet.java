/*
    Find triplet or 3 sum algorithm.
    In this case we have a different approach, we have a O(n^2) in the worst case.

    To obtain this we had to sort the numbers before.

    3-SUM in quadratic time. Design an algorithm for the 3-SUM problem that takes time proportional to n^2n
    in the worst case. You may assume that you can sort the nn integers in time proportional to n^2n or better.

    Hint: given an integer x and a sorted array a[] of nn distinct integers, design a linear-time algorithm to determine
    if there exists two distinct indices i and j such that a[i]+a[j]==x
 */

public class FindTriplet {
    boolean find3Numbers(int A[], int arr_size, int sum)
    {
        int l, r;

        quickSort(A, 0, arr_size - 1);

        for (int i = 0; i < arr_size - 2; i++) {
            l = i + 1;
            r= arr_size - 1;
            while (l<r) {
                if(A[i] + A[l] + A[r] == sum) {
                    System.out.print("Triplet is " + A[i] + ", " + A[l] + ", " + A[r]);
                    return true;
                }
                else if (A[i] + A[l] + A[r] < sum)
                    l++;
                else r--;
            }
        }
        return false;
    }

    int partition(int A[], int startingIndex, int endingIndex)
    {
        int x = A[endingIndex];
        int i = (startingIndex - 1);
        int j;

        for(j = startingIndex; j <= endingIndex - 1; j++) {
            if(A[j] <= x){
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i + 1];
        A[i + 1] = A[endingIndex];
        A[endingIndex] = temp;
        return (i + 1);
    }

    void quickSort(int A[], int startingIndex, int endingIndex)
    {
        int pi;

        /* Partitioning index */
        if (startingIndex < endingIndex) {
            pi = partition(A, startingIndex, endingIndex);
            quickSort(A, startingIndex, pi - 1);
            quickSort(A, pi + 1, endingIndex);
        }
    }

    public static void main(String[] args)
    {
         FindTriplet triplet = new FindTriplet();
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        int arr_size = A.length;

        triplet.find3Numbers(A, arr_size, sum);
    }
}
