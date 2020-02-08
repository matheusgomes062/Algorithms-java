/*
  Cost Model: Number of array accesses (for read or write).
  Algorithm: Quick-Find

  Order of growth of number of array access
  Initialize: N
  Union: N
  Find: 1

  Defect: Union too expensive
  Takes N^2 array access to process sequence of N union commands on N objects.

  Worst-case time: M N
  M union-find operations on a set of N objects
*/

import java.time.LocalTime;

public class QuickFindUF {
  public int[] id;

  public QuickFindUF(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public boolean connected(int p, int q) {
    return id[p] == id[q];
  }

  public void union(int p, int q) {
    System.out.println("Union type: " + this.getClass().getSimpleName());
    int pid = id[p];
    int qid = id[q];
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pid) {
        id[i] = qid;
      }
    }
  }

  public void calculateTimePassedInSeconds(int before) {
    System.out.println((LocalTime.now().getNano() - before) / 1000000);
  }

  public static void main(String[] args) {
    int before = LocalTime.now().getNano();
    QuickFindUF quickFindUF = new QuickFindUF(2000000);
    quickFindUF.union(0, 1);
    quickFindUF.calculateTimePassedInSeconds(before);
    System.out.println(quickFindUF.id[0]);
  }
}