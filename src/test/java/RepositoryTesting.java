import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))

public class RepositoryTesting {

    @Test
    public void shouldFindPatientById() {
        Collection<Patient> patients = this.patientRepository.findByUserId(1);

        // Boris should be inside patients collection
        assertEquals(patients.size(), 1);

        // Verify that this is truly Boris
        assertEquals(patients.iterator().next().getFirstName(), "Boris");
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
        patient.setHealthCard("JDOE 1234 5678");
        patient.setDateOfBirth("1999-09-09");
        patient.setGender("Female");
        patient.setEmail("janedoeeee@gmail.com");

        //save new patient
        this.patientRepository.save(patient);

        //verify that new patient is added
        patients = this.patientRepository.findByEmail("janedoeeee@gmail.com");
        assertThat(patients.size()).isEqualTo(1);
    }

    @Test
    @Transactional
    public void shouldUpdatePatient() {
        Patient patient = this.patientRepository.findByUserId(1);
        string oldName = patients.getFirstName();
        string newName = oldName + 'X';

        patient.setFirstName(newName);
        this.patients.save(patient);

        //retrieve new name from database
        patient = this.patientRepository.findByUserId(1);
        assertThat(patient.getFirstName()).isEqualTo(newName);

    }

    @Test
    @Transactional
    public void shouldRemovePatient() {
        Collection<Patient> patients = this.patientRepository.findByUserId(1);

        // delete boris from database
        this.patientRepository.delete(patients.iterator().next());

        // Verify that Boris is deleted
        patients = this.patientRepository.findByUserId(1);
        assertTrue(patients.isEmpty());
    }
}
