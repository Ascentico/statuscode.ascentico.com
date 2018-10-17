package com.ascentico.statuscode.service;

import com.ascentico.statuscode.model.StatusCodeType;

import java.util.List;

/**
 * The StatusCodeService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2018-10-15
 */

public interface StatusCodeTypeService {

    public void saveStatusCodeType(StatusCodeType statusCodeType);
    public StatusCodeType findDistinctByStatusCodeTypeIdEquals(int statusCodeTypeId);
    public List<StatusCodeType> findAllStatusCodeTypes();

}
