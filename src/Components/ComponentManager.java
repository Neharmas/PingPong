package src.Components;

import java.util.ArrayList;
import java.util.List;

public class ComponentManager {
  private List<BaseComponent> components = new ArrayList<>();

  public <T extends BaseComponent> T addComponent(T componentClass) {
    for (BaseComponent component : components) {
      if (componentClass.getClass().isInstance(component))
        return null;
    }
    components.add(componentClass);
    return componentClass;
  }
  
  public <T extends BaseComponent> T getComponent(Class<T> componentClass) {
    for(BaseComponent component : components) {
      if (componentClass.isInstance(component))
        return componentClass.cast(component);
    }
    return null;
  }
  public <T extends BaseComponent> boolean hasComponent(Class<T> componentClass) {
    for (BaseComponent component : components) {
      if (component.getClass() == componentClass)
        return true;
    }
    return false;
  }

  public List <BaseComponent> getAllComponents() { return components; }
}
