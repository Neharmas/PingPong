package src;

import Util.Vector2;

public class Ball implements Entity{
    public Vector2 position = new Vector2();
    public Vector2 velocity = new Vector2();
    public float width = 1.0f;
    public float height = 1.0f;
    public float speed = 2.0f;
    public Ball() { }
    
    @Override
    public void start() {
        velocity = new Vector2(1, 0);
    }
    
    @Override
    public void update(float deltaTime){
        move(velocity, deltaTime);
        
        if(width + position.x > 5){
            //System.out.println("Player 1 wins");
        }
        else if(position.x - width < -5)
        {
            //System.out.println("Player 2 wins");
        }
    }
    
    public void move(Vector2 direction, float deltaTime)
    {
        velocity = direction.normalized().scale(speed * deltaTime);
        this.position.add(velocity);
    }
    
    @Override
    public Vector2 getPosition() {
        return position;
    }
    
    @Override
    public float getWidth() {
        return width;
    }
    
    @Override
    public float getHeight() {
        return height;
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
