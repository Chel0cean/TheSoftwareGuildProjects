package dao;

import dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author chelseamiller
 */
public class DvdCollectionDaoFileImpl implements DvdCollectionDao {

    public static final String COLLECTION_FILE = "collection.txt";
    public static final String DELIMITER = "::";

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

    private Dvd unmarshallDvd(String dvdAsText) {
        String[] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];
        Dvd dvdFromFile = new Dvd(title);
        dvdFromFile.setReleaseDate(dvdTokens[1]);
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

        dvdAsText += aDvd.getReleaseDate() + DELIMITER;

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
