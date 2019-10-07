package io.github.xg.security.token;

/**
 * Interface of any type token data.
 * Token can be identified by {@link #getKey()}
 *
 * @author xingguan.wzt
 * @date 2019/10/07
 */
public interface TokenData {

    /**
     * Get username of access entity.
     *
     * @return username
     */
    String getUsername();

    /**
     * Get hash identity of access device.
     *
     * @return device hash
     */
    String getDeviceHash();

    /**
     * Get type of token data, we can support any type token like 'JWT', etc.
     *
     * @return type
     */
    String getType();

    /**
     * Access key of token data.
     *
     * @return key
     */
    String getKey();

    /**
     * Get creation time of token.
     *
     * @return creation time
     */
    long getCreationTime();
}
