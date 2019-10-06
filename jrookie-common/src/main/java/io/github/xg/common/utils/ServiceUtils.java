package io.github.xg.common.utils;

/**
 * Service utils.
 *
 * @author xingguan.wzt
 * @date 2019/07/22
 */
public final class ServiceUtils {

    private ServiceUtils() {}

    /**
     * Checks if the given number is empty id.
     *
     * @param id the given number id
     * @return true if the given number is empty id, otherwise false
     */
    public static boolean isEmptyId(Number id) {
        return id == null || id.longValue() <= 0;
    }
}
