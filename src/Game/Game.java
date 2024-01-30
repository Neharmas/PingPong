package src.Game;

import Util.Vector2;
import src.Ball;
import src.InputHandler;
import src.Player;
import src.Window;

import java.awt.event.KeyEvent;

import static src.App.entityManager;

public class Game {
  public static void start()
  {
    Player player1 = (Player)entityManager.addEntity(new Player());
    Player player2 = (Player)entityManager.addEntity(new Player());
    Ball ball = (Ball)entityManager.addEntity(new Ball());
    
    player1.position = new Vector2(-9, 0);
    player2.position = new Vector2(9, 0);
    ball.position = new Vector2(0,0);
  }
  public static void afterStart()
  {
    entityManager.start();
  }
  public static void update(InputHandler input, float deltaTime)
  {
    //if (input.isKeyPressed(KeyEvent.VK_E))
    //{
      //System.out.println("Yes");
    //}
    
    
    entityManager.update(deltaTime);
  }
}
