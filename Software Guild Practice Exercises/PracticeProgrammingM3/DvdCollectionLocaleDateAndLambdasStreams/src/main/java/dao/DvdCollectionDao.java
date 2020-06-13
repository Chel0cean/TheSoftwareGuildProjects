package dao;

import dto.Dvd;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public interface DvdCollectionDao {

    Dvd addDvd(String title, Dvd dvd)
            throws DvdCollectionDaoException;

    List<Dvd> getAllDvds()
            throws DvdCollectionDaoException;

    Dvd getDvd(String title)
            throws DvdCollectionDaoException;

    Dvd removeDvd(String title)
            throws DvdCollectionDaoException;
    
    //lambda methods start here

    List<Dvd> moviesInLastYear(int years)
            throws DvdCollectionDaoException;

    List<Dvd> moviesWithRating(String mPAA)
            throws DvdCollectionDaoException;

    List<Dvd> moviesWithDirector(String director)
            throws DvdCollectionDaoException;

    List<Dvd> moviesByStudio(String studio)
            throws DvdCollectionDaoException;

    double averageAge()
            throws DvdCollectionDaoException;

    Dvd newestMovie()
            throws DvdCollectionDaoException;

    Dvd oldestMovie()
            throws DvdCollectionDaoException;

    int averageNotes()
            throws DvdCollectionDaoException;

}
