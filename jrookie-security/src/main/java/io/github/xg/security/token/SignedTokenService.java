package io.github.xg.security.token;

/**
 * @author xingguan.wzt
 * @date 2019/10/07
 */
public class SignedTokenService implements TokenService {
    @Override
    public TokenData createToken(CreateTokenRequest request) {
        return null;
    }

    @Override
    public TokenData getToken(String token) throws TokenException {
        return null;
    }

    @Override
    public void removeToken(String token) {

    }

    @Override
    public void removeUserTokens(String username) {

    }
}
