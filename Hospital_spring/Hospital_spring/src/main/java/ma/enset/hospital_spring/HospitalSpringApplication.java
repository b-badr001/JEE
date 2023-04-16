package ma.enset.hospital_spring;

import ma.enset.hospital_spring.entities.Patient;
import ma.enset.hospital_spring.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalSpringApplication {

    public static void main(String[] args) {

        SpringApplication.run(HospitalSpringApplication.class, args);
    }

    //@Bean
    CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            Stream.of("Mohamed", "Hassan", "Najat")
                    .forEach(name -> {
                        Patient patient=Patient.builder()
                                .name(name)
                                .dateofbirth(new Date())
                                .sick(true)
                                .score(115)
                                .build();
                        patientRepository.save(patient);
                    });
        };


    }
}
