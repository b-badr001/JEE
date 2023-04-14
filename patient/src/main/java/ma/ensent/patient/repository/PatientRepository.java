package ma.ensent.patient.repository;

import ma.ensent.patient.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    List<Patient> findByTypeContains(String mc);

    // 2 method to search for a patient with a word
    /* @Query("select p from Patient p where p.type like :x")
    List<Patient> search(@Param("x") String mc);*/

    @Modifying
    @Transactional
    @Query("update Patient p set  p.type=:t, p.malade=:m WHERE p.id=:id ")
    void updatePatient(@Param("id") Long id, @Param("t") String nom, @Param("m") boolean malade);

}
