package net.smartcosmos.dao.things;

import lombok.AllArgsConstructor;

/**
 * Enum of possible sort orders.
 */
@AllArgsConstructor
public enum SortOrder {
    ASC("asc"),
    DESC("desc");

    private final String sortOrder;

    @Override
    public String toString() {
        return this.sortOrder;
    }

    public static SortOrder fromString(String string) {
        String lcString = "";
        if (string != null) {
            lcString = string.toLowerCase();
        }

        return (DESC.toString().equals(lcString) ? DESC : ASC);
    }
}
