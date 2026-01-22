package fp.function;

import java.util.Objects;

@FunctionalInterface
public interface BiPredicate<T, R> {
  boolean test(T t, R r);

  default BiPredicate<T, R> and(BiPredicate<? super T, ? super R> other) {
    Objects.requireNonNull(other);
    return (T t, R r) -> test(t, r) && other.test(t, r);
  }

  default BiPredicate<T, R> or(BiPredicate<? super T, ? super R> other) {
    Objects.requireNonNull(other);
    return (T t, R r) -> test(t, r) || other.test(t, r);
  }

  default BiPredicate<T, R> negate() {
    return (T t, R r) -> !test(t, r);
  }
}
