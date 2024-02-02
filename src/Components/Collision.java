package src.Components;

import Util.Vector2;
import src.BaseEntity;

public class Collision implements BaseComponent{
  private float width = 0;
  private float height = 0;
  
  public Collision(){}
  public Collision(float width, float height) { this.width = width; this.height = height; }
  public void onCollision(BaseEntity entity, BaseEntity collisionEntity)
  {
    Transform firstTrans = (Transform)entity.components.getComponent(Transform.class);
    Vector2 firstVec2 = firstTrans.position;
    
    Collision testCol = (Collision)collisionEntity.components.getComponent(Collision.class);
    Transform testTrans = (Transform)collisionEntity.components.getComponent(Transform.class);
    Vector2 testVec2 = testTrans.position;
    
    if (firstVec2.x < testVec2.x + testCol.width &&
        firstVec2.x + width > testVec2.x &&
        firstVec2.y < testVec2.y + testCol.height &&
        firstVec2.y + height > testVec2.y
    ){
      this.collisionEntity = collisionEntity;
    }
  }
  private BaseEntity collisionEntity = null;
  public void resetCollisionEntity() { this.collisionEntity = null; }
  public BaseEntity getCollisionEntity() { return collisionEntity; }
  public float getWidth() { return width; }
  public void setWidth(float width) { this.width = width; }
  
  public float getHeight() { return height; }
  public void setHeight(float height) { this.height = height; }
}
