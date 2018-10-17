package com.ascentico.statuscode.repository;

import com.ascentico.statuscode.model.StatusCodeType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatusCodeTypeRepository extends CrudRepository<StatusCodeType, Integer> {

    public StatusCodeType findDistinctByStatusCodeTypeIdEquals(int statusCodeTypeId);

    @Query(value = "SELECT * FROM public.sc_status_code_type", nativeQuery = true)
    public List<StatusCodeType> findAllStatusCodeTypes();

}
