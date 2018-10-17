package com.ascentico.statuscode.service;

import com.ascentico.statuscode.model.Software;

import java.util.List;

public interface SoftwareService {

    public void saveSoftware(Software software);
    public Software findDistinctBySoftwareIdEquals(int softwareId);
    public List<Software> findAllSoftware();

}
