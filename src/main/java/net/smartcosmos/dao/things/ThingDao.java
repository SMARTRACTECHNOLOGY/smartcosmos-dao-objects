package net.smartcosmos.dao.things;

import net.smartcosmos.dto.things.ThingCreate;
import net.smartcosmos.dto.things.ThingResponse;
import net.smartcosmos.dto.things.ThingUpdate;

import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ThingDao {

    /**
     * Creates a thing in the realm of a given account.
     *
     * @param tenantId the tenant ID
     * @param thingCreate the thing to create
     * @return an {@link ThingResponse} instance for the created thing
     * @throws ConstraintViolationException if the {@link ThingCreate} violates constraints enforced by the persistence service
     */
    ThingResponse create(String tenantId, ThingCreate thingCreate) throws ConstraintViolationException;

    /**
     * Updates a thing in the realm of a given account.
     *
     * @param tenantId the tenant ID
     * @param thingUpdate the thing to update
     * @return an {@link ThingResponse} instance for the updated thing
     * @throws ConstraintViolationException if the {@link ThingUpdate} violates constraints enforced by the persistence service
     */
    Optional<ThingResponse> update(String tenantId, ThingUpdate thingUpdate) throws ConstraintViolationException;

    /**
     * Finds a thing matching a specified URN in the realm of a given account.
     *
     * @param tenantId the tenant ID
     * @param urn the thing URN
     * @return the {@link ThingResponse} instance for the retrieved thing or {@code empty} if the thing does not exist
     */
    Optional<ThingResponse> findByUrn(String tenantId, String urn);

    /**
     * Finds things matching a specified URN start in the realm of a given account.
     *
     * @param tenantId the tenant ID
     * @param urnStartsWith the first characters of the thing URN
     * @return all things whose {@code urn} starts with {@code urnStartsWith}
     */
    List<ThingResponse> findByUrnStartsWith(String tenantId, String urnStartsWith);

    /**
     * Finds a thing matching a specified URN in the realm of a given account.
     *
     * @param tenantId the tenant ID
     * @param id the thing's system-assigned ID
     * @return the {@link ThingResponse} instance for the retrieved thing or {@code empty} if the thing does not exist
     */
    Optional<ThingResponse> findById(String tenantId, String id);

    /**
     * Finds all things matching an input collection of URNs in the realm of a given account.
     *
     * @param tenantId the tenant ID
     * @param ids a collection of system-assigned IDs
     * @return a List of Optional<ThingResponse>, some of which may be empty.
     */
    List<Optional<ThingResponse>> findByIds(String tenantId, Collection<String> ids);

    List<ThingResponse> getThings();

    /**
     * Finds things matching specified query parameters in the realm of given account.
     *
     * @param tenantId the tenant ID
     * @param parameters the query parameters
     * @return all things matching the query parameters
     */
    List<ThingResponse> findByQueryParameters(String tenantId, Map<QueryParameterType, Object> parameters);

    /**
     * An Enum defining the query parameter type names when searching for Things in Objects.
     */
    public static enum QueryParameterType {
        /**
         * Flag indicating exact String matching.
         */
        EXACT("exact"),
        /**
         * Search for Things by urn.
         */
        URN_LIKE("urnLike"),
        /**
         * Actual field name.
         */
        URN_FIELD_NAME("urn"),
        /**
         * Search for Things by type.
         */
        TYPE("type"),
        /**
         * Actual field name.
         */
        MODIFIED_AFTER("modifiedAfter"),
        /**
         * Actual field name.
         */
        MODIFIED_AFTER_FIELD_NAME("lastModified");

        private String parameterName;

        private QueryParameterType(String name) {
            parameterName = name;
        }

        /**
         * The name of the parameter to be used in the query.
         *
         * @return the parameter type name as a String
         */
        public String typeName() {
            return parameterName;
        }
    }
}
