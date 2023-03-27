package net.hsasaki0316.javacle.condition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.Optional;
import java.util.function.Supplier;
import org.junit.Test;

public class ConditionUtilTest {

  @Test
  public void testNvl_value1NotNull() {
    String value1 = "hello";
    String value2 = "world";
    String result = ConditionUtil.nvl(value1, value2);
    assertEquals(value1, result);
  }

  @Test
  public void testNvl_value1Null() {
    String value1 = null;
    String value2 = "world";
    String result = ConditionUtil.nvl(value1, value2);
    assertEquals(value2, result);
  }

  @Test
  public void testNvlWithOptional_value1Present() {
    Optional<String> value1 = Optional.of("hello");
    Optional<String> value2 = Optional.of("world");
    Optional<String> result = ConditionUtil.nvl(value1, value2);
    assertTrue(result.isPresent());
    assertEquals(value1.get(), result.get());
  }

  @Test
  public void testNvlWithOptional_value1Empty() {
    Optional<String> value1 = Optional.empty();
    Optional<String> value2 = Optional.of("world");
    Optional<String> result = ConditionUtil.nvl(value1, value2);
    assertTrue(result.isPresent());
    assertEquals(value2.get(), result.get());
  }

  @Test
  public void testNvlWithSupplier_value1NotNull() {
    Supplier<String> supplier1 = () -> "hello";
    Supplier<String> supplier2 = () -> "world";
    String result = ConditionUtil.nvl(supplier1, supplier2);
    assertNotNull(result);
    assertEquals(supplier1.get(), result);
  }

  @Test
  public void testNvlWithSupplier_value1Null() {
    Supplier<String> supplier1 = () -> null;
    Supplier<String> supplier2 = () -> "world";
    String result = ConditionUtil.nvl(supplier1, supplier2);
    assertNotNull(result);
    assertEquals(supplier2.get(), result);
  }

  @Test
  public void testNvl2_value1NotNull() {
    String value1 = "hello";
    String value2 = "world";
    String value3 = "universe";
    String result = ConditionUtil.nvl2(value1, value2, value3);
    assertNotNull(result);
    assertEquals(value2, result);
  }

  @Test
  public void testNvl2_value1Null() {
    String value1 = null;
    String value2 = "world";
    String value3 = "universe";
    String result = ConditionUtil.nvl2(value1, value2, value3);
    assertNotNull(result);
    assertEquals(value3, result);
  }

  @Test
  public void testNvl2WithOptional_value1Present() {
    Optional<String> value1 = Optional.of("hello");
    Optional<String> value2 = Optional.of("world");
    Optional<String> value3 = Optional.of("universe");
    Optional<String> result = ConditionUtil.nvl2(value1, value2, value3);
    assertNotNull(result);
    assertEquals(value2, result);
  }

  @Test
  public void testNvl2WithOptional_value1Absent() {
    Optional<String> value1 = Optional.empty();
    Optional<String> value2 = Optional.of("world");
    Optional<String> value3 = Optional.of("universe");
    Optional<String> result = ConditionUtil.nvl2(value1, value2, value3);
    assertNotNull(result);
    assertEquals(value3, result);
  }

  @Test
  public void testNvl2WithSupplier_value1NotNull() {
    Supplier<String> supplier1 = () -> "hello";
    Supplier<String> supplier2 = () -> "world";
    Supplier<String> supplier3 = () -> "universe";
    String result = ConditionUtil.nvl2(supplier1, supplier2, supplier3);
    assertNotNull(result);
    assertEquals(supplier2.get(), result);
  }

  @Test
  public void testNvl2WithSupplier_value1Null() {
    Supplier<String> supplier1 = () -> null;
    Supplier<String> supplier2 = () -> "world";
    Supplier<String> supplier3 = () -> "universe";
    String result = ConditionUtil.nvl2(supplier1, supplier2, supplier3);
    assertNotNull(result);
    assertEquals(supplier3.get(), result);
  }

  @Test
  public void testCoalesce_firstValueNotNull() {
    String value1 = "hello";
    String value2 = "world";
    String value3 = "universe";
    String result = ConditionUtil.coalesce(value1, value2, value3);
    assertNotNull(result);
    assertEquals(value1, result);
  }

  @Test
  public void testCoalesce_firstValueNull() {
    String value1 = null;
    String value2 = "world";
    String value3 = "universe";
    String result = ConditionUtil.coalesce(value1, value2, value3);
    assertNotNull(result);
    assertEquals(value2, result);
  }

  @Test
  public void testCoalesce_firstAndFirstValueNull() {
    String value1 = null;
    String value2 = null;
    String value3 = "universe";
    String result = ConditionUtil.coalesce(value1, value2, value3);
    assertNotNull(result);
    assertEquals(value3, result);
  }

  @Test
  public void testCoalesceWithOptional_firstValuePresent() {
    Optional<String> value1 = Optional.of("hello");
    Optional<String> value2 = Optional.of("world");
    Optional<String> value3 = Optional.of("universe");
    Optional<String> result = ConditionUtil.coalesce(value1, value2, value3);
    assertTrue(result.isPresent());
    assertEquals(value1.get(), result.get());
  }

  @Test
  public void testCoalesceWithOptional_firstValueEmpty() {
    Optional<String> value1 = Optional.empty();
    Optional<String> value2 = Optional.of("world");
    Optional<String> value3 = Optional.of("universe");
    Optional<String> result = ConditionUtil.coalesce(value1, value2, value3);
    assertTrue(result.isPresent());
    assertEquals(value2.get(), result.get());
  }

  @Test
  public void testCoalesceWithOptional_firstAndSecondValueEmpty() {
    Optional<String> value1 = Optional.empty();
    Optional<String> value2 = Optional.empty();
    Optional<String> value3 = Optional.of("universe");
    Optional<String> result = ConditionUtil.coalesce(value1, value2, value3);
    assertTrue(result.isPresent());
    assertEquals(value3.get(), result.get());
  }

  @Test
  public void testCoalesceWithSupplier_firstValueNotNull() {
    String value1 = "hello";
    String value2 = "world";
    String value3 = "universe";
    String result = ConditionUtil.coalesce(() -> value1, () -> value2, () -> value3);
    assertNotNull(result);
    assertEquals(value1, result);
  }

  @Test
  public void testCoalesceWithSupplier_firstValueNull() {
    String value1 = null;
    String value2 = "world";
    String value3 = "universe";
    String result = ConditionUtil.coalesce(() -> value1, () -> value2, () -> value3);
    assertNotNull(result);
    assertEquals(value2, result);
  }

  @Test
  public void testCoalesceWithSupplier_firstAndSecondValueNull() {
    String value1 = null;
    String value2 = null;
    String value3 = "universe";
    String result = ConditionUtil.coalesce(() -> value1, () -> value2, () -> value3);
    assertNotNull(result);
    assertEquals(value3, result);
  }
}
