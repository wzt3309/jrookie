package io.github.xg.common.model.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import lombok.Data;

import static io.github.xg.common.utils.ServiceUtils.isEmpty;

/**
 * Base domain object.
 *
 * @author wzt3309 2019/07/14
 */
@MappedSuperclass
@Data
public abstract class BaseDO implements Serializable {
    private static final long serialVersionUID = -2564132965815330577L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Create timestamp.
     */
    @Column(name = "create_time", nullable = false, updatable = false)
    private Instant createTime;

    /**
     * Update timestamp.
     */
    @Column(name = "update_time", nullable = false)
    private Instant updateTime;

    /**
     * Delete flag.
     */
    @Column(name = "deleted", columnDefinition = "tinyint default 0 ")
    private Boolean deleted;

    /**
     * Set create time and update time when the model is persisting (not happen in db yet).
     */
    @PrePersist
    protected void prePersist() {
        deleted = false;

        if (isEmpty(id)) {
            id = null;
        }

        if (createTime == null) {
            createTime = Instant.now();
        }
        if (updateTime == null) {
            updateTime = Instant.now();
        }
    }

    /**
     * Set update time when the model is updating (not happen in db yet).
     */
    @PreUpdate
    protected void preUpdate() {
        updateTime = Instant.now();
    }

    /**
     * Set update time and delete flag when the mode is removing (not happen in db yet).
     */
    @PreRemove
    protected void preRemove() {
        deleted = true;
        updateTime = Instant.now();
    }
}
