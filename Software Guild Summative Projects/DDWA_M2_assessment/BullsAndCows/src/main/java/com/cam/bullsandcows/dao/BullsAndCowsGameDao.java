package com.cam.bullsandcows.dao;

import com.cam.bullsandcows.dto.Game;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public interface BullsAndCowsGameDao {

    Game add(Game game);

    List<Game> getAll() throws DataNotFoundException;

    Game findById(int id) throws DataNotFoundException;

    
    boolean update(Game game);

    
    boolean deleteById(int id);
}

