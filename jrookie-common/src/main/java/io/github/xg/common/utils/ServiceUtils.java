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
     * Checks if the given number is empty.
     *
     * @param id The given number
     * @return true if the given number is empty, otherwise false
     */
    public static boolean isEmpty(Number id) {
        return id == null || id.longValue() <= 0;
    }
}
