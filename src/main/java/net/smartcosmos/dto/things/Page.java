package net.smartcosmos.dto.things;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties({"version"})
@ApiModel(description = "Paged response received when querying for Things.")
public class Page<T> {

    private final List<T> data;
    private final PageInformation page;

    @ConstructorProperties({"data", "page"})
    public Page(List<T> data, PageInformation page) {
        this.data = new ArrayList<>();
        if (data != null) {
            this.data.addAll(data);
        }

        this.page = page;
    }

    public static <T>PageBuilder<T> builder() {
        return new PageBuilder<>();
    }

    public static class PageBuilder<T> {
        private List<T> data;
        private PageInformation page;

        PageBuilder() {
        }

        public Page.PageBuilder<T> data(List<T> data) {
            this.data = data;
            return this;
        }

        public Page.PageBuilder<T> page(PageInformation page) {
            this.page = page;
            return this;
        }

        public Page<T> build() {
            return new Page<>(data, page);
        }

        public String toString() {
            return "net.smartcosmos.dto.things.Page.PageBuilder(data=" + this.data + ", page=" + this.page + ")";
        }
    }
}
