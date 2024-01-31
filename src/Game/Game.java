package src.Game;

import Util.Vector2;
import src.Player;
import src.Ball;

import static src.App.entityManager;

public class Game{
  public void start()
  {
    Player player1 = (Player)entityManager.addEntity(new Player());
    Player player2 = (Player)entityManager.addEntity(new Player());
    Ball ball = (Ball)entityManager.addEntity(new Ball());
    
    player1.position = new Vector2(-9, 0);
    player2.position = new Vector2(9, 0);
    ball.position = new Vector2(0,0);
  }
  public void afterStart()
  {
    entityManager.start();
  }
  public void update(float deltaTime)
  {
    System.out.println(entityManager.getEntity(0).getPosition());
    entityManager.update(deltaTime);
  }
}