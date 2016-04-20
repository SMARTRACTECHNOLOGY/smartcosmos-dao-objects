package net.smartcosmos.dto.objects;

import javax.validation.constraints.NotNull;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author voor
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateObjectDto {
    @NotNull
    private String objectUrn;
    @NotNull
    private String type;
    @NotNull
    private String name;
    private String description;
    private Boolean activeFlag = true;
    private String moniker;
    private String returnValueType;
}
