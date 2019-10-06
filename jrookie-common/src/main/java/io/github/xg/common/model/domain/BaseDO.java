package io.github.xg.common.model.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreRemove;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import static io.github.xg.common.utils.ServiceUtils.isEmpty;

/**
 * Base domain object.
 *
 * @author wzt3309 2019/07/14
 */
@Getter
@Setter
@MappedSuperclass
@ToString(callSuper = true, of = {"id"})
public abstract class BaseDO extends Audit {
    private static final long serialVersionUID = -2564132965815330577L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Delete flag.
     */
    @Column(name = "deleted", columnDefinition = "tinyint default 0 ")
    private Boolean deleted;

    /**
     * Set create time and update time when the model is persisting (not happen in db yet).
     */
    @Override
    protected void prePersist() {
        deleted = false;

        if (isEmpty(id)) {
            id = null;
        }
    }

    /**
     * Set update time and delete flag when the mode is removing (not happen in db yet).
     */
    @PreRemove
    protected void preRemove() {
        deleted = true;
    }
}
