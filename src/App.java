package src;

import src.Game.Game;

public class App {
  private float runTime = 0;
  static double deltaTime = 0;
  double prevTime = 0;
  double currentTime = 0;
  double currentFPS = 0;
  int targetFPS = 144;
  float currentFrameTime = 0;
  float targetFrameTime = 1.0f / (float) targetFPS;;
  public static InputHandler Input = new InputHandler();
  public Window window = new Window();
  public Game game = new Game();
  
  App(){
    window.addInputHandler(Input);
  }
  public void start()
  {
    game.setup();
    game.start();
    prevTime = (double) System.nanoTime() / 1_000_000_000d;
    while(true){
      
      // Calculating Timers
      currentTime = (double) System.nanoTime() / 1_000_000_000d;
      deltaTime = currentTime - prevTime;
      currentFPS = 1.0f / (float)deltaTime;
      currentFrameTime = (float)currentFPS / 1000;
      runTime += (float)deltaTime;
      
      // Game Content
      game.update((float)deltaTime);
      game.render();

      // Limit FPS
      long timeToSleep = 1000 / (long) targetFPS - (long)deltaTime * 1000;
      
      try {
        if (timeToSleep >= 0)
          Thread.sleep(timeToSleep);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      
      // Calculating Timers
      // System.out.println(currentFPS);
      prevTime = currentTime;
    }
  }
}
