package fp.function;

@FunctionalInterface
public interface Supplier<T> {
  T get();

  static <T> Supplier<T> of(T t) {
    return () -> t;
  }

  static <T> Supplier<T> constant(T t) {
    return () -> t;
  }

  static <T> Supplier<T> memoized(Supplier<T> other) {
    final T[] value = (T[]) new Object[1];
    final boolean[] isValueComputed = {false};

    return () -> {
      if (!isValueComputed[0]) {
        value[0] = other.get();
        isValueComputed[0] = true;
      }
      return value[0];
    };
  }
}
