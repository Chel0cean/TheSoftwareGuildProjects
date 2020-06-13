package dao;

import dto.Dvd;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author chelseamiller
 */
public class DvdCollectionDaoFileImplTest {

    DvdCollectionDao testDao;

    public DvdCollectionDaoFileImplTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws Exception {
        String testFile = "testcollection.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new DvdCollectionDaoFileImpl(testFile);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetDVD() throws Exception {
        // Create our method test inputs
        String title = "Ghostbusters";
        Dvd dvd = new Dvd(title);
        dvd.setReleaseDate(LocalDate.parse("1984-06-07"));
        dvd.setDirectorName("Ivan Reitman");
        dvd.setMpaaRating("PG");
        dvd.setStudio("Universal Studios");
        dvd.setUserReview("Okay movie");

        //  Add the dvd to the DAO
        testDao.addDvd(title, dvd);
        // Get the dvd from the DAO
        Dvd retrievedDvd = testDao.getDvd(title);

        // Check the data is equal
        assertEquals(dvd.getDvdTitle(),
                retrievedDvd.getDvdTitle(),
                "Checking dvd title.");
        assertEquals(dvd.getReleaseDate(),
                retrievedDvd.getReleaseDate(),
                "Checking dvd delease date.");
        assertEquals(dvd.getDirectorName(),
                retrievedDvd.getDirectorName(),
                "Checking dvd director's name.");
        assertEquals(dvd.getMpaaRating(),
                retrievedDvd.getMpaaRating(),
                "Checking dvd rating.");
        assertEquals(dvd.getStudio(),
                retrievedDvd.getStudio(),
                "Checking dvd studio.");
        assertEquals(dvd.getUserReview(),
                retrievedDvd.getUserReview(),
                "Checking dvd user review.");
    }

    @Test
    public void testAddGetAllDvds() throws Exception {
        // Create our first dvd
        Dvd firstDvd = new Dvd("fictional monster");
        firstDvd.setReleaseDate(LocalDate.parse("2052-05-12"));
        firstDvd.setDirectorName("gorey");
        firstDvd.setMpaaRating("R");
        firstDvd.setStudio("pukemaster production");
        firstDvd.setUserReview("best movie ever");

        // Create our second dvd
        Dvd secondDvd = new Dvd("trampoline pizza");
        secondDvd.setReleaseDate(LocalDate.parse("1834-06-19"));
        secondDvd.setDirectorName("cabbage-head");
        secondDvd.setMpaaRating("unrated");
        secondDvd.setStudio("gobbitygook studios");
        secondDvd.setUserReview("excellent cinematography");

        // Add both our Dvds to the DAO
        testDao.addDvd(firstDvd.getDvdTitle(), firstDvd);
        testDao.addDvd(secondDvd.getDvdTitle(), secondDvd);

        // Retrieve the list of all students within the DAO
        List<Dvd> allDvds = testDao.getAllDvds();

        // First check the general contents of the list
        assertNotNull(allDvds, "The list of dvds must not null");
        assertEquals(2, allDvds.size(), "List of dvds should have 2 dvds.");

        // Then the specifics
        assertTrue(testDao.getAllDvds().contains(firstDvd),
                "The list of Dvds should include fictional monster.");
        assertTrue(testDao.getAllDvds().contains(secondDvd),
                "The list of Dvds should include trampoline pizza.");

    }

    @Test
    public void testRemoveDvd() throws Exception {
        // Create our first dvd
        Dvd firstDvd = new Dvd("fictional monster");
        firstDvd.setReleaseDate(LocalDate.parse("2052-05-12"));
        firstDvd.setDirectorName("gorey");
        firstDvd.setMpaaRating("R");
        firstDvd.setStudio("pukemaster production");
        firstDvd.setUserReview("best movie ever");

        // Create our second student
        Dvd secondDvd = new Dvd("trampoline pizza");
        secondDvd.setReleaseDate(LocalDate.parse("1834-06-19"));
        secondDvd.setDirectorName("cabbage-head");
        secondDvd.setMpaaRating("unrated");
        secondDvd.setStudio("gobbitygook studios");
        secondDvd.setUserReview("excellent cinematography");

        // Add both to the DAO
        testDao.addDvd(firstDvd.getDvdTitle(), firstDvd);
        testDao.addDvd(secondDvd.getDvdTitle(), secondDvd);

        // remove the first Dvd - fictional monster
        Dvd removedDvd = testDao.removeDvd(firstDvd.getDvdTitle());

        // Check that the correct object was removed.
        assertEquals(removedDvd, firstDvd, "The removed dvd should be fictional monster.");

        // Get all the Dvds
        List<Dvd> allDvds = testDao.getAllDvds();

        // First check the general contents of the list
        assertNotNull(allDvds, "All dvds list should be not null.");
        assertEquals(1, allDvds.size(), "All dvds should only have 1 student.");

        // Then the specifics
        assertFalse(allDvds.contains(firstDvd), "All Dvds should NOT include fictional monster.");
        assertTrue(allDvds.contains(secondDvd), "All Dvds should include trampoline pizza.");

        // Remove the second dvd
        removedDvd = testDao.removeDvd(secondDvd.getDvdTitle());
        // Check that the correct object was removed.
        assertEquals(removedDvd, secondDvd, "The removed student should be trampoline pizza..");

        // retrieve all of the dvds again, and check the list.
        allDvds = testDao.getAllDvds();

        // Check the contents of the list - it should be empty
        assertTrue(allDvds.isEmpty(), "The retrieved list of Dvds should be empty.");

        // Try to 'get' both Dvds by their old title - they should be null!
        Dvd retrievedDvd = testDao.getDvd(firstDvd.getDvdTitle());
        assertNull(retrievedDvd, "fictional monster was removed, should be null.");

        retrievedDvd = testDao.getDvd(secondDvd.getDvdTitle());
        assertNull(retrievedDvd, "trampoline pizza was removed, should be null.");

    }

}
