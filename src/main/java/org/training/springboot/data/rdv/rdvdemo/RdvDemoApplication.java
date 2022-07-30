package org.training.springboot.data.rdv.rdvdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.training.springboot.data.rdv.rdvdemo.model.*;
import org.training.springboot.data.rdv.rdvdemo.model.heritage.joined.EmailNotification;
import org.training.springboot.data.rdv.rdvdemo.model.heritage.joined.Notification;
import org.training.springboot.data.rdv.rdvdemo.model.heritage.joined.SmsNotification;
import org.training.springboot.data.rdv.rdvdemo.model.heritage.table.Enseignant;
import org.training.springboot.data.rdv.rdvdemo.model.heritage.table.Personne;
import org.training.springboot.data.rdv.rdvdemo.model.heritage.table.Student;
import org.training.springboot.data.rdv.rdvdemo.model.heritage.two.Cat;
import org.training.springboot.data.rdv.rdvdemo.model.heritage.two.Dog;
import org.training.springboot.data.rdv.rdvdemo.repository.heritage.joined.NotificationRepository;
import org.training.springboot.data.rdv.rdvdemo.repository.heritage.single.PersonneRepository;
import org.training.springboot.data.rdv.rdvdemo.repository.heritage.two.AnimalRepository;
import org.training.springboot.data.rdv.rdvdemo.service.CoursService;
import org.training.springboot.data.rdv.rdvdemo.service.EtudiantService;
import org.training.springboot.data.rdv.rdvdemo.service.InscriptionService;
import org.training.springboot.data.rdv.rdvdemo.service.UserService;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class RdvDemoApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(RdvDemoApplication.class);

    @Autowired
    UserService userService;
    @Autowired
    InscriptionService inscriptionService;
    @Autowired
    EtudiantService etudiantService;
    @Autowired
    CoursService coursService;

    @Autowired
    PersonneRepository personneRepository;

    @Autowired
    AnimalRepository animalRepository;

    @Autowired
    NotificationRepository notificationRepository;

    public static void main(String[] args) {
        SpringApplication.run(RdvDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

//        manyToManyWithLinTable(inscriptionService, etudiantService, coursService);

        heritageSingleTable(personneRepository);
        heritagePerTable(animalRepository);
        heritageJoinedTable(notificationRepository);
    }

    public static void manyToManyWithLinTable(InscriptionService inscriptionService, EtudiantService etudiantService, CoursService coursService) {
        Etudiant e1 = new Etudiant("Menzli", "Khemais");
        Etudiant e2 = new Etudiant("Menzli", "Osswa");
        Etudiant e3 = new Etudiant("Menzli", "Youssef");
        etudiantService.createEtudiant(e1);
        etudiantService.createEtudiant(e2);
        etudiantService.createEtudiant(e3);


        Cours c1 = new Cours("Math", 30);
        Cours c2 = new Cours("Anglais", 20);

        coursService.createCours(c1);
        coursService.createCours(c2);

        Inscription i1 = new Inscription();
        i1.setCours(c1);
        i1.setEtudiant(e1);

        Inscription i2 = new Inscription();
        i2.setCours(c2);
        i2.setEtudiant(e2);

        inscriptionService.createInscription(i1);
        inscriptionService.createInscription(i2);

        List<Inscription> results = inscriptionService.findByCoursNom("Math");
        results.forEach(System.out::println);


    }

    public static void heritagePerTable(AnimalRepository animalRepository) {
        Cat c = new Cat();
        c.setRace("IRANIAN");
        c.setAge(12);
        c.setCouleur("RED");
        Dog d = new Dog();
        d.setAge(4);
        d.setCouleur("BLACK");
        d.setDanger("EXTREM");

        animalRepository.save(c);
        animalRepository.save(d);

    }
    public static void heritageJoinedTable(NotificationRepository notificationRepository) {
        SmsNotification s = new SmsNotification();
        s.setPhoneNumber("234456");
        s.setCreatedOn(new Date());
        s.setFirstName("Khemais ");
        s.setLastName("MENZLI");
        EmailNotification e = new EmailNotification();
        e.setEmailAddress("menzli.khemais@gmail.com");
        e.setCreatedOn(new Date());
        e.setFirstName("Khemais");
        e.setLastName("MENZLI");

        notificationRepository.save(s);
        notificationRepository.save(e);

    }
    public static void heritageSingleTable(PersonneRepository personneRepository) {
        Student s = new Student();
        s.setNote(20);
        s.setDateNaissance(new Date());
        s.setNom("MENZLI");

        Enseignant e = new Enseignant();
        e.setNom("HANNA");
        e.setMatiere("Math");
        e.setDateNaissance(new Date());

        personneRepository.save(e);

        personneRepository.save(s);


    }
    public static void manyToMany(UserService userService) {
        Utilisateur u1 = new Utilisateur("khemais", "123456");
        Utilisateur u2 = new Utilisateur("Youssef", "123456");
        Utilisateur u3 = new Utilisateur("Abdo", "123456");
        Utilisateur u4 = new Utilisateur("Osswa", "123456");
        Utilisateur u5 = new Utilisateur("Nab", "123456");

        Groupe g1 = new Groupe("Famille");
        Groupe g2 = new Groupe("Amis");
        u1.addGroupe(g1);
        u5.addGroupe(g2);
        userService.saveUtilisateur(u1);
        userService.saveUtilisateur(u2);
        userService.saveUtilisateur(u3);
        userService.saveUtilisateur(u4);
        userService.saveUtilisateur(u5);

        userService.deSossierFromGroupe("Nab", "Amis");
    }
}
