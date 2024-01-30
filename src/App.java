package src;

import src.Game.Game;

import javax.swing.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

public class App {
  public static EntityManager entityManager = new EntityManager();
  static double deltaTime = 0;
  double prevTime = 0;
  double currentTime = 0;
  
  double currentFPS = 0;
  int targetFPS = 144;
  float frameTime;
  
  App(){}
  public void start()
  {
    Window window = new Window();
    Game.start();
    Game.afterStart();
    prevTime = (double) System.nanoTime() / 1_000_000_000d;
    while(true){
      
      // Calculating Timers
      currentTime = (double) System.nanoTime() / 1_000_000_000d;
      deltaTime = currentTime - prevTime;
      currentFPS = 1.0f / (float)deltaTime;
      frameTime = 1.0f / (float) targetFPS;
      
      // Input Handling
      
      
      // Game Content
      Game.update(window.input, (float)deltaTime);
      
      // Limit FPS
      long timeToSleep = 1000 / (long) targetFPS - (long)deltaTime * 1000;
      
      try {
        Thread.sleep(timeToSleep);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      
      // Calculating Timers
      
      prevTime = currentTime;
    }
  }
}
