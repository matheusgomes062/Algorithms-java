/*
  Cost Model: Number of array accesses (for read or write).
  Algorithm: Quick-Union

  Order of growth of number of array access
  Initialize: N
  Union: N (include cost of finding roots)
  Find: N (worst case)

  Defect: Trees can get tall.
  Find too expensive (could be N array accesses)

  Worst-case time: M N
  Worst-case time with path compression: N + M log N
  M union-find operations on a set of N objects
*/

import java.time.LocalTime;

public class QuickUnionUF {
  private int[] id;

  public QuickUnionUF(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++)
      id[i] = i;
  }

  private int root(int i) {
    while (i != id[i]) {
      // add this if you want to test path compression!
      // id[p] = id[id[p]];
      i = id[i];
    }
    return i;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    id[i] = j;
  }

  public void calculateTimePassedInSeconds(int before) {
    System.out.println((LocalTime.now().getNano() - before) / 1000000);
  }

  public static void main(String[] args) {
    int before = LocalTime.now().getNano();
    QuickUnionUF quickUnionUF = new QuickUnionUF(2000000);
    quickUnionUF.union(0, 1);
    quickUnionUF.calculateTimePassedInSeconds(before);
    System.out.println(quickUnionUF.id[0]);
  }
}