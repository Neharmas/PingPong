package src.Game;

import src.BaseEntity;
import src.Components.Collision;
import src.Components.Render;
import src.Components.Transform;

public class Wall extends BaseEntity {
  
  @Override
  public void start() {
    components.addComponent( new Transform() );
    components.addComponent( new Collision(9, 1) );
    components.addComponent(new Render(9,1));

  }
}
