package src;

import src.Components.BaseComponent;
import src.Components.ComponentManager;

public abstract class BaseEntity implements Entity{
  public final ComponentManager<BaseComponent> components = new ComponentManager<>();
  public BaseEntity(){}
  @Override
  public void start() {}
  
  @Override
  public void update(float deltaTime) {}
}
