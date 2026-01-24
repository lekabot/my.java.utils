package fp.function;

import fp.utils.FP_Objects;

@FunctionalInterface
public interface FP_Comparator<T> {
  // < 0 – a < b
  // 0 – a = b
  // > 0 – a > b
  int compare(T t1, T t2);

  default FP_Comparator<T> reversed() {
    return (t1, t2) -> compare(t2, t1);
  }

  default FP_Comparator<T> thenComparing(FP_Comparator<? super T> other) {
    FP_Objects.requireNonNull(other);
    return (t1, t2) -> {
      int res = compare(t1, t2);
      return res == 0 ? other.compare(t1, t2) : res;
    };
  }

//  default FP_Comparator<T> thenComparing(keyExtractor) Нужно сперва реализовтаь comparing
}
