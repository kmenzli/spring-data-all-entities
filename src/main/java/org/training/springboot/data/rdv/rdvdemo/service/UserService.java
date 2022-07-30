package org.training.springboot.data.rdv.rdvdemo.service;

import org.training.springboot.data.rdv.rdvdemo.model.Groupe;
import org.training.springboot.data.rdv.rdvdemo.model.Utilisateur;

public interface UserService {
    Utilisateur saveUtilisateur(Utilisateur utilisateur);
    Groupe saveGroupe(Groupe groupe);
    void addUtilisateurToGroupe(String utilisateurName, String groupeName);
    Utilisateur findByUserName (String userName);
    void deSossierFromGroupe(String utilisateurName, String groupeName);

}
