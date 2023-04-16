package ma.enset.hospital;

import ma.enset.hospital.entities.*;
import ma.enset.hospital.repository.ConsultationRepository;
import ma.enset.hospital.repository.MedecinRepository;
import ma.enset.hospital.repository.PatientRepository;
import ma.enset.hospital.repository.RendezVousRepository;
import ma.enset.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {

        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository,
                            MedecinRepository medecinRepository,
                            RendezVousRepository rendezVousRepository){
        return args -> {

            Stream.of("Aymane","Ayoub","Hamza")
                    .forEach(name->{
                        Medecin medecin = new Medecin();
                        medecin.setNom(name);
                        medecin.setEmail(name+"@gmail.com");
                        medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentiste");
                        hospitalService.saveMedecin(medecin);
                    });
            Stream.of("Mohamed","Hassan","Najat")
                    .forEach(name->{
                        Patient patient = new Patient();
                        patient.setNom(name);
                        patient.setDatenaissance(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });

            Patient patient = patientRepository.findById(1L).orElse(null);
            Patient patient1 = patientRepository.findByNom("Mohamed");

            Medecin medecin = medecinRepository.findByNom("Ayoub");

            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            hospitalService.saveRendezVous(rendezVous);

            RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consulation .....");
            hospitalService.saveConsultation(consultation);



        };
    }

}
