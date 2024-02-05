package src;

import src.Components.ComponentManager;

public interface Entity {
  ComponentManager components = new ComponentManager();
  void start();
  void update(float deltaTime);
}
