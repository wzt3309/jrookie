package io.github.xg.security.utils;

import io.github.xg.security.token.TokenException;
import org.springframework.util.StringUtils;

import static org.apache.logging.log4j.util.Strings.EMPTY;

/**
 * Token utils.
 *
 * @author xingguan.wzt
 * @date 2019/10/07
 */
public class TokenUtils {
    private TokenUtils() {
    }

    /**
     * Get value 'type' from key.
     *
     * @param key key, like 'any_type:any_signed_token'
     * @return type
     */
    public static String getTypeFromKey(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new TokenException("The Key is null or empty");
        }

        int i = key.indexOf(':');
        if (i == -1) {
            throw new TokenException("The index of separator ':' in key for type is -1");
        }
        return key.substring(0, i);
    }

    /**
     * Get value 'token' from key.
     *
     * @param key key, like 'any_type:any_signed_token'
     * @return token
     */
    public static String getTokenFromKey(String key) {
        if (StringUtils.isEmpty(key)) {
            throw new TokenException("Th key is null or empty");
        }

        int i = key.indexOf(':');
        if (i == -1) {
            throw new TokenException("The index of separator ':' in key for token is -1");
        }
        return key.substring(i + 1);
    }

    /**
     * Concat 'type' and 'token' to token key.
     *
     * @param type type
     * @param token token
     * @return key, like 'any_type:any_signed_token'
     */
    public static String getKeyWithTypeAndToken(String type, String token) {
        type = (type == null) ? EMPTY : type;
        token = (token == null) ? EMPTY : token;
        return type.concat(":").concat(token);
    }
}
