package fp.function;

import java.util.Objects;

@FunctionalInterface
public interface FP_Predicate<T> {
  boolean test(T t);

  default FP_Predicate<T> and(FP_Predicate<? super T> other) {
    Objects.requireNonNull(other);
    return t -> test(t) && other.test(t);
  }

  default FP_Predicate<T> or(FP_Predicate<? super T> other) {
    Objects.requireNonNull(other);
    return t -> test(t) || other.test(t);
  }

  default FP_Predicate<T> negate() {
    return t -> !test(t);
  }

  static <T> FP_Predicate<T> isEqual(Object targetObject) {
    return t -> Objects.equals(targetObject, t);
  }
}
