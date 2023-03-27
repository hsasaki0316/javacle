package net.hsasaki0316.javacle.condition;

import java.util.Optional;
import java.util.function.Supplier;

public class ConditionUtil {

  public static <T> T nvl(T value1, T value2) {
    return value1 != null ? value1 : value2;
  }

  public static <T> Optional<T> nvl(Optional<T> value1, Optional<T> value2) {
    return value1.isPresent() ? value1 : value2;
  }

  public static <T> T nvl(Supplier<? extends T> supplier1, Supplier<? extends T> supplier2) {
    T value1 = supplier1.get();
    return value1 != null ? value1 : supplier2.get();
  }

  public static <T> T nvl2(T value1, T value2, T value3) {
    return value1 != null ? value2 : value3;
  }

  public static <T> Optional<T> nvl2(Optional<T> value1, Optional<T> value2, Optional<T> value3) {
    return value1.isPresent() ? value2 : value3;
  }

  public static <T> T nvl2(Supplier<? extends T> supplier1, Supplier<? extends T> supplier2,
      Supplier<? extends T> supplier3) {
    T value1 = supplier1.get();
    return value1 != null ? supplier2.get() : supplier3.get();
  }

  @SafeVarargs
  public static <T> T coalesce(T... values) {
    for (T value : values) {
      if (value != null) {
        return value;
      }
    }
    return null;
  }

  @SafeVarargs
  public static <T> Optional<T> coalesce(Optional<T>... values) {
    for (Optional<T> optional : values) {
      if (optional.isPresent()) {
        return optional;
      }
    }
    return Optional.empty();
  }
  
  @SafeVarargs
  public static <T> T coalesce(Supplier<T>... suppliers) {
      for (Supplier<T> supplier : suppliers) {
          T value = supplier.get();
          if (value != null) {
              return value;
          }
      }
      return null;
  }
}