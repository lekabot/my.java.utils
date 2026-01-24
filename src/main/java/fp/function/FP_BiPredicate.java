package fp.function;

import fp.utils.FP_Objects;

@FunctionalInterface
public interface FP_BiPredicate<T, R> {
  boolean test(T t, R r);

  default FP_BiPredicate<T, R> and(FP_BiPredicate<? super T, ? super R> other) {
    FP_Objects.requireNonNull(other);
    return (T t, R r) -> test(t, r) && other.test(t, r);
  }

  default FP_BiPredicate<T, R> or(FP_BiPredicate<? super T, ? super R> other) {
    FP_Objects.requireNonNull(other);
    return (T t, R r) -> test(t, r) || other.test(t, r);
  }

  default FP_BiPredicate<T, R> negate() {
    return (T t, R r) -> !test(t, r);
  }
}
