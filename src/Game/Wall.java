package src.Game;

import src.BaseEntity;
import src.Components.Collision;
import src.Components.Transform;

public class Wall extends BaseEntity {
  
  @Override
  public void start() {
    components.addComponent( new Transform() );
    components.addComponent( new Collision(9, 1) );
  }
}
