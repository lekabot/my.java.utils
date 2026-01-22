package fp.function;

import java.util.Objects;

@FunctionalInterface
public interface Consumer<T> {
  void accept(T t);

  default Consumer<T> andThen(Consumer<? super T> other) {
    Objects.requireNonNull(other);
    return t -> {
      accept(t);
      other.accept(t);
    };
  }
}
