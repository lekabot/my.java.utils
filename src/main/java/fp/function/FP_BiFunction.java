package fp.function;

import java.util.Objects;

@FunctionalInterface
public interface FP_BiFunction<K, F, C> {
  C apply(K k, F f);

  default <V> FP_BiFunction<K, F, V> andThen(FP_Function<? super C, ? extends V> other) {
    Objects.requireNonNull(other);
    return (k, f) -> other.apply(apply(k, f));
  }
}
