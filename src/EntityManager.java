package src;

import Util.Pair;
import Util.Vector2;
import src.Components.Collision;
import src.Components.Render;
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
      Collision firstCol = entity.getSecond().components.getComponent(Collision.class);
      firstCol.resetCollisionEntity();
      for ( var collisionEntity : entities ){

        // Checks if the collided Entity is the same as the first
        if (entity.getFirst().equals(collisionEntity.getFirst()))
          continue;

        // Checks if the second entity is already recorded
        if ( collisionEntity.getFirst().equals( firstCol.getCollisionID()) )
          continue;

        hasTransformComponent = collisionEntity.getSecond().components.hasComponent(Transform.class);
        hasCollisionComponent = collisionEntity.getSecond().components.hasComponent(Collision.class);
        if(!hasTransformComponent || !hasCollisionComponent)
          continue;
        
        firstCol.onEnterCollision(entity.getFirst(), collisionEntity.getFirst());
      }
    }
  }
  public void render(){
    for ( var entity : entities ){
      boolean hasTransformComponent = entity.getSecond().components.hasComponent(Transform.class);
      boolean hasRenderComponent = entity.getSecond().components.hasComponent(Render.class);
      if(!hasTransformComponent || !hasRenderComponent)
        continue;
      Vector2 position = entity.getSecond().components.getComponent(Transform.class).position;
      entity.getSecond().components.getComponent(Render.class).render(position);
    }
  }
}
