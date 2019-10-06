package io.github.xg.core.model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.github.xg.common.model.domain.BaseDO;
import io.github.xg.core.model.enums.JournalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author xingguan.wzt
 * @date 2019/10/06
 */
@Data
@Entity
@Table(name = "journal")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Journal extends BaseDO {
    private static final long serialVersionUID = 5890018755326384929L;

    @Column(name = "content", columnDefinition = "varchar(1023) not null")
    private String content;

    @Column(name = "likes", columnDefinition = "bigint default 0")
    private Long likes;

    @Column(name = "type", columnDefinition = "int default 1")
    private JournalType type;

}
