package dao;

import dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author chelseamiller
 */
public class DvdCollectionDaoFileImpl implements DvdCollectionDao {

    private final String COLLECTION_FILE;
    public static final String DELIMITER = "::";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public DvdCollectionDaoFileImpl() {
        COLLECTION_FILE = "collection.txt";
    }

    public DvdCollectionDaoFileImpl(String collectionTextFile) {
        COLLECTION_FILE = collectionTextFile;
    }

    private Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public Dvd addDvd(String title, Dvd dvd)
            throws DvdCollectionDaoException {
        loadCollection();
        Dvd newDvd = dvds.put(title, dvd);
        writeCollection();
        return newDvd;
    }

    @Override
    public List<Dvd> getAllDvds()
            throws DvdCollectionDaoException {
        loadCollection();
        return new ArrayList(dvds.values());
    }

    @Override
    public Dvd getDvd(String title)
            throws DvdCollectionDaoException {
        loadCollection();
        return dvds.get(title);
    }

    @Override
    public Dvd removeDvd(String title)
            throws DvdCollectionDaoException {
        loadCollection();
        Dvd removedDvd = dvds.remove(title);
        writeCollection();
        return removedDvd;
    }

    @Override
    public List<Dvd> moviesInLastYear(int years) throws DvdCollectionDaoException {
        List<Dvd> dvdList = getAllDvds();

        LocalDate now = LocalDate.now();

        LocalDate yearsBehind = now.minusYears(years);

        List<Dvd> dvdInYears = dvdList.stream().filter((d) -> d.getReleaseDate().isAfter(yearsBehind))
                .collect(Collectors.toList());

        return dvdInYears;
    }

    @Override
    public List<Dvd> moviesWithRating(String mPAA) throws DvdCollectionDaoException {
        List<Dvd> dvdList = getAllDvds();
        List<Dvd> dvdByRating = dvdList.stream().filter((d) -> d.getMpaaRating() == mPAA)
                .collect(Collectors.toList());
        return dvdByRating;
    }

    @Override
    public List<Dvd> moviesWithDirector(String director) throws DvdCollectionDaoException {
        List<Dvd> dvdList = getAllDvds();
        List<Dvd> dvdByDirector = dvdList.stream().filter((d) -> d.getDirectorName() == director)
                .collect(Collectors.toList());
        return dvdByDirector;
    }

    @Override
    public List<Dvd> moviesByStudio(String studio) throws DvdCollectionDaoException {
        List<Dvd> dvdList = getAllDvds();
        List<Dvd> dvdByStudio = dvdList.stream().filter((d) -> d.getStudio() == studio)
                .collect(Collectors.toList());
        return dvdByStudio;
    }

    @Override
    public double averageAge() throws DvdCollectionDaoException {
        List<Dvd> dvdList = getAllDvds();

        LocalDate now = LocalDate.now();

        double average = dvdList.stream().mapToInt((d) -> Period.between(d.getReleaseDate(), now).getDays()).average().getAsDouble();

        return average;
    }

    @Override
    public Dvd newestMovie() throws DvdCollectionDaoException {
        List<Dvd> dvdList = getAllDvds();
        LocalDate now = LocalDate.now();

        //days since the first movie ever which dates back to 1888
        LocalDate firstEverMovieRelease = LocalDate.of(1988, 10, 14);
        Period sample = Period.between(firstEverMovieRelease, now);
        Dvd isQualified(){
        
    }
        Dvd newestMovie = dvdList.stream().filter((d) -> (Period.between(d.getReleaseDate(), now)::compare).min());
        return newestMovie;
    }

    @Override
    public Dvd oldestMovie() throws DvdCollectionDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int averageNotes() throws DvdCollectionDaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Dvd unmarshallDvd(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];
        Dvd dvdFromFile = new Dvd(title);
        dvdFromFile.setReleaseDate(LocalDate.parse(dvdTokens[1]));
        dvdFromFile.setDirectorName(dvdTokens[2]);
        dvdFromFile.setMpaaRating(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserReview(dvdTokens[5]);
        return dvdFromFile;
    }

    private void loadCollection() throws DvdCollectionDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(COLLECTION_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdCollectionDaoException(
                    "-_- Could not load collection data into memory.", e);
        }
        String currentLine;
        Dvd currentDvd;

        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentDvd = unmarshallDvd(currentLine);
            dvds.put(currentDvd.getDvdTitle(), currentDvd);
        }
        scanner.close();
    }

    private String marshallDvd(Dvd aDvd) {
        String dvdAsText = aDvd.getDvdTitle() + DELIMITER;

        dvdAsText += (aDvd.getReleaseDate()).format(formatter) + DELIMITER;

        dvdAsText += aDvd.getDirectorName() + DELIMITER;

        dvdAsText += aDvd.getMpaaRating() + DELIMITER;

        dvdAsText += aDvd.getStudio() + DELIMITER;

        dvdAsText += aDvd.getUserReview();

        return dvdAsText;

    }

    private void writeCollection() throws DvdCollectionDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(COLLECTION_FILE));
        } catch (IOException e) {
            throw new DvdCollectionDaoException(
                    "Could not save Dvd data.", e);
        }

        String dvdAsText;
        List<Dvd> dvdList = new ArrayList(dvds.values());
        for (Dvd currentDvd : dvdList) {
            dvdAsText = marshallDvd(currentDvd);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }

}
