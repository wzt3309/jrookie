package io.github.xg.common.model.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Base meta DO.
 *
 * @author xingguan.wzt
 * @date 2019/10/06
 */
@Data
@Entity
@Table(name = "meta")
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.INTEGER, columnDefinition = "int default 0")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class BaseMeta extends BaseDO {
    private static final long serialVersionUID = 7518658749891152305L;

    /**
     * Post id.
     */
    @Column(name = "post_id", columnDefinition = "bigint not null")
    private Long postId;

    /**
     * Meta key.
     */
    @Column(name = "meta_key", columnDefinition = "varchar(100) not null")
    private String key;

    /**
     * Meta value.
     */
    @Column(name = "meta_value", columnDefinition = "varchar(1023) not null")
    private String value;
}
