package io.github.xg.core.model.enums;

import io.github.xg.common.model.enums.ValueEnum;

/**
 * Journal type.
 *
 * @author xingguan.wzt
 * @date 2019/10/06
 */
public enum JournalType implements ValueEnum<Integer> {
    /**
     * Public type.
     */
    PUBLIC(1),

    /**
     * Intimate type.
     */
    INTIMATE(0),
    ;

    private final int value;

    JournalType(int value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
