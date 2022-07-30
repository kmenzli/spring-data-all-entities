package org.training.springboot.data.rdv.rdvdemo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.springboot.data.rdv.rdvdemo.model.Groupe;
import org.training.springboot.data.rdv.rdvdemo.model.Utilisateur;
import org.training.springboot.data.rdv.rdvdemo.repository.GroupeRepository;
import org.training.springboot.data.rdv.rdvdemo.repository.UserRepository;
import org.training.springboot.data.rdv.rdvdemo.service.GroupeService;
import org.training.springboot.data.rdv.rdvdemo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    GroupeRepository groupeRepository;

    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return userRepository.save(utilisateur);
    }

    @Override
    public Groupe saveGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    @Override
    public void addUtilisateurToGroupe(String utilisateurName, String groupeName) {
        Groupe g = groupeRepository.findByGroupeName(groupeName);
        Utilisateur u = userRepository.findByUserName(utilisateurName);
        u.addGroupe(g);
        userRepository.save(u);

    }

    @Override
    public Utilisateur findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void deSossierFromGroupe(String utilisateurName, String groupeName) {
        Groupe g = groupeRepository.findByGroupeName(groupeName);
        Utilisateur u = userRepository.findByUserName(utilisateurName);
        u.removeGroupe(g);
        userRepository.save(u);
    }
}
