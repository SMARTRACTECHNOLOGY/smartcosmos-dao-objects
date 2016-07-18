package net.smartcosmos.dao.things;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.validation.ConstraintViolationException;

import net.smartcosmos.dto.things.Page;
import net.smartcosmos.dto.things.ThingCreate;
import net.smartcosmos.dto.things.ThingResponse;
import net.smartcosmos.dto.things.ThingUpdate;

public interface ThingDao {

    // region Create

    /**
     * Creates a thing in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param thingCreate the thing to create
     * @return an {@link ThingResponse} instance for the created thing or {@code empty} if the thing already exists
     * @throws ConstraintViolationException if the {@link ThingCreate} violates constraints enforced by the persistence service
     */
    Optional<ThingResponse> create(String tenantUrn, ThingCreate thingCreate) throws ConstraintViolationException;

    // endregion

    // region Update

    /**
     * Updates a thing identified by its type and URN in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param type the thing TYPE
     * @param urn the thing URN
     * @param updateThing the thing to update
     * @return an {@link ThingResponse} instance for the updated thing or {@code empty} if the thing does not exist
     * @throws ConstraintViolationException if the {@link ThingUpdate} violates constraints enforced by the persistence service
     */
    Optional<ThingResponse> update(String tenantUrn, String type, String urn, ThingUpdate updateThing) throws ConstraintViolationException;

    // endregion

    // region Find By Type

    /**
     * Finds things of TYPE in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param type the thing TYPE
     * @return all things whose {@code urn} starts with {@code urnStartsWith}
     */
    List<ThingResponse> findByType(
        String tenantUrn,
        String type);

    /**
     * Finds things of TYPE in the realm of a given tenant (sorted).
     *
     * @param tenantUrn the tenant URN
     * @param type the thing TYPE
     * @param sortOrder order to sort the result, can be {@code ASC} or {@code DESC}
     * @param sortBy name of the field to sort by
     * @return all things whose {@code urn} starts with {@code urnStartsWith}
     */
    List<ThingResponse> findByType(
        String tenantUrn,
        String type,
        SortOrder sortOrder,
        String sortBy);

    /**
     * Finds things of TYPE in the realm of a given tenant (paged).
     *
     * @param tenantUrn the tenant URN
     * @param type the thing TYPE
     * @param page the number of the results page
     * @param size the size of a results page
     * @return all things whose {@code urn} starts with {@code urnStartsWith}
     */
    Page<ThingResponse> findByType(
        String tenantUrn,
        String type,
        Integer page,
        Integer size);

    /**
     * Finds things of TYPE in the realm of a given tenant (paged and sorted).
     *
     * @param tenantUrn the tenant URN
     * @param type the thing TYPE
     * @param page the number of the results page
     * @param size the size of a results page
     * @param sortOrder order to sort the result, can be {@code ASC} or {@code DESC}
     * @param sortBy name of the field to sort by
     * @return all things whose {@code urn} starts with {@code urnStartsWith}
     */
    Page<ThingResponse> findByType(
        String tenantUrn,
        String type,
        Integer page,
        Integer size,
        SortOrder sortOrder,
        String sortBy);

    // endregion

    // region Find By Type and URN

    /**
     * Finds a thing of TYPE matching a specified URN in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param type the thing TYPE
     * @param urn the thing URN
     * @return the {@link ThingResponse} instance for the retrieved thing or {@code empty} if the thing does not exist
     */
    Optional<ThingResponse> findByTypeAndUrn(String tenantUrn, String type, String urn);

    // endregion

    // region Find By Type and URN startsWith

    /**
     * Finds things of TYPE matching a specified URN start in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param type the thing TYPE
     * @param urnStartsWith the first characters of the thing URN
     * @return all things whose {@code urn} starts with {@code urnStartsWith}
     */
    List<ThingResponse> findByTypeAndUrnStartsWith(
        String tenantUrn,
        String type,
        String urnStartsWith);

    /**
     * Finds things of TYPE matching a specified URN start in the realm of a given tenant (sorted).
     *
     * @param tenantUrn the tenant URN
     * @param type the thing TYPE
     * @param urnStartsWith the first characters of the thing URN
     * @param sortOrder order to sort the result, can be {@code ASC} or {@code DESC}
     * @param sortBy name of the field to sort by
     * @return all things whose {@code urn} starts with {@code urnStartsWith}
     */
    List<ThingResponse> findByTypeAndUrnStartsWith(
        String tenantUrn,
        String type,
        String urnStartsWith,
        SortOrder sortOrder,
        String sortBy);

    /**
     * Finds things of TYPE matching a specified URN start in the realm of a given tenant (paged).
     *
     * @param tenantUrn the tenant URN
     * @param type the thing TYPE
     * @param urnStartsWith the first characters of the thing URN
     * @param page the number of the results page
     * @param size the size of a results page
     * @return all things whose {@code urn} starts with {@code urnStartsWith}
     */
    Page<ThingResponse> findByTypeAndUrnStartsWith(
        String tenantUrn,
        String type,
        String urnStartsWith,
        Integer page,
        Integer size);

    /**
     * Finds things of TYPE matching a specified URN start in the realm of a given tenant (paged and sorted).
     *
     * @param tenantUrn the tenant URN
     * @param type the thing TYPE
     * @param urnStartsWith the first characters of the thing URN
     * @param page the number of the results page
     * @param size the size of a results page
     * @param sortOrder order to sort the result, can be {@code ASC} or {@code DESC}
     * @param sortBy name of the field to sort by
     * @return all things whose {@code urn} starts with {@code urnStartsWith}
     */
    Page<ThingResponse> findByTypeAndUrnStartsWith(
        String tenantUrn,
        String type,
        String urnStartsWith,
        Integer page,
        Integer size,
        SortOrder sortOrder,
        String sortBy);

    // endregion

    // region Find By URNs

    /**
     * Finds all things matching an input collection of URNs in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @param type the thing TYPE
     * @param urns a collection of system-assigned URNs
     * @return a list containing all found {@link ThingResponse} instances.
     */
    List<ThingResponse> findByTypeAndUrns(String tenantUrn, String type, Collection<String> urns);

    /**
     * Finds all things matching an input collection of URNs in the realm of a given tenant (sorted).
     *
     * @param tenantUrn the tenant URN
     * @param type the thing TYPE
     * @param urns a collection of system-assigned URNs
     * @param sortOrder order to sort the result, can be {@code ASC} or {@code DESC}
     * @param sortBy name of the field to sort by
     * @return a list containing all found {@link ThingResponse} instances.
     */
    List<ThingResponse> findByTypeAndUrns(String tenantUrn, String type, Collection<String> urns, SortOrder sortOrder, String sortBy);

    // endregion

    // region Find All

    /**
     * Return all things in the realm of a given tenant.
     *
     * @param tenantUrn the tenant URN
     * @return the list of {@link ThingResponse} instances in the realm
     */
    List<ThingResponse> findAll(String tenantUrn);

    /**
     * Return all things in the realm of a given tenant (sorted).
     *
     * @param tenantUrn the tenant URN
     * @param sortOrder order to sort the result, can be {@code ASC} or {@code DESC}
     * @param sortBy name of the field to sort by
     * @return the list of {@link ThingResponse} instances in the realm
     */
    List<ThingResponse> findAll(String tenantUrn, SortOrder sortOrder, String sortBy);

    /**
     * Return all things in the realm of a given tenant (paged).
     *
     * @param tenantUrn the tenant URN
     * @param page the number of the results page
     * @param size the size of a results page
     * @return a page of {@link ThingResponse} instances in the realm
     */
    Page<ThingResponse> findAll(String tenantUrn, Integer page, Integer size);

    /**
     * Return all things in the realm of a given tenant (paged and sorted).
     *
     * @param tenantUrn the tenant URN
     * @param page the number of the results page
     * @param size the size of a results page
     * @param sortOrder order to sort the result, can be {@code ASC} or {@code DESC}
     * @param sortBy name of the field to sort by
     * @return a page of {@link ThingResponse} instances in the realm
     */
    Page<ThingResponse> findAll(String tenantUrn, Integer page, Integer size, SortOrder sortOrder, String sortBy);

    // endregion

    // region Delete

    /**
     * Deletes a thing matching a specified type and URN in the realm of a given tenant.
     *
     * @param tenantUrn  the tenant URN
     * @param type the thing TYPE
     * @param urn the thing URN
     * @return the list of deleted {@link ThingResponse} instances
     */
    List<ThingResponse> delete(String tenantUrn, String type, String urn);

    // endregion
}
