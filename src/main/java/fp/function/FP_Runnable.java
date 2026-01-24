package fp.function;

import fp.utils.FP_Objects;

@FunctionalInterface
public interface FP_Runnable {
  void run();

  default FP_Runnable andThen(FP_Runnable other) {
    FP_Objects.requireNonNull(other);
    return () -> {
      run();
      other.run();
    };
  }
}
