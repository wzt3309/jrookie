package io.github.xg.common.model.enums;

/**
 * Post create from enum.
 *
 * @author xingguan.wzt
 * @date 2019/07/22
 */
public enum PostCreateFrom implements ValueEnum<Integer> {
    /**
     * Post from Admin
     */
    ADMIN(0),

    /**
     * Post from WeChat
     */
    WECHAT(1),
    ;

    private final Integer value;

    PostCreateFrom(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
