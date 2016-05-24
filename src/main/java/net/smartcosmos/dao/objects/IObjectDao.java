package net.smartcosmos.dao.objects;

import net.smartcosmos.dto.objects.ObjectCreate;
import net.smartcosmos.dto.objects.ObjectResponse;
import net.smartcosmos.dto.objects.ObjectUpdate;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author voor
 */
public interface IObjectDao {

    ObjectResponse create(String accountUrn, ObjectCreate objectCreate) throws ConstraintViolationException;

    Optional<ObjectResponse> update(String accountUrn, ObjectUpdate objectUpdate) throws ConstraintViolationException;

    Optional<ObjectResponse> findByObjectUrn(String accountUrn, String objectUrn);

    List<ObjectResponse> findByObjectUrnStartsWith(String accountUrn, String objectUrn);

    Optional<ObjectResponse> findByUrn(String accountUrn, String urn);

    List<ObjectResponse> getObjects();

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
