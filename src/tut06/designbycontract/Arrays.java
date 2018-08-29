package tut06.designbycontract;

public class Arrays {
  public static void sort(Object[] a) {
    Object[] aux = a.clone();
    mergeSort(aux, a, 0, a.length, 0);
  } 

  @SuppressWarnings({ "rawtypes", "unchecked" })
  private static void mergeSort(Object src[], Object dest[], int low, int high, int off) {
    for (int i = low; i < high; i++)
      for (int j = i; j > low && ((Comparable) dest[j - 1]).compareTo(dest[j]) > 0; j--)
        swap(dest, j, j - 1);
  }

  private static void swap(Object[] x, int a, int b) {
    Object t = x[a];
    x[a] = x[b];
    x[b] = t;
  }
}
