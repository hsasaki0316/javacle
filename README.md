## Javacle
- We created this library to use Oracle DB conditional functions in Java.
- We have also extended these functions to handle Optional and Supplier types.

## Example
- The coalesce method returns the first non-null value, similar to Oracle's.
```
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
  public void testCoalesce_firstAndSecondValueNull() {
    String value1 = null;
    String value2 = null;
    String value3 = "universe";
    String result = ConditionUtil.coalesce(value1, value2, value3);
    assertNotNull(result);
    assertEquals(value3, result);
  }
```

- When using Optional, it returns the first "isPresent" value.
```
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
```

- Arguments can also be given as Supplier.
- This avoids unnecessary evaluation.
```
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
```

- nvl, nvl2, etc. are also supported.
```
  @Test
  public void testNvl_value1Null() {
    String value1 = null;
    String value2 = "world";
    String result = ConditionUtil.nvl(value1, value2);
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
```
