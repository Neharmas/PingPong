package src.Components;

import Util.Vector2;

import static src.Game.Game.entityManager;

public class Collision implements BaseComponent{
  private float width = 0;
  private float height = 0;
  
  public Collision(){}
  public Collision(float width, float height) { this.width = width; this.height = height; }
  public void onEnterCollision(Integer firstEntity, Integer secondEntity)
  {
    Vector2 firstPos = entityManager.getEntity(firstEntity).components.getComponent(Transform.class).position;

    Vector2 secondPos = entityManager.getEntity(secondEntity).components.getComponent(Transform.class).position;
    Collision secondCol =  entityManager.getEntity(secondEntity).components.getComponent(Collision.class);

    if(secondEntity.equals(getCollisionID()))
      return;
    if (firstPos.x < secondPos.x + secondCol.width &&
        firstPos.x + width > secondPos.x &&
        firstPos.y < secondPos.y + secondCol.height &&
        firstPos.y + height > secondPos.y
    ){
      collisionEntity = secondEntity;
      secondCol.setCollisionID(firstEntity);
    }
  }
  private Integer collisionEntity = null;
  public void resetCollisionEntity() { this.collisionEntity = null; }
  public Integer getCollisionID() { return collisionEntity; }
  public void setCollisionID(Integer collisionEntity) { this.collisionEntity = collisionEntity; }
  public float getWidth() { return width; }
  public void setWidth(float width) { this.width = width; }
  
  public float getHeight() { return height; }
  public void setHeight(float height) { this.height = height; }
}
