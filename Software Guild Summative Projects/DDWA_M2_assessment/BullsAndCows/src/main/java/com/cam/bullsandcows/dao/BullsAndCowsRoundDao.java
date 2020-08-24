
package com.cam.bullsandcows.dao;

import com.cam.bullsandcows.dto.Round;
import java.util.List;

/**
 *
 * @author chelseamiller
 */
public interface BullsAndCowsRoundDao {
       Round add(Round round);

    List<Round> getAll() throws DataNotFoundException;

    Round findById(int id) throws DataNotFoundException;

    List<Round> findRoundsByGameId(int gameId) throws DataNotFoundException;
            
    
    boolean update(Round round);

    
    boolean deleteById(int id);
}
