package src;

import src.Components.BaseComponent;
import src.Components.ComponentManager;

public interface Entity {
  ComponentManager<BaseComponent> components = new ComponentManager<>();
  void start();
  void update(float deltaTime);
}
