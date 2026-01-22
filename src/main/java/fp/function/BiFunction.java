package fp.function;

import java.util.Objects;

public interface BiFunction<K, F, C> {
  C apply(K k, F f);

  default <V> BiFunction<K, F, V> andThen(BiFunction<? super C, ? super F, ? extends V> other) {
    Objects.requireNonNull(other);
    return (K k, F f) -> other.apply(apply(k, f), f);
  }
}
