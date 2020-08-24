
package com.cam.bullsandcows.dao;

import com.cam.bullsandcows.dto.Game;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chelseamiller
 */

@Repository
@Profile("memory")
public class BullsAndCowsInMemoryDao implements BullsAndCowsGameDao{
    private static final List<Game> games = new ArrayList<>();

    @Override
    public Game add(Game newGame) {

        int nextId = games.stream()
                .mapToInt(i -> i.getId())
                .max()
                .orElse(0) + 1;

        newGame.setId(nextId);
        games.add(newGame);
        return newGame;
    }

    @Override
    public List<Game> getAll() {
        return new ArrayList<>(games);
    }

    @Override
    public Game findById(int id) {
        return games.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean update(Game currentGame) {

        int index = 0;
        while (index < games.size()
                && games.get(index).getId() != currentGame.getId()) {
            index++;
        }

        if (index < games.size()) {
            games.set(index, currentGame);
        }
        return index < games.size();
    }

    @Override
    public boolean deleteById(int id) {
        return games.removeIf(i -> i.getId() == id);
    }
    
}
