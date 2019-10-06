package io.github.xg.core.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.github.xg.common.model.domain.BaseDO;
import io.github.xg.common.utils.DateUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * User model.
 *
 * @author xingguan.wzt
 * @date 2019/07/22
 */
@Data
@Entity
@Table(name = "users")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class User extends BaseDO<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * User login name.
     */
    @Column(name = "username", columnDefinition = "varchar(50) not null")
    private String username;

    /**
     * User login password.
     */
    @Column(name = "password", columnDefinition = "varchar(255) not null")
    private String password;

    /**
     * User nick name, used to display on page.
     */
    @Column(name = "nickname", columnDefinition = "varchar(255) not null")
    private String nickname;

    /**
     * User email.
     */
    @Column(name = "email", columnDefinition = "varchar(128) default ''")
    private String email;

    /**
     * User avatar.
     */
    @Column(name = "avatar", columnDefinition = "varchar(1024) default ''")
    private String avatar;

    /**
     * User description.
     */
    @Column(name = "description", columnDefinition = "varchar(1023) default ''")
    private String description;

    /**
     * Expire time.
     */
    @Column(name = "expire_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime expireTime;

    @Override
    public void prePersist() {
        super.prePersist();

        id = null;

        if (email == null) {
            email = "";
        }

        if (avatar == null) {
            avatar = "";
        }

        if (description == null) {
            description = "";
        }

        if (expireTime == null) {
            expireTime = DateUtils.now();
        }
    }
}
