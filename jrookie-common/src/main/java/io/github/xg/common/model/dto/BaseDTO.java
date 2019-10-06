package io.github.xg.common.model.dto;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Base DTO.
 *
 * @author xingguan.wzt
 * @date 2019/10/06
 */
@Getter
@ToString
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
public abstract class BaseDTO implements Serializable {
    private static final long serialVersionUID = 8099725513398095489L;

    /**
     * unique primary key.
     */
    @NotNull
    private final Long id;

    /**
     * create time.
     */
    @NotNull
    private final Instant created;

    /**
     * update time.
     */
    @NotNull
    private final Instant updated;

    BaseDTO(final Builder builder) {
        this.id = builder.bId;
        this.created = builder.bCreated;
        this.updated = builder.bUpdated;
    }

    /**
     * Builder pattern to save constructor arguments.
     *
     * @param <T> Type of builder that extends this
     * @author xingguan.wzt
     */
    @SuppressWarnings("unchecked")
    public abstract static class Builder<T extends Builder> {
        private Long bId;
        private Instant bCreated;
        private Instant bUpdated;

        protected Builder() {
        }

        /**
         * Set the id for the DTO.
         *
         * @param id The id
         * @return The builder
         */
        public T withId(@NotNull Long id) {
            this.bId = id;
            return (T)this;
        }

        /**
         * Set the created time for the DTO.
         *
         * @param created The created time
         * @return The builder
         */
        public T withCreated(@NotNull Instant created) {
            this.bCreated = created;
            return (T)this;
        }

        /**
         * Set the updated time for the DTO.
         *
         * @param updated The updated time
         * @return The builder
         */
        public T withUpdated(@NotNull Instant updated) {
            this.bUpdated = updated;
            return (T)this;
        }
    }
}
