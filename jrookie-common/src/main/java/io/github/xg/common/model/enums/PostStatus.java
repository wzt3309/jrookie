package io.github.xg.common.model.enums;

/**
 * Post status.
 *
 * @author xingguan.wzt
 * @date 2019/07/22
 */
public enum PostStatus implements ValueEnum<Integer> {
    /**
     * Published.
     */
    PUBLISHED(0),

    /**
     * Draft.
     */
    DRAFT(1),

    /**
     * Recycle.
     */
    RECYCLE(2),
    ;

    private final Integer value;

    PostStatus(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
