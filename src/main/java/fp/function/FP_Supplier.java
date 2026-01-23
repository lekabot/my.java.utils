package fp.function;

import java.util.Objects;

@FunctionalInterface
public interface FP_Supplier<T> {
  T get();

  static <T> FP_Supplier<T> of(T t) {
    return () -> t;
  }

  static <T> FP_Supplier<T> constant(T t) {
    return () -> t;
  }

  static <T> FP_Supplier<T> memoized(FP_Supplier<T> other) {
    Objects.requireNonNull(other);

    class State {
      volatile T value;
      volatile boolean computed;
    }

    final State state = new State();
    final Object lock = new Object();

    return () -> {
      if (!state.computed) {
        synchronized (lock) {
          if (!state.computed) {
            state.value = other.get();
            state.computed = true;
          }
        }
      }
      return state.value;
    };
  }
}
