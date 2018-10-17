package com.ascentico.statuscode.service;

import com.ascentico.statuscode.model.StatusCode;

import java.util.List;

/**
 * The StatusCodeService interface
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2018-08-31
 */

public interface StatusCodeService {

    public void saveStatusCode(StatusCode statusCode);
    public StatusCode findDistinctByStatusCodeIdEquals(int statusCodeId);
    public List<StatusCode> findByStatusCodeEquals(int statusCode);
    public List<StatusCode> findAllStatusCodes();
    public StatusCode findRandomStatusCode();
    public boolean ifExists(int statusCode);
    public List<StatusCode> findAllByCategoryMember(String requestedCategory);

}
