package src;

import Util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class EntityManager {
  private List<Pair<Integer, Entity>> entities = new ArrayList<Pair<Integer, Entity>>();
  private Integer ID = 0;
  public Entity addEntity(Entity entity)
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
  
  public Entity getEntity(Integer ID)
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
  
  public List<Pair<Integer, Entity>> getEntities() {
    return entities;
  }
  
  public void start()
  {
    for (var pair : entities) {
      pair.getSecond().start();
    }
  }
  
  public void update(float deltaTime)
  {
    for (var pair : entities) {
      pair.getSecond().update(deltaTime);
    }
  }
}
