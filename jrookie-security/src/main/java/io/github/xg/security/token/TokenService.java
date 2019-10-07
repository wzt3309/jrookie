package io.github.xg.security.token;

/**
 * Service of managing token.
 *
 * @author xingguan.wzt
 * @date 2019/10/07
 */
public interface TokenService {

    /**
     * Create and persist a new token.
     *
     * @param request request
     * @return token
     */
    TokenData createToken(CreateTokenRequest request);

    /**
     * Get specified token if it exist and valid.
     *
     * @param token token in string
     * @return specified token
     * @throws TokenException throws exception if token is invalid
     */
    TokenData getToken(String token) throws TokenException;

    /**
     * Remove specified token.
     *
     * @param token token
     */
    void removeToken(String token);

    /**
     * Remove all user tokens.
     *
     * @param username username
     */
    void removeUserTokens(String username);
}
