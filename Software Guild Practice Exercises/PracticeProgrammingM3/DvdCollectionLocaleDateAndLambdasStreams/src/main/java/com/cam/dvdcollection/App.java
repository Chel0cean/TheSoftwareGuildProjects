
package com.cam.dvdcollection;

import Controller.DvdCollectionController;
import dao.DvdCollectionDao;
import dao.DvdCollectionDaoFileImpl;
import ui.DvdCollectionView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

/**
 *
 * @author chelseamiller
 */
public class App {
      public static void main(String[] args) {
    UserIO myIo = new UserIOConsoleImpl();
    DvdCollectionView myView = new DvdCollectionView(myIo);
    DvdCollectionDao myDao = new DvdCollectionDaoFileImpl();
    DvdCollectionController controller =
            new DvdCollectionController(myDao, myView);
    controller.run();
}

}
