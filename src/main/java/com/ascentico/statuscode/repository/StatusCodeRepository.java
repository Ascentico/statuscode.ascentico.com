package com.ascentico.statuscode.repository;

import com.ascentico.statuscode.model.StatusCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * The StatusCodeRepository class
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2018-08-31
 */

public interface StatusCodeRepository extends CrudRepository<StatusCode, Integer> {

    public StatusCode findDistinctByStatusCodeIdEquals(int statusCodeId);

    @Query(value = "SELECT * FROM public.sc_status_code WHERE status_code=:statusCode ORDER BY status_code", nativeQuery = true)
    public List<StatusCode> findByStatusCodeEquals(@Param("statusCode") int statusCode);

    @Query(value = "SELECT * FROM public.sc_status_code ORDER BY status_code", nativeQuery = true)
    public List<StatusCode> findAllStatusCodes();

    @Query(value = "SELECT * FROM public.sc_status_code ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    public StatusCode findRandomStatusCode();

    @Query(value = "SELECT EXISTS(SELECT 1 FROM public.sc_status_code WHERE status_code=:statusCode)", nativeQuery = true)
    public boolean ifExists(@Param("statusCode") int statusCode);

    @Query(value = "SELECT * FROM public.sc_status_code WHERE CAST(status_code as TEXT) LIKE :requestedCategory%", nativeQuery = true)
    public List<StatusCode> findAllByStatusCodeStartsWith(@Param("requestedCategory") int requestedCategory);

    @Query(value = "SELECT public.sc_status_code.*\n" +
            "FROM public.sc_software\n" +
            "INNER JOIN public.sc_software_status_code\n" +
            "  ON public.sc_software_status_code.software_id = public.sc_software.software_id\n" +
            "INNER JOIN public.sc_status_code\n" +
            "  ON public.sc_status_code.status_code_id = public.sc_software_status_code.status_code_id\n" +
            "WHERE public.sc_software.short_description ILIKE :shortDescription%", nativeQuery = true)
    public List<StatusCode> findAllBySoftwareShortDescription(@Param("shortDescription") String shortDescription);

}
