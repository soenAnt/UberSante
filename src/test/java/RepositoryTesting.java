import application.model.Patient;
import application.repository.PatientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.Collection;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTesting {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void shouldFindPatientById() {
        Patient patient = this.patientRepository.findByUserId(1);

        // Boris should be inside patients collection
        assertNotNull(patient);

        // Verify that this is truly Boris
        assertEquals(patient.getFirstName(), "Boris");
    }

    @Test
    @Transactional
    public void shouldInsertPatientById() {

        //new patient
        Patient patient = new Patient();
        patient.setFirstName("Jane");
        patient.setLastName("Doe");
        patient.setAddress("444 Jayz D3S 4F3, Montreal QC.");
        patient.setPhoneNumber("1234567890");
        patient.setPassword("123456");
        patient.setHealthCardNumber("JDOE 1234 5678");
        patient.setBirthday(java.sql.Date.valueOf(LocalDate.parse("1999-09-09")));
        patient.setGender("Female");
        patient.setEmail("janedoeeee@gmail.com");

        //save new patient
        this.patientRepository.save(patient);

        //verify that new patient is added
        Collection<Patient> patients = this.patientRepository.findByEmail("janedoeeee@gmail.com");
        assertEquals(patients.size(),1);
    }

    @Test
    @Transactional
    public void shouldUpdatePatient() {
        Patient patient = this.patientRepository.findByUserId(1);
        String oldName = patient.getFirstName();
        String newName = oldName + 'X';

        patient.setFirstName(newName);
        this.patientRepository.save(patient);

        //retrieve new name from database
        patient = this.patientRepository.findByUserId(1);
        assertEquals(patient.getFirstName(), newName);

    }

    @Test
    @Transactional
    public void shouldRemovePatient() {

        Patient patient = this.patientRepository.findByUserId(1);

        // delete boris from database
        this.patientRepository.delete(patient);

        // Verify that Boris is deleted
        patient = this.patientRepository.findByUserId(1);
        assertNull(patient);
    }
}
