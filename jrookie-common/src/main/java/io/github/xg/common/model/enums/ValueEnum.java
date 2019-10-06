package io.github.xg.common.model.enums;

import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Interface for value enum.
 *
 * @author xingguan.wzt
 * @date 2019/07/22
 */
public interface ValueEnum<T> {

    /**
     * Converts value to corresponding enum constant.
     *
     * @param enumType enum type
     * @param value    real value
     * @param <V>      value generic
     * @param <E>      enum generic
     * @return corresponding enum constant
     */
    static <V, E extends ValueEnum<V>> E value2Enum(Class<E> enumType, V value) {
        checkNotNull(enumType, "enum type must not be null");
        checkArgument(enumType.isEnum(), "type must be an enum type");
        checkNotNull(value, "value must not be null");

        return Stream.of(enumType.getEnumConstants())
            .filter(item -> item.getValue().equals(value))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("unknown real value: " + value));
    }

    /**
     * Get value of enum constant.
     *
     * @return enum value
     */
    T getValue();
}
