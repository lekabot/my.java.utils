package fp.function;

import java.util.Objects;

@FunctionalInterface
public interface FP_Runnable {
  void run();

  default FP_Runnable andThen(FP_Runnable other) {
    Objects.requireNonNull(other);
    return () -> {
      run();
      other.run();
    };
  }
}
