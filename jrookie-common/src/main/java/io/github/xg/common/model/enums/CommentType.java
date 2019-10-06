package io.github.xg.common.model.enums;

/**
 * Comment type.
 *
 * @author xingguan.wzt
 * @date 2019/10/06
 */
public enum CommentType implements ValueEnum<String> {

    /**
     * Journal type
     */
    JOURNAL("journal"),
    ;

    private final String value;

    CommentType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
