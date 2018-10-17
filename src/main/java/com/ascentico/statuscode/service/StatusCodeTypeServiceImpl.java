package com.ascentico.statuscode.service;

import com.ascentico.statuscode.model.StatusCodeType;
import com.ascentico.statuscode.repository.StatusCodeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The StatusCodeTypeServiceImpl class implements the
 * StatusCodeTypeService interface.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2018-10-15
 */

@Service("statusCodeTypeService")
@Transactional
public class StatusCodeTypeServiceImpl implements StatusCodeTypeService {

    @Autowired
    StatusCodeTypeRepository statusCodeTypeRepository;

    @Override
    public void saveStatusCodeType(StatusCodeType statusCodeType) {
        statusCodeTypeRepository.save(statusCodeType);
    }

    @Override
    public StatusCodeType findDistinctByStatusCodeTypeIdEquals(int statusCodeId) {
        return statusCodeTypeRepository.findDistinctByStatusCodeTypeIdEquals(statusCodeId);
    }

    @Override
    public List<StatusCodeType> findAllStatusCodeTypes() {
        return statusCodeTypeRepository.findAllStatusCodeTypes();
    }


}
