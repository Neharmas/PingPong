package src;

import Util.Vector2;

public class Player implements Entity{
    public Vector2 position = new Vector2();
    float width = 1.0f;
    float height = 3.0f;
    float speed = 3.0f;
    public Player()
    {
    }
    
    public void move(Vector2 direction, float deltaTime)
    {
        this.position.add(direction);
        this.position.scale(speed * deltaTime);
    }
    
    @Override
    public void start() {
    
    }
    
    @Override
    public void update(float deltaTime){
    
    }
    
    @Override
    public boolean collision(Entity entity)
    {
        return
            position.x < entity.position.x + entity.width &&
            position.x + width > entity.position.x &&
            position.y < entity.position.y + entity.height &&
            position.y + height > entity.position.y;
    }
}
