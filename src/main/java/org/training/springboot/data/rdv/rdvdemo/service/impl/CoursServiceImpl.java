package org.training.springboot.data.rdv.rdvdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.springboot.data.rdv.rdvdemo.model.Cours;
import org.training.springboot.data.rdv.rdvdemo.repository.CoursRepository;
import org.training.springboot.data.rdv.rdvdemo.service.CoursService;

@Transactional
@Service
public class CoursServiceImpl implements CoursService {

    @Autowired
    CoursRepository coursRepository;

    @Override
    public Cours createCours(Cours cours) {
        return coursRepository.save(cours);
    }
}
