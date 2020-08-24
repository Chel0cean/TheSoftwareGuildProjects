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
}
