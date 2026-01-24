package fp.function;

import fp.utils.FP_Objects;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class FP_ObjectsTests {
  private final int DEFAULT_HASH_CODE = 0;


  @Test
  void equals_allCases() {
    assertAll(
      () -> assertTrue(FP_Objects.equals(null, null)),
      () -> assertFalse(FP_Objects.equals(null, new Object())),
      () -> assertTrue(FP_Objects.equals((Object) "hello", (Object) "hello")),
      () -> assertFalse(FP_Objects.equals((Object) "hello", (Object) "halo"))
    );
  }

  @Test
  void hashCode_allCases() {
    assertAll(
      () -> assertThat(FP_Objects.hashCode("hello")).isNotEqualTo(DEFAULT_HASH_CODE),
      () -> assertThat(FP_Objects.hashCode(null)).isEqualTo(DEFAULT_HASH_CODE)
    );
  }

  @Test
  void hash_allCases() {
    Object[] objs = {"hello", 42, null, new Object()};

    assertAll(
      () -> assertThat(FP_Objects.hash()).isEqualTo(Arrays.hashCode(new Object[]{})),
      () -> assertThat(FP_Objects.hash((Object) null)).isEqualTo(Arrays.hashCode(new Object[]{null})),
      () -> assertThat(FP_Objects.hash(objs)).isEqualTo(Arrays.hashCode(objs))
    );
  }

  @Test
  void toString_allCases() {
    assertAll(
      () -> assertThat(FP_Objects.toString((Object) "hello")).isEqualTo("hello"),
      () -> assertThat(FP_Objects.toString((Object) null)).isEqualTo("null")
    );
  }

  @Test
  void toStringWithDefault_allCases() {
    assertAll(
      () -> assertThat(FP_Objects.toString("hello", "bag")).isEqualTo("hello"),
      () -> assertThat(FP_Objects.toString((Object) null, "bag")).isEqualTo("bag")
    );
  }

  @Test
  void compare_AllCases() {
    assertAll(
      () -> assertThat(FP_Objects.compare(52, 52, null)).isEqualTo(0),
      () -> assertThat(FP_Objects.compare(52, 52, Integer::compare)).isEqualTo(0),
      () -> assertThat(FP_Objects.compare(51, 52, Integer::compare)).isEqualTo(-1),
      () -> assertThat(FP_Objects.compare(52, 32, Integer::compare)).isEqualTo(1)
    );
  }

  @Test
  void requireNonNull_allCases() {
    assertAll(
      () -> assertThatThrownBy(() -> FP_Objects.requireNonNull(null)).isInstanceOf(NullPointerException.class),
      () -> assertThat(FP_Objects.requireNonNull("aba")).isEqualTo("aba")
    );
  }

  @Test
  void isNull_allCases() {
    assertAll(
      () -> assertTrue(FP_Objects.isNull(null)),
      () -> assertFalse(FP_Objects.isNull("null"))
    );
  }

  @Test
  void nonNull_allCases() {
    assertAll(
      () -> assertFalse(FP_Objects.nonNull(null)),
      () -> assertTrue(FP_Objects.nonNull("null"))
    );
  }

  @Test
  void requireNonNullElse_allCases() {
    assertAll(
      () -> assertThat(FP_Objects.requireNonNullElse("a", "b")).isEqualTo("a"),
      () -> assertThat(FP_Objects.requireNonNullElse(null, "b")).isEqualTo("b"),
      () -> assertThatThrownBy(() -> FP_Objects.requireNonNullElse(null, null))
        .isInstanceOf(NullPointerException.class)
        .hasMessage("defaultObject")
    );
  }

  @Test
  void requireNonNullElseGet_allCases() {
    assertAll(
      () -> assertThat(FP_Objects.requireNonNullElseGet("aba", () -> "ba")).isEqualTo("aba"),
      () -> assertThat(FP_Objects.requireNonNullElseGet(null, () -> "ba")).isEqualTo("ba"),
      () -> assertThatThrownBy(() -> FP_Objects.requireNonNullElseGet(null, null))
        .isInstanceOf(NullPointerException.class)
        .hasMessage("supplier"),
      () -> assertThatThrownBy(() -> FP_Objects.requireNonNullElseGet(null, () -> null))
        .isInstanceOf(NullPointerException.class)
        .hasMessage("supplier.get()")
    );
  }

  @Test
  void requireNonNullWithMessage_allCases() {
    assertAll(
      () -> assertThat(FP_Objects.requireNonNull("a", () -> "123")).isEqualTo("a"),
      () -> assertThatThrownBy(() -> FP_Objects.requireNonNull(null, () -> "null"))
        .isInstanceOf(NullPointerException.class)
        .hasMessage("null"),
      () -> assertThatThrownBy(() -> FP_Objects.requireNonNull(null, (FP_Supplier<String>) null))
        .isInstanceOf(NullPointerException.class)
    );
  }
}
