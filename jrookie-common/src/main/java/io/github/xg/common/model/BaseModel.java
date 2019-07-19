package io.github.xg.common.model;

import io.github.xg.common.utils.DateUtils;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Base Model
 * @author wzt3309 2019/07/14
 */
@MappedSuperclass
@Data
public abstract class BaseModel<ID extends Serializable> implements Serializable {

    @Transient
    private ID id;

    /**
     * Create timestamp
     */
    @Column(
            name = "create_time",
            nullable = false,
            updatable = false,
            columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createTime;

    /**
     * Update timestamp
     */
    @Column(
            name = "update_time",
            nullable = false,
            columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime updateTime;

    /**
     * Delete flag
     */
    @Column(name = "deleted", columnDefinition = "tinyint default 0 ")
    private boolean deleted = false;

    /**
     * Set create time and update time when the model is persisting (not happen in db yet)
     */
    @PrePersist
    protected void prePersist() {
        deleted = false;

        LocalDateTime now = DateUtils.now();
        if (createTime == null) {
            createTime = now;
        }
        if (updateTime == null) {
            updateTime = now;
        }
    }

    /**
     * Set update time when the model is updating (not happen in db yet)
     */
    @PreUpdate
    protected void preUpdate() {
        updateTime = DateUtils.now();
    }

    /**
     * Set update time and delete flag when the mode is removing (not happen in db yet)
     */
    @PreRemove
    protected void preRemove() {
        deleted = true;
        updateTime = DateUtils.now();
    }
}
