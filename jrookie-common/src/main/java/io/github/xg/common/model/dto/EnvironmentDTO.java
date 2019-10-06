package io.github.xg.common.model.dto;

import java.time.Instant;

import io.github.xg.common.model.enums.Mode;
import lombok.Data;

/**
 * Base DTO for DTOs which require application runtime mode.
 *
 * @author xingguan.wzt
 * @date 2019/10/06
 */
@Data
public class EnvironmentDTO {

    /**
     * Application start time.
     */
    private Instant startTime;

    /**
     * Application version.
     */
    private String version;

    /**
     * Application runtime mode
     */
    private Mode mode;
}
