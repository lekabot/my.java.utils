package fp.function;

import fp.utils.FP_Objects;

@FunctionalInterface
public interface FP_Function<T, R> {
  R apply(T t);

  default <V> FP_Function<V, R> compose(FP_Function<? super V, ? extends T> before) {
    FP_Objects.requireNonNull(before);
    return v -> apply(before.apply(v));
  }

  default <V> FP_Function<T, V> andThen(FP_Function<? super R, ? extends V> after) {
    FP_Objects.requireNonNull(after);
    return t -> after.apply(apply(t));
  }

  static <T> FP_Function<T, T> identity() {
    return t -> t;
  }
}