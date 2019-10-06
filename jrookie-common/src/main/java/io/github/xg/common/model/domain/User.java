package io.github.xg.common.model.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import static io.github.xg.common.utils.ServiceUtils.isEmptyId;

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
public class User extends BaseDO<Long> {
    private static final long serialVersionUID = -1138986165811706007L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
     * User email.
     */
    @Column(name = "email", columnDefinition = "varchar(127) default ''")
    private String email;

    /**
     * User avatar.
     */
    @Column(name = "avatar", columnDefinition = "varchar(1023) default ''")
    private String avatar;

    /**
     * User description.
     */
    @Column(name = "description", columnDefinition = "varchar(1023) default ''")
    private String description;

    /**
     * Expire time.
     */
    @Column(name = "expire_time")
    private Instant expireTime;

    @PrePersist
    @Override
    public void prePersist() {
        super.prePersist();

        if (isEmptyId(id)) {
            id = null;
        }

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
