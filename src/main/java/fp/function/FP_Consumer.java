package fp.function;

import java.util.Objects;

@FunctionalInterface
public interface FP_Consumer<T> {
  void accept(T t);

  default FP_Consumer<T> andThen(FP_Consumer<? super T> other) {
    Objects.requireNonNull(other);
    return t -> {
      accept(t);
      other.accept(t);
    };
  }
}
