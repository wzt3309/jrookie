package io.github.xg.core.model.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.github.xg.common.model.domain.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

/**
 * User domain.
 *
 * @author xingguan.wzt
 * @date 2019/10/06
 */
@Data
@Entity
@Table(name = "user")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseDO {
    private static final long serialVersionUID = -1138986165811706007L;

    /**
     * User name.
     */
    @Column(name = "username", columnDefinition = "varchar(50) not null")
    private String username;

    /**
     * Password.
     */
    @Column(name = "password", columnDefinition = "varchar(255) not null")
    private String password;

    /**
     * User nick name,used to display on page.
     */
    @Column(name = "nickname", columnDefinition = "varchar(255) not null")
    private String nickname;

    /**
     * (Optional) User email.
     */
    @Column(name = "email", columnDefinition = "varchar(127) default ''")
    private String email;

    /**
     * (Optional) User avatar.
     */
    @Column(name = "avatar", columnDefinition = "varchar(1023) default ''")
    private String avatar;

    /**
     * (Optional) User description.
     */
    @Column(name = "description", columnDefinition = "varchar(1023) default ''")
    private String description;

    /**
     * Expire time.
     */
    @Column(name = "expire_time")
    private Instant expireTime;

    @Override
    public void prePersist() {
        super.prePersist();

        if (email == null) {
            email = StringUtils.EMPTY;
        }

        if (avatar == null) {
            avatar = StringUtils.EMPTY;
        }

        if (description == null) {
            description = StringUtils.EMPTY;
        }

        if (expireTime == null) {
            expireTime = Instant.now();
        }
    }
}
