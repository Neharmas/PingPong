package src.Components;

import java.util.ArrayList;
import java.util.List;

public class ComponentManager<BaseComponent> {
  private List <BaseComponent> components = new ArrayList<>();
  
  public boolean hasComponent(Class<?> componentClass) {
    for (BaseComponent component : components) {
      if (componentClass.isInstance(component)) {
        return true;
      }
    }
    return false;
  }
  public BaseComponent addComponent(BaseComponent component) {
    if(!components.contains(component)){
      components.add(component);
      return component;
    }
    return null;
  }
  
  public List<BaseComponent> getAllComponents()
  {
    return components;
  }
  
  public BaseComponent getComponent(Class<?> componentName) {
    for(BaseComponent component : components) {
      if (component.getClass().equals(componentName)) {
        return component;
      }
    }
    return null;
  }
}
