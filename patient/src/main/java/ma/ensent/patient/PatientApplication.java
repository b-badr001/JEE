package ma.ensent.patient;

import ma.ensent.patient.entities.Patient;
import ma.ensent.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PatientApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;
    public static void main(String[] args) {

        SpringApplication.run(PatientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /* ************************ Ajouter des patients  *****************/
        patientRepository.save(new Patient(null,"ALAOUI",new Date("22/05/1994"),false,80));
        patientRepository.save(new Patient(null,"IDRISSI",new Date(),true,70));
        patientRepository.save(new Patient(null,"FATHI",new Date(),false,60));
        patientRepository.save(new Patient(null,"ATMANI",new Date(),true,80));

        /* ************************ Consulter tous les patients **********/
        System.out.println("Liste des patients");
        List<Patient> patients = patientRepository.findAll();
        patients.forEach(p->{
            System.out.println(p.toString());
        });

        /* ************************ Consulter un patient *****************/
        Patient patient2 = patientRepository.findById(3L).get();
        System.out.println("**********************************");
        System.out.println("Le patient que vous cherchez est:");
        System.out.println(patient2);
        System.out.println("************************************");

        /* ************************ Cherchez un patient *****************/
        System.out.println("Chercher des patients par mot cle");
        List<Patient> patients1= patientRepository.findByTypeContains("M");
        patients1.forEach(p->{
            System.out.println(p.toString());
        });
        System.out.println("**********************************");

        /* ************************ update un patient *****************/

        System.out.println("*********** update un patient ***********************");
        patientRepository.updatePatient(Long.valueOf(1),"regragui",false);
        System.out.println("**********************************");

        /* ************************ supprimer un patient *****************/

        System.out.println("************ supprimer un patient *************");
        patientRepository.deleteById(Long.valueOf(2));
        System.out.println("*************************");

    }
}
