import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HospitalSystemTest {

    @Test
    public void testRegisterPatient() {
        HospitalSystem hs = new HospitalSystem();
        Patient p = new Patient("P001", "John", "Doe", "Inpatient");
        hs.registerPatient(p);
        assertNotNull(hs.searchPatient("P001"));
    }

    @Test
    public void testAllocateAndReleaseBed() {
        HospitalSystem hs = new HospitalSystem();
        Patient p = new Patient("P002", "Jane", "Smith", "Inpatient");
        hs.allocateBed(p);
        hs.releaseBed("P002");
        assertNull(hs.searchPatient("P999")); // non-existent
    }

    @Test
    public void testUpdatePatient() {
        HospitalSystem hs = new HospitalSystem();
        Patient p = new Patient("P003", "Mike", "Brown", "Outpatient");
        hs.registerPatient(p);
        hs.updatePatient("P003", "White");
        assertEquals("White", hs.searchPatient("P003").getLastName());
    }
}


