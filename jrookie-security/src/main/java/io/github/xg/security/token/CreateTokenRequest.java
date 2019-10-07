package io.github.xg.security.token;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request of create a token.
 *
 * @author xingguan.wzt
 * @date 2019/10/07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTokenRequest {

    /**
     * Username of access entity.
     */
    private String username;

    /**
     * Device hash of access entity, may depend on ip, mac address, etc.
     */
    private String deviceHash;
}
