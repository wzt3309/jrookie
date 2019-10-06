package io.github.xg.common.model.enums;

/**
 * Comment status.
 *
 * @author xingguan.wzt
 * @date 2019/07/22
 */
public enum CommentStatus implements ValueEnum<Integer> {
    /**
     * Published.
     */
    PUBLISHED(0),

    /**
     * Auditing.
     */
    AUDITING(1),

    /**
     * Recycle
     */
    RECYCLE(2),
    ;

    private final Integer value;

    CommentStatus(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return this.value;
    }
}
