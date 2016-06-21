package net.smartcosmos.dto.things;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
@ApiModel(description = "Meta information on paged responses received.")
public class PageInformation {
    private final Integer size;
    private final Long totalElements;
    private final Integer totalPages;
    private final Integer number;
}
