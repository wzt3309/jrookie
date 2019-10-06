package io.github.xg.core.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.github.xg.common.model.domain.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import static io.github.xg.common.utils.ServiceUtils.isEmpty;

/**
 * Category domain.
 *
 * @author xingguan.wzt
 * @date 2019/10/06
 */
@Data
@Entity
@Table(name = "category")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseDO {
    private static final long serialVersionUID = -6792846734624620472L;

    /**
     * Category name.
     */
    @Column(name = "name", columnDefinition = "varchar(50) not null")
    private String name;

    /**
     * Category slug name.
     */
    @Column(name = "slug_name", columnDefinition = "varchar(50) not null", unique = true)
    private String slugName;

    /**
     * (Optional) Category description.
     */
    @Column(name = "description", columnDefinition = "varchar(255) default ''")
    private String description;

    /**
     * (Optional) Parent category's id
     */
    @Column(name = "parent_id", columnDefinition = "bigint default 0")
    private Long parentId;

    @Override
    protected void prePersist() {
        super.prePersist();

        if (description == null) {
            description = StringUtils.EMPTY;
        }

        if (isEmpty(parentId)) {
            parentId = 0L;
        }
    }
}
