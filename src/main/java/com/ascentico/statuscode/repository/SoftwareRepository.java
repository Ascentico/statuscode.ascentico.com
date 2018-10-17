package com.ascentico.statuscode.repository;

import com.ascentico.statuscode.model.Software;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SoftwareRepository extends CrudRepository<Software, Integer> {

    public Software findDistinctBySoftwareIdEquals(int softwareId);

    @Query(value = "SELECT * FROM public.sc_software", nativeQuery = true)
    public List<Software> findAllSoftware();

}
