package com.ascentico.statuscode.service;

import com.ascentico.statuscode.model.Software;
import com.ascentico.statuscode.repository.SoftwareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * The SoftwareServiceImpl class implements the
 * SoftwareService interface.
 *
 * @author  Andy McCall
 * @version 0.1
 * @since   2018-10-16
 */

@Service("softwareService")
@Transactional
public class SoftwareServiceImpl implements SoftwareService {

    @Autowired
    SoftwareRepository softwareRepository;

    @Override
    public void saveSoftware(Software software) {
        softwareRepository.save(software);
    }

    @Override
    public Software findDistinctBySoftwareIdEquals(int softwareId) {
        return softwareRepository.findDistinctBySoftwareIdEquals(softwareId);
    }

    @Override
    public List<Software> findAllSoftware() {
        return softwareRepository.findAllSoftware();
    }

}
