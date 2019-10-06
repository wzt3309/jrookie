package io.github.xg.common.model.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.github.xg.common.model.enums.CommentStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import static io.github.xg.common.utils.ServiceUtils.isEmptyId;

/**
 * Base comment DO.
 *
 * @author xingguan.wzt
 * @date 2019/07/21
 */
@Data
@Entity
@Table(name = "comment")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER, columnDefinition = "int default 0")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseComment extends BaseDO<Long> {
    private static final long serialVersionUID = -8099440207840229999L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Commentator's name.
     */
    @Column(name = "author", columnDefinition = "varchar(64) not null")
    private String author;

    /**
     * Commentator's email.
     */
    @Column(name = "email", columnDefinition = "varchar(256) not null")
    private String email;

    /**
     * Commentator's ip address.
     */
    @Column(name = "ip_address", columnDefinition = "varchar(128) default ''")
    private String ipAddress;

    /**
     * Commentator's website.
     */
    @Column(name = "author_url", columnDefinition = "varchar(512) default ''")
    private String authorUrl;

    /**
     * Commentator's gravatar md5.
     *
     * @see <a href="https://cn.gravatar.com/site/implement/images/java/">How To Use Gravatar in Java</a>
     */
    @Column(name = "gravatar_md5", columnDefinition = "varchar(128) default ''")
    private String gravatarMd5;

    /**
     * Comment content.
     */
    @Column(name = "content", columnDefinition = "varchar(1024) not null")
    private String content;

    /**
     * Comment status.
     */
    @Column(name = "status", columnDefinition = "int default 0")
    private CommentStatus status;

    /**
     * Commentator's agent.
     */
    @Column(name = "user_agent", columnDefinition = "varchar(512) default ''")
    private String userAgent;

    /**
     * Is admin comment.
     */
    @Column(name = "is_admin", columnDefinition = "tinyint default 0")
    private Boolean isAdmin;

    /**
     * Post id.
     */
    @Column(name = "post_id", columnDefinition = "bigint not null")
    private Long postId;

    /**
     * Whether to top the comment.
     */
    @Column(name = "top_priority", columnDefinition = "int default 0")
    private Integer topPriority;

    /**
     * Parent comment.
     */
    @Column(name = "parent_id", columnDefinition = "bigint default 0")
    private Long parentId;

    @Override
    protected void prePersist() {
        super.prePersist();

        if (isEmptyId(id)) {
            id = null;
        }

        if (isEmptyId(parentId)) {
            parentId = 0L;
        }

        if (ipAddress == null) {
            ipAddress = StringUtils.EMPTY;
        }

        if (authorUrl == null) {
            authorUrl = StringUtils.EMPTY;
        }

        if (gravatarMd5 == null) {
            gravatarMd5 = StringUtils.EMPTY;
        }

        if (status == null) {
            status = CommentStatus.AUDITING;
        }

        if (userAgent == null) {
            userAgent = StringUtils.EMPTY;
        }

        if (isAdmin == null) {
            isAdmin = false;
        }
    }
}
