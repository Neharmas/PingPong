package src;

import Util.Pair;
import Util.Vector2;
import src.Components.Collision;
import src.Components.Transform;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class EntityManager {
  private List<Pair<Integer, BaseEntity>> entities = new ArrayList<>();
  private Integer ID = 0;
  public BaseEntity addEntity(BaseEntity entity)
  {
    entities.add(new Pair<>(ID, entity));
    ++ID;
    return entity;
  }
  
  public void removeEntity(Integer ID)
  {
    for (var pair : entities) {
      Integer indexedID = pair.getFirst();
      if (Objects.equals(indexedID, ID))
      {
        entities.remove(pair);
      }
    }
  }
  
  public BaseEntity getEntity(Integer ID)
  {
    for (var pair : entities) {
      Integer indexedID = pair.getFirst();
      if (Objects.equals(indexedID, ID))
      {
        return pair.getSecond();
      }
    }
    return null;
  }
  
  public List<Pair<Integer, BaseEntity>> getAllEntities() {
    return entities;
  }
  
  public void start() {
    for (var pair : entities) {
      pair.getSecond().start();
    }
  }
  
  public void update(float deltaTime) {
    for (var pair : entities) {
      pair.getSecond().update(deltaTime);
    }
  }
  
  public void checkCollisions(){
    for ( var entity : entities ){
      boolean hasTransformComponent = entity.getSecond().components.hasComponent(Transform.class);
      boolean hasCollisionComponent = entity.getSecond().components.hasComponent(Collision.class);
      if(!hasTransformComponent || !hasCollisionComponent)
        continue;
      Collision firstCol = (Collision) entity.getSecond().components.getComponent(Collision.class);
      firstCol.resetCollisionEntity();
      for ( var collisionEntity : entities ){
        if (entity.getFirst().equals(collisionEntity.getFirst()))
          continue;
        if ( firstCol.getCollisionEntity() == collisionEntity.getSecond())
          continue;
        
        hasTransformComponent = collisionEntity.getSecond().components.hasComponent(Transform.class);
        hasCollisionComponent = collisionEntity.getSecond().components.hasComponent(Collision.class);
        if(!hasTransformComponent || !hasCollisionComponent)
          continue;
        
        firstCol.onCollision(entity.getSecond(), collisionEntity.getSecond());
      }
    }
  }
}
