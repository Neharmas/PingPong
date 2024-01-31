package src;

import Util.Vector2;

public interface Entity {
  Vector2 position = new Vector2();
  float width = 0;
  float height = 0;
  
  Vector2 getPosition();
  float getWidth();
  float getHeight();
  void start();
  void update(float deltaTime);
  
  boolean collision(Entity entity);
}
