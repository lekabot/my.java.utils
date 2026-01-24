package fp.function;

import fp.utils.FP_Objects;

@FunctionalInterface
public interface FP_Consumer<T> {
  void accept(T t);

  default FP_Consumer<T> andThen(FP_Consumer<? super T> other) {
    FP_Objects.requireNonNull(other);
    return t -> {
      accept(t);
      other.accept(t);
    };
  }
}
