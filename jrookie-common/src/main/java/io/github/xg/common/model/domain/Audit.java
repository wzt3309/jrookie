package io.github.xg.common.model.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;

/**
 * Audit domain.
 *
 * @author xingguan.wzt
 * @date 2019/10/07
 */
@Getter
@MappedSuperclass
@ToString
public abstract class Audit implements Serializable {
    private static final long serialVersionUID = -4177818533102400380L;

    /**
     * Create timestamp.
     */
    @Basic(optional = false)
    @Column(name = "created", nullable = false, updatable = false)
    private Instant created;

    /**
     * Update timestamp.
     */
    @Basic(optional = false)
    @Column(name = "updated", nullable = false)
    private Instant updated;

    /**
     * Audit version for optimistic lock.
     */
    @Version
    @Column(name = "audit_version", nullable = false)
    @Getter(AccessLevel.NONE)
    private Integer auditVersion;

    /**
     * Updates the created and updated timestamps to be creation time.
     */
    @PrePersist
    protected void prePersist() {
        final Instant now = Instant.now();
        this.created = now;
        this.updated = now;
    }

    /**
     * On any update to the entity will update the update time.
     */
    @PreUpdate
    protected void onUpdateBaseEntity() {
        this.updated = Instant.now();
    }
}
