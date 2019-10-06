package io.github.xg.common.model.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.github.xg.common.model.enums.PostCreateFrom;
import io.github.xg.common.model.enums.PostStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import static io.github.xg.common.utils.ServiceUtils.isEmptyId;

/**
 * Base post DO.
 *
 * @author xingguan.wzt
 * @date 2019/07/22
 */
@Data
@Entity
@Table(name = "post")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER, columnDefinition = "int default 0")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BasePost extends BaseDO<Long> {
    private static final long serialVersionUID = 3420736514267636524L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Post status.
     */
    @Column(name = "status", columnDefinition = "tinyint default 0")
    private PostStatus status;

    /**
     * Post create from.
     */
    @Column(name = "create_from", columnDefinition = "tinyint default 0")
    private PostCreateFrom createFrom;

    /**
     * Post title.
     */
    @Column(name = "title", columnDefinition = "varchar(128) not null")
    private String title;

    /**
     * Post url.
     */
    @Column(name = "url", columnDefinition = "varchar(255) not null")
    private String url;

    /**
     * Post original content, not format.
     */
    @Column(name = "original_content", columnDefinition = "text not null")
    private String originalContent;

    /**
     * Format content.
     */
    @Column(name = "format_content", columnDefinition = "text not null")
    private String formatContent;

    /**
     * Summary of post.
     */
    @Column(name = "summary", columnDefinition = "varchar(512) ''")
    private String summary;

    /**
     * Cover thumbnail of post.
     */
    @Column(name = "thumbnail", columnDefinition = "varchar(1024) ''")
    private String thumbnail;

    /**
     * Post visits.
     */
    @Column(name = "visits", columnDefinition = "bigint default 0")
    private Long visits;

    /**
     * Post likes.
     */
    @Column(name = "likes", columnDefinition = "bigint default 0")
    private Long likes;

    /**
     * Whether to allow comment.
     */
    @Column(name = "is_allow_comment", columnDefinition = "tinyint default 0")
    private Boolean isAllowComment;

    /**
     * Post password.
     */
    @Column(name = "password", columnDefinition = "varchar(255) default ''")
    private String password;

    /**
     * Custom template.
     */
    @Column(name = "template", columnDefinition = "varchar(255) default ''")
    private String template;

    /**
     * Whether to top the post.
     */
    @Column(name = "top_priority", columnDefinition = "tinyint default 0")
    private Integer topPriority;

    /**
     * Edit time.
     */
    @Column(name = "edit_time")
    private Instant editTime;

    @Override
    protected void prePersist() {
        super.prePersist();

        if (isEmptyId(id)) {
            id = null;
        }

        if (editTime == null) {
            editTime = getCreateTime();
        }

        if (status == null) {
            status = PostStatus.DRAFT;
        }

        if (summary == null) {
            summary = StringUtils.EMPTY;
        }

        if (thumbnail == null) {
            thumbnail = StringUtils.EMPTY;
        }

        if (isAllowComment == null) {
            isAllowComment = false;
        }

        if (password == null) {
            password = StringUtils.EMPTY;
        }

        if (template == null) {
            template = StringUtils.EMPTY;
        }

        if (topPriority == null) {
            topPriority = 0;
        }

        if (createFrom == null) {
            createFrom = PostCreateFrom.ADMIN;
        }

        if (visits == null || visits < 0) {
            visits = 0L;
        }

        if (likes == null || likes < 0) {
            likes = 0L;
        }
    }
}