package src.Game;

import src.Components.BaseComponent;
import src.Components.ComponentManager;
import src.Components.TestComponent;
import src.Components.Transform;
public class testClass {
  ComponentManager<BaseComponent> components = new ComponentManager<>();
  
  testClass()
  {
    components.addComponent(new Transform());
    components.addComponent(new TestComponent());
    TestComponent transform = (TestComponent) components.getComponent(TestComponent.class);
  }
}
