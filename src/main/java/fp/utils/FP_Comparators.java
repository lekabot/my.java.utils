package fp.utils;

import fp.function.FP_Comparator;

public class FP_Comparators {
  private FP_Comparators() {
    throw new AssertionError("No fp.utils.FP_Comparators instance for you");
  }

  enum FP_NaturalOrderComparator implements FP_Comparator<Comparable<Object>> {
    INSTANCE;

    @Override
    public int compare(Comparable<Object> t1, Comparable<Object> t2) {
      return t1.compareTo(t2);
    }

//    @Override
//    public FP_Comparator<Comparable<Object>> reversed() {
//      return FP_Comparator.reverseOrder();
//    }
  }
}
