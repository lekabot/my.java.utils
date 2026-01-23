package fp.function;

@FunctionalInterface
public interface FP_UnaryOperator<T> extends FP_Function<T, T> {
  static <T> FP_UnaryOperator<T> identity() {
    return t -> t;
  }
}
