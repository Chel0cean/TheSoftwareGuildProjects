
package com.cam.bullsandcows.service;

import com.cam.bullsandcows.dao.BullsAndCowsRoundDao;
import com.cam.bullsandcows.dto.Round;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chelseamiller
 */

public class roundDaoStub implements BullsAndCowsRoundDao {

    gameDaoStub gameDao;
    List<Round> allRounds;
    Round roundOne;
  
    Round roundTwo;
  
    int idOne = 1;
    int idTwo = 2;
    int gameId = 1;
    String guessOne = "2345";
    String guessTwo = "3456";

    public roundDaoStub() {
    
        roundOne.setId(idOne);
        roundOne.setGameId(gameId);
        roundOne.setGuess(guessOne);

        roundTwo.setId(idTwo);
        roundTwo.setGameId(gameId);
        roundTwo.setGuess(guessTwo);

        allRounds.add(roundOne);
        allRounds.add(roundTwo);
    }

    @Override
    public Round add(Round round) {
        allRounds.add(round);
        return round;
    }

    @Override
    public List<Round> getAll() {
        return allRounds;
    }

    @Override
    public Round findById(int id) {
        Round round = null;
        for (Round i : allRounds) {
            if (i.getId() == id) {
                round = i;
            }
        }
        return round;
    }

    @Override
    public ArrayList<Round> findRoundsByGameId(int gameId) {
        ArrayList<Round> roundsByGameId = null;
        for (Round i : allRounds) {
            if (i.getGameId() == gameId) {
                roundsByGameId.add(i);
            }
        }
        return roundsByGameId;
    }

    @Override
    public boolean update(Round round) {
        for (Round i : allRounds) {
            if (i.getId() == round.getId()) {
                i = round;
            }

        }
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        for (Round i : allRounds) {
            if (i.getId() == id) {
                allRounds.remove(i);
            }

        }
        return true;
    }
}
