package io.github.xg.security.token;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.xg.security.utils.TokenUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A signed token implementation.
 *
 * @author xingguan.wzt
 * @date 2019/10/07
 */
@Data
@EqualsAndHashCode(of = "key", doNotUseGetters = true)
public class SignedToken implements TokenData {
    private String username;
    private String deviceHash;
    private String key;
    private long creationTime;

    @JsonCreator
    public SignedToken(
        @JsonProperty("username") String username,
        @JsonProperty("deviceHash") String deviceHash,
        @JsonProperty("key") String key,
        @JsonProperty("creationTime") long creationTime) {
        this.username = username;
        this.deviceHash = deviceHash;
        this.key = key;
        this.creationTime = creationTime;
    }

    @Override
    public String getType() {
        return TokenUtils.getTypeFromKey(this.key);
    }
}
