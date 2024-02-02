package src.Game;

import Util.Vector2;
import src.Components.Transform;
import src.EntityManager;

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
    Transform upperWallTrans = (Transform) upperWall.components.getComponent(Transform.class);
    Transform lowerWallTrans = (Transform) lowerWall.components.getComponent(Transform.class);
    upperWallTrans.position = new Vector2(0, 9);
    lowerWallTrans.position = new Vector2(0, -9);
  }
  public void update(float deltaTime)
  {
    entityManager.update(deltaTime);
    entityManager.checkCollisions();
  }
}