package io.github.xg.common.model.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;

/**
 * Base domain object.
 *
 * @author wzt3309 2019/07/14
 */
@MappedSuperclass
@Data
public abstract class BaseDO<ID extends Serializable> implements Serializable {
    private static final long serialVersionUID = -2564132965815330577L;

    @Transient
    private ID id;

    /**
     * Create timestamp.
     */
    @Column(
        name = "create_time",
        nullable = false,
        updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Instant createTime;

    /**
     * Update timestamp.
     */
    @Column(
        name = "update_time",
        nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
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
