package fp.utils;

import fp.function.FP_Comparator;
import fp.function.FP_Supplier;

import java.util.Arrays;

public final class FP_Objects {
  private FP_Objects() {
    throw new AssertionError("No instance for fp.utils");
  }

  public static boolean equals(Object a, Object b) {
    return a == b || a != null && a.equals(b);
  }

  public static boolean deepEquals(Object a, Object b) {
    // TODO: implement when less drunk
    throw new UnsupportedOperationException("Not implemented yet");
  }

  public static int hashCode(Object o) {
    return o != null ? o.hashCode() : 0;
  }

  public static int hash(Object... o) {
    return Arrays.hashCode(o);
  }

  public static String toString(Object o) {
    return String.valueOf(o);
  }

  public static String toString(Object o, String defValue) {
    return o != null ? o.toString() : defValue;
  }

  public static <T> int compare(T a, T b, FP_Comparator<? super T> comparator) {
    return a == b ? 0 : comparator.compare(a, b);
  }

  public static <T> T requireNonNull(T o) {
    if (o == null) {
      throw new NullPointerException();
    }
    return o;
  }

  public static <T> T requireNonNull(T o, String message) {
    if (o == null) {
      throw new NullPointerException(message);
    }
    return o;
  }

  public static boolean isNull(Object o) {
    return o == null;
  }

  public static boolean nonNull(Object o) {
    return o != null;
  }

  public static <T> T requireNonNullElse(T o, T defO) {
    return o != null ? o : requireNonNull(defO, "defaultObject");
  }

  public static <T> T requireNonNullElseGet(T o, FP_Supplier<? extends T> supplier) {
    return o != null ? o : requireNonNull(requireNonNull(supplier, "supplier").get(), "supplier.get()");
  }

  public static <T> T requireNonNull(T o, FP_Supplier<String> supplier) {
    if (o == null) {
      throw new NullPointerException(supplier == null ? null : supplier.get());
    }
    return o;
  }

  public static int checkIndex(int index, int length) {
    // TODO: implement bounds checking
    throw new UnsupportedOperationException("checkIndex(int, int) not implemented yet");
  }

  public static int checkFromToIndex(int fromIndex, int toIndex, int length) {
    // TODO: implement range validation
    throw new UnsupportedOperationException("checkFromToIndex(int, int, int) not implemented yet");
  }

  public static int checkFromIndexSize(int fromIndex, int size, int length) {
    // TODO: implement overflow-safe range check
    throw new UnsupportedOperationException("checkFromIndexSize(int, int, int) not implemented yet");
  }

  public static long checkIndex(long index, long length) {
    // TODO: implement bounds checking for long
    throw new UnsupportedOperationException("checkIndex(long, long) not implemented yet");
  }

  public static long checkFromToIndex(long fromIndex, long toIndex, long length) {
    // TODO: implement range validation for long
    throw new UnsupportedOperationException("checkFromToIndex(long, long, long) not implemented yet");
  }

  public static long checkFromIndexSize(long fromIndex, long size, long length) {
    // TODO: implement overflow-safe range check for long
    throw new UnsupportedOperationException("checkFromIndexSize(long, long, long) not implemented yet");
  }
}
