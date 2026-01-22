package fp.function;

@FunctionalInterface
public interface Runnable {
  void run();

  default Runnable andThen(Runnable other) {
    return () -> {
      run();
      other.run();
    };
  }
}
