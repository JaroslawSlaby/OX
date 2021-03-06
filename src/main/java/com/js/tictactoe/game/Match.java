package com.js.tictactoe.game;

import com.js.tictactoe.player.Player;

import java.util.*;

class Match {

  private static final int MAX_GAMES = 3;
  private final Map<Player, Integer> scores = new HashMap<>();
  private int numberOfGames = 0;


  void setPlayers(List<Player> players) {
    for (Player player : players)
      scores.put(player, 0);
  }

  void addGameWinner(Player player) {
    scores.computeIfPresent(player, (k, v) -> v + 3);
    numberOfGames++;

  }

  void addGameDraw() {
    for (Player player : scores.keySet()) {
      scores.computeIfPresent(player, (k, v) -> v + 1);
    }
    numberOfGames++;
  }

  Integer getPlayersScore(Player player) {
    return scores.get(player);
  }

  boolean isNextRound() {
    return numberOfGames < MAX_GAMES;
  }

  void endMatch() {
    numberOfGames = MAX_GAMES;
  }

}
