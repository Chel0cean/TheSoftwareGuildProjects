/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cam.bullsandcows.service;

import com.cam.bullsandcows.dao.DataNotFoundException;
import com.cam.bullsandcows.dto.Game;
import com.cam.bullsandcows.dto.Round;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author chelseamiller
 */
public interface BullsAndCowsService {

    public Game startNewGame(Game game);

    public String generateTimestamp();

    public String generateAnswer();

    public String generateScore(String answer, String guess)throws BadUserInputException;

    public boolean setGameStatus(String score, Game currentGame);

    public String getAllGames() throws DataNotFoundException;

    public Game getGameById(int id) throws DataNotFoundException;

    public ResponseEntity updateGame(@PathVariable int id, @RequestBody Game game);

    public Round createRound(Round round);

    public List<Round> getRoundsByGameId(int gameID) throws DataNotFoundException;

    public List<Round> getAllRoundsById(int id) throws DataNotFoundException;

    public ResponseEntity<Round> getRoundById(int id) throws DataNotFoundException;

    public ResponseEntity updateRound(@PathVariable int id, @RequestBody Round round);

    public ResponseEntity deleteGame(@PathVariable int id);

    public ResponseEntity deleteRound(@PathVariable int id);
}
