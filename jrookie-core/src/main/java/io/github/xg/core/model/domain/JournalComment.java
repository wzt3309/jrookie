package io.github.xg.core.model.domain;

import javax.persistence.DiscriminatorValue;

import io.github.xg.common.model.domain.BaseComment;

/**
 * Journal comment.
 *
 * @author xingguan.wzt
 * @date 2019/10/06
 * @see io.github.xg.common.model.enums.CommentType#JOURNAL
 */
@DiscriminatorValue("journal")
public class JournalComment extends BaseComment {
}
