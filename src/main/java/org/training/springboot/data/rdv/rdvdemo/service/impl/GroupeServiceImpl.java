package org.training.springboot.data.rdv.rdvdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.training.springboot.data.rdv.rdvdemo.repository.GroupeRepository;
import org.training.springboot.data.rdv.rdvdemo.service.GroupeService;

public class GroupeServiceImpl implements GroupeService {
    @Autowired
    GroupeRepository groupeRepository;

}
