package io.github.xg.common.model.enums;

import javax.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang3.StringUtils;

/**
 * Application runtime mode.
 *
 * @author xingguan.wzt
 * @date 2019/10/06
 */
public enum Mode {

    /**
     * 生产环境
     */
    PRODUCTION,

    /**
     * 开发环境
     */
    DEVELOPMENT,

    /**
     * 测试环境
     */
    TEST,
    ;

    private final static String CONST_PROD = "prod";
    private final static String CONST_DEV = "dev";
    private final static String CONST_TEST = "test";

    @Nullable
    @JsonCreator
    public static Mode valueFrom(@Nullable String value) {
        if (StringUtils.isBlank(value) || CONST_DEV.equalsIgnoreCase(value)) {
            return DEVELOPMENT;
        }

        if (CONST_PROD.equalsIgnoreCase(value)) {
            return PRODUCTION;
        }

        if (CONST_TEST.equalsIgnoreCase(value)) {
            return TEST;
        }

        return null;
    }

    @JsonValue
    String getValue() {
        return this.name().toLowerCase();
    }
}
