/*
  Cost Model: Number of array accesses (for read or write).
  Algorithm: Weighted-Quick-Union

  Order of growth of number of array access
  Initialize: N
  Union: log N (include cost of finding roots)
  Connected: log N (include cost of finding roots)
  Depth of any node x is at most log N

  Defect: Trees can get tall.
  Find too expensive (could be N array accesses)

  Worst-case time: N + M log N
  Worst-case time with path compression: N + M log^* N
  M union-find operations on a set of N objects
*/

import java.time.LocalTime;
import java.util.Scanner;

public class WeightedQuickUnion {

  public static int[] id;
  private int[] sz;
  private int count;

  public WeightedQuickUnion(int N) {
    count = N;
    id = new int[N];
    sz = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
      sz[i] = 1;
    }
  }

  public int count() {
    return count;
  }

  public int find(int p) {
    while (p != id[p]) {
      // add this if you want to test path compression!
      // id[p] = id[id[p]];
      p = id[p];
    }
    return p;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ)
      return;
    if (sz[rootP] < sz[rootQ]) {
      id[rootP] = rootQ;
      sz[rootQ] += sz[rootP];
    } else {
      id[rootQ] = rootP;
      sz[rootP] += sz[rootQ];
    }
  }

  public static void calculateTimePassedInSeconds(int before) {
    System.out.println((LocalTime.now().getNano() - before) / 1000000);
  }

  public static void main(String[] args) {
    int before = LocalTime.now().getNano();
    Scanner myInput = new Scanner(System.in);
    System.out.print("Enter integer: ");
    int N = myInput.nextInt();
    WeightedQuickUnion uf = new WeightedQuickUnion(N);
    while (myInput.hasNext()) {
      int p = myInput.nextInt();
      int q = myInput.nextInt();
      if (uf.connected(p, q))
        continue;
      uf.union(p, q);
      System.out.println(p + " " + q);
      myInput.close();
    }
    System.out.println(uf.count() + " components");
    WeightedQuickUnion.calculateTimePassedInSeconds(before);
    System.out.println(WeightedQuickUnion.id[0]);
  }

}
