package src;

import Util.Vector2;

public interface Entity {
  Vector2 position = new Vector2();
  float width = 0;
  float height = 0;
  
  void start();
  void update(float deltaTime);
  
  boolean collision(Entity entity);
}
