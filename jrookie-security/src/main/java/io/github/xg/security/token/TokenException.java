package io.github.xg.security.token;

/**
 * An exception which is thrown when token is invalid or expired.
 *
 * @author xingguan.wzt
 * @date 2019/10/07
 */
public class TokenException extends RuntimeException {
    public TokenException(String message) {
        super(message);
    }
}
