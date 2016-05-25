package net.smartcosmos.dao.objects;

import net.smartcosmos.dto.objects.ObjectCreate;
import net.smartcosmos.dto.objects.ObjectResponse;
import net.smartcosmos.dto.objects.ObjectUpdate;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IObjectDao {

    /**
     * Creates an object in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param objectCreate the object to create
     * @return an {@link ObjectResponse} instance for the created object
     * @throws ConstraintViolationException if the {@link ObjectCreate} violates constraints enforced by the persistence service
     */
    ObjectResponse create(String accountUrn, ObjectCreate objectCreate) throws ConstraintViolationException;

    /**
     * Updates an object in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param objectUpdate the object to update
     * @return an {@link ObjectResponse} instance for the updated object
     * @throws ConstraintViolationException if the {@link ObjectUpdate} violates constraints enforced by the persistence service
     */
    Optional<ObjectResponse> update(String accountUrn, ObjectUpdate objectUpdate) throws ConstraintViolationException;

    /**
     * Finds an object matching a specified object URN in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param objectUrn the object URN
     * @return the {@link ObjectResponse} instance for the retrieved object or {@code empty} if the object does not exist
     */
    Optional<ObjectResponse> findByObjectUrn(String accountUrn, String objectUrn);

    /**
     * Finds objects matching a specified object URN start in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param objectUrnStartsWith the first characters of the object URN
     * @return all objects whose {@code objectUrn} starts with {@code objectUrnStartsWith}
     */
    List<ObjectResponse> findByObjectUrnStartsWith(String accountUrn, String objectUrnStartsWith);

    /**
     * Finds an object matching a specified URN in the realm of a given account.
     *
     * @param accountUrn the account URN
     * @param urn the object's system-assigned URN
     * @return the {@link ObjectResponse} instance for the retrieved object or {@code empty} if the object does not exist
     */
    Optional<ObjectResponse> findByUrn(String accountUrn, String urn);

    List<ObjectResponse> getObjects();

    /**
     * Finds objects matching specified query parameters in the realm of given account.
     *
     * @param accountUrn the account URN
     * @param parameters the query parameters
     * @return all objects matching the query parameters
     */
    List<ObjectResponse> findByQueryParameters(String accountUrn, Map<QueryParameterType, Object> parameters);

    /**
     * An Enum defining the query parameter type names when searching for Things in Objects.
     */
    public static enum QueryParameterType {
        /**
         * Search for Things with by urn.
         */
        OBJECT_URN_LIKE("objectUrnLike"),
        /**
         * Search for things by type.
         */
        TYPE("type"),
        /**
         * Search for things by name.
         */
        NAME_LIKE("nameLike"),
        /**
         * Search for things by moniker.
         */
        MONIKER_LIKE("monikerLike"),
        /**
         * Search for things by the timestamp it was last modified.
         */
        MODIFIED_AFTER("modifiedAfter");

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
