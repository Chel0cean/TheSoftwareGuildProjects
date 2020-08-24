package ui;

import dto.Dvd;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public class DvdCollectionView {

    private UserIO io;

    public DvdCollectionView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Dvds");
        io.print("2. Create New Dvd");
        io.print("3. View a Dvd");
        io.print("4. Edit a Dvd");
        io.print("5. Remove a Dvd");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public int printEditMenuAndGetSelection() {
        io.print("Which of the following fields would you like to update? (answer numerically)");
        io.print("1.Release Date: ");
        io.print("2.Director: ");
        io.print("3.Production Studio: ");
        io.print("4.MPAA Rating: ");
        io.print("5.User Review: ");
        io.print("6. Return to Main Menu");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    public boolean promptToContinueEditing() {
        String answer = io.readString("Continue editing this dvd? (y/n)");
        return answer.equals("y");
    }

    public Dvd getNewDvdInfo() {

        String title = io.readString("Please enter the title of the Dvd");
        String releaseDate = io.readString("Please enter the Dvd's release date");
        String directorName = io.readString("Please enter the director's name");
        String mpaaRating = io.readString("Please enter the Dvd's MPAA rating");
        String studio = io.readString("Please enter the studio");
        String userReview = io.readString("Please enter any additional reviews or notes");
        Dvd currentDvd = new Dvd(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setDirectorName(directorName);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setStudio(studio);
        currentDvd.setUserReview(userReview);
        return currentDvd;
    }

    public void displayCreateDvdBanner() {

        io.print("=== Create Dvd ===");
    }

    public void displayCreateSuccessBanner() {

        io.readString(
                "Dvd successfully created.  Please hit enter to continue");
    }

    public void displayDvdList(List<Dvd> DvdList) {

        for (Dvd currentDvd : DvdList) {
            String DvdInfo = String.format("*%s : ~~Released~~ %s ~~Directed by~~ %s ~~Produced by~~ %s ~~Rated~~ %s ~~Additional comments/reviews~~ %s",
                    currentDvd.getDvdTitle(),
                    currentDvd.getReleaseDate(),
                    currentDvd.getDirectorName(),
                    currentDvd.getStudio(),
                    currentDvd.getMpaaRating(),
                    currentDvd.getUserReview());
            io.print(DvdInfo);
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDisplayAllBanner() {

        io.print("=== Display All Dvds ===");
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display Dvd ===");
    }

    public void displayEditDvdBanner() {

        io.print("=== Edit Dvd ===");
    }

    public String getDvdTitleChoice() {
        return io.readString("Please enter the Dvd's title."); 
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print("Title: " + dvd.getDvdTitle());
            io.print("Release Date: " + dvd.getReleaseDate());
            io.print("Directed by: " + dvd.getDirectorName());
            io.print("Produced by: " + dvd.getStudio() + " Studios");
            io.print("Rated: " + dvd.getMpaaRating());
            io.print("Additional notes: " + dvd.getUserReview());
            io.print("");
        } else {
            io.print("No such Dvd.");  
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove Dvd ===");
    }

    public void displayRemoveResult(Dvd dvdRecord) {
        if (dvdRecord != null) {
            io.print("Dvd successfully removed.");
        } else {
            io.print("No such Dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public String promptReleaseDateUpdate() {
        String update = io.readString("Please enter the Dvd's release date:");
        return update;
    }

    public String promptDirectorNameUpdate() {
        String update = io.readString("Please enter the director's name:");
        return update;
    }

    public String promptStudioUpdate() {
        String update = io.readString("Please enter the production studio:");
        return update;
    }

    public String promptMpaaRatingUpdate() {
        String update = io.readString("Please enter the Mpaa rating:");
        return update;
    }

    public String promptUserReviewUpdate() {
        String update = io.readString("Please enter review:");
        return update;
    }

    public void displayReleaseDateUpdatedBanner(String title) {
        io.print(title + "'s release date has been updated.");
    }

    public void displayDirectorNameUpdatedBanner(String title) {
        io.print(title + "'s director has been updated.");
    }

    public void displayStudioUpdatedBanner(String title) {
        io.print(title + "'s production studio has been updated.");
    }

    public void displayMpaaRatingUpdatedBanner(String title) {
        io.print(title + "'s Mpaa rating has been updated.");
    }

    public void displayUserReviewUpdatedBanner(String title) {
        io.print(title + "'s user review has been updated.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
