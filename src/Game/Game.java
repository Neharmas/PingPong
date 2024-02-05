package src.Game;

import Util.Vector2;
import src.Components.Transform;
import src.EntityManager;

import javax.swing.*;

public class Game{
  public final static EntityManager entityManager = new EntityManager();
  Player player1 = new Player(true);
  Player player2 = new Player(false);
  Ball ball = new Ball();
  Wall upperWall = new Wall();
  Wall lowerWall = new Wall();
  public void setup()
  {
    entityManager.addEntity(player1);
    entityManager.addEntity(player2);
    entityManager.addEntity(ball);
    entityManager.addEntity(upperWall);
    entityManager.addEntity(lowerWall);
  }
  public void start()
  {
    entityManager.start();
    upperWall.components.getComponent(Transform.class).position = new Vector2(0, 9);
    lowerWall.components.getComponent(Transform.class).position = new Vector2(0, -9);
  }
  public void update(float deltaTime)
  {
    entityManager.checkCollisions();
    entityManager.update(deltaTime);
    if(ball.transform.position.x >= 9)
      win("Player 1");
    else if(ball.transform.position.x <= -9)
      win("Player 2");
  }
  public void render()
  {
    entityManager.render();
  }

  public void win(String player)
  {
    System.out.println(player + " won the Game!");
  }
}