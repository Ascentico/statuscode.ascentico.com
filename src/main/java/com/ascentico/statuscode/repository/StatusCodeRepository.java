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

    public StatusCode findDistinctByStatusCodeEquals(int statusCode);

    @Query(value = "SELECT * FROM public.sc_status_code WHERE CAST(status_code as TEXT) LIKE :requestedCategory%", nativeQuery = true)
    public List<StatusCode> findAllByStatusCodeStartsWith(@Param("requestedCategory") int requestedCategory);

}
