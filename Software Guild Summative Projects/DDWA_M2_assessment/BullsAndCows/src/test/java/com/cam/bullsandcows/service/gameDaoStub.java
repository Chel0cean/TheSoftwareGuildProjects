/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cam.bullsandcows.service;

import com.cam.bullsandcows.dao.BullsAndCowsGameDao;
import com.cam.bullsandcows.dto.Game;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author chelseamiller
 */

public class gameDaoStub implements BullsAndCowsGameDao {

    roundDaoStub roundDao;
    
    List<Game> allGames;

    public Game onlyGame = new Game();
    String answer = "1234";
    int id = 1;
    boolean status = true;

    public gameDaoStub() {
        onlyGame.setId(id);
        onlyGame.setAnswer(answer);
        onlyGame.setStatus(status);
       onlyGame.setRounds(roundDao.findRoundsByGameId(id));
        allGames.add(onlyGame);
    }

    @Override
    public Game add(Game game) {
        allGames.add(game);
        return game;
    }

    @Override
    public List<Game> getAll() {
        return allGames;

    }

    @Override
    public Game findById(int id) {
        Game game=null;
        for (Game i : allGames) {
            if (i.getId() == id) {
                game = i;
            } else {
                game = onlyGame;
            }
        }
        return game;
    }

    @Override
    public boolean update(Game game) {
        for (Game i : allGames) {
            if (i.getId() == game.getId()) {
                i = game;
            }
        }
        return true;
    }

    @Override
    public boolean deleteById(int id) {
        for (Game i : allGames) {
            if (i.getId() == id) {
                allGames.remove(i);
            }
        }
        return true;
    }

}
