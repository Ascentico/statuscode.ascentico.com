package com.ascentico.statuscode.service;

import com.ascentico.statuscode.model.StatusCode;
import com.ascentico.statuscode.repository.StatusCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * The StatusCodeServiceImpl class implements the
 * StatusCodeService interface.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2018-08-31
 */

@Service("statusCodeService")
@Transactional
public class StatusCodeServiceImpl implements StatusCodeService {

    @Autowired
    StatusCodeRepository statusCodeRepository;

    @Override
    public void saveStatusCode(StatusCode statusCode) {
        statusCodeRepository.save(statusCode);
    }

    @Override
    public StatusCode findDistinctByStatusCodeEquals(int statusCode) {
        return statusCodeRepository.findDistinctByStatusCodeEquals(statusCode);
    }

    @Override
    public List<StatusCode> findAllByCategoryMember(String requestedCategory) {

        List<StatusCode> statusCodeList;

        int category = Integer.parseInt(requestedCategory.substring(0, 1));
        int[] validCategories = {100,200,300,400,500};
        if (IntStream.of(validCategories).anyMatch(x -> x == (category*100))) {
            statusCodeList = statusCodeRepository.findAllByStatusCodeStartsWith(category);
        } else {
            statusCodeList = new ArrayList<>();
        }

        return statusCodeList;
    }

}
