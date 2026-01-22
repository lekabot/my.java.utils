package fp.function;

import java.io.Serializable;
import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {
  // < 0 – a < b
  // 0 – a = b
  // > 0 – a > b
  int compare(T t1, T t2);

  default Comparator<T> reversed() {
    return (t1, t2) -> compare(t2, t1);
  }

  default Comparator<T> thenComparing(Comparator<? super T> other) {
    Objects.requireNonNull(other);
    return (Comparator<T> & Serializable) (t1, t2) -> {
      int res = compare(t1, t2);
      return res == 0 ? other.compare(t1, t2) : res;
    };
  }

//  default Comparator<T> thenComparing(keyExtractor) Нужно сперва реализовтаь comparing
}
