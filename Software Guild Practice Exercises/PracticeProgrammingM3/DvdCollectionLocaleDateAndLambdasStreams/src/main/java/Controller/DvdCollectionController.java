package Controller;

import dao.DvdCollectionDao;
import dao.DvdCollectionDaoException;
import dto.Dvd;
import java.time.LocalDate;
import java.util.List;
import ui.DvdCollectionView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

/**
 *
 * @author chelseamiller
 */
public class DvdCollectionController {

//is it better form to make these fields final, as my IDE suggests? 
    private final DvdCollectionView view;
    private final DvdCollectionDao dao;

    public DvdCollectionController(DvdCollectionDao dao, DvdCollectionView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        try {
            while (keepGoing) {

                int menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        createDvd();
                        break;
                    case 3:
                        viewDvd();
                        break;
                    case 4:
                        editDvd();
                        break;
                    case 5:
                        removeDvd();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DvdCollectionDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdCollectionDaoException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.addDvd(newDvd.getDvdTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }

    private int getEditMenuSelection() {
        return view.printEditMenuAndGetSelection();
    }

    private void listDvds() throws DvdCollectionDaoException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void editDvd() throws DvdCollectionDaoException {
        boolean editingDvd = true;
        view.displayEditDvdBanner();
        String editedDvd = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(editedDvd);
        if (dvd == null) {
            editingDvd = false;
        } 
            view.displayDvd(dvd);
        try {
            while (editingDvd) {
                int editMenuSelection = getEditMenuSelection();
                switch (editMenuSelection) {
                    case 1:
                        updateReleaseDate(editedDvd);
                        editingDvd = view.promptToContinueEditing();
                        break;
                    case 2:
                        updateDirectorName(editedDvd);
                        editingDvd = view.promptToContinueEditing();
                        break;
                    case 3:
                        updateStudio(editedDvd);
                        editingDvd = view.promptToContinueEditing();
                        break;
                    case 4:
                        updateMpaaRating(editedDvd);
                        editingDvd = view.promptToContinueEditing();
                        break;
                    case 5:
                        updateUserReview(editedDvd);
                        editingDvd = view.promptToContinueEditing();
                        break;
                    case 6:
                        editingDvd = false;
                        break;

                    default:
                        unknownCommand();

                }

            }

        } catch (DvdCollectionDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }

    }

    public void updateReleaseDate(String editedDvd) throws DvdCollectionDaoException {
        LocalDate releaseDate = view.promptReleaseDateUpdate();
        Dvd dvd = dao.getDvd(editedDvd);
        dvd.setReleaseDate(releaseDate);
        dao.addDvd(dvd.getDvdTitle(), dvd);
        view.displayReleaseDateUpdatedBanner(dvd.getDvdTitle());

    }

    public void updateDirectorName(String editedDvd) throws DvdCollectionDaoException {
        String directorName = view.promptDirectorNameUpdate();
        Dvd dvd = dao.getDvd(editedDvd);
        dvd.setDirectorName(directorName);
        dao.addDvd(dvd.getDvdTitle(), dvd);
        view.displayDirectorNameUpdatedBanner(dvd.getDvdTitle());

    }

    public void updateStudio(String editedDvd) throws DvdCollectionDaoException {
        String studioName = view.promptStudioUpdate();
        Dvd dvd = dao.getDvd(editedDvd);
        dvd.setStudio(studioName);
        dao.addDvd(dvd.getDvdTitle(), dvd);
        view.displayStudioUpdatedBanner(dvd.getDvdTitle());

    }

    public void updateMpaaRating(String editedDvd) throws DvdCollectionDaoException {
        String mpaaRating = view.promptMpaaRatingUpdate();
        Dvd dvd = dao.getDvd(editedDvd);
        dvd.setMpaaRating(mpaaRating);
        dao.addDvd(dvd.getDvdTitle(), dvd);
        view.displayMpaaRatingUpdatedBanner(dvd.getDvdTitle());

    }

    public void updateUserReview(String editedDvd) throws DvdCollectionDaoException {
        String userReview = view.promptUserReviewUpdate();
        Dvd dvd = dao.getDvd(editedDvd);
        dvd.setUserReview(userReview);
        dao.addDvd(dvd.getDvdTitle(), dvd);
        view.displayUserReviewUpdatedBanner(dvd.getDvdTitle());

    }

    private void viewDvd() throws DvdCollectionDaoException {
        view.displayDisplayDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdCollectionDaoException {
        view.displayRemoveDvdBanner();
        String title = view.getDvdTitleChoice();
        Dvd removedDvd = dao.removeDvd(title);
        view.displayRemoveResult(removedDvd);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}
