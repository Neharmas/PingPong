package src.Game;

import Util.Vector2;
import src.Components.BaseComponent;
import src.Components.ComponentManager;
import src.Components.TestComponent;
import src.Components.Transform;
public class testClass {
  ComponentManager components = new ComponentManager();
  
  testClass()
  {
    Vector2 testss = components.addComponent(new Transform()).position;
    components.addComponent(new TestComponent());
    TestComponent transform = components.getComponent(TestComponent.class);
  }
}
