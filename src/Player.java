package src;

import Util.Vector2;

import static src.App.window;

public class Player implements Entity{
    Vector2 inputAxis = new Vector2();
    public Vector2 velocity = new Vector2();
    public Vector2 position = new Vector2();
    public float width = 1.0f;
    public float height = 3.0f;
    float speed = 3.0f;
    
    public Player() {}
    
    @Override
    public void start() {
    
    }
    
    @Override
    public void update(float deltaTime){
        if(window.input.getKey() != null)
        {
            String key = window.input.getKey();
            switch(key)
            {
                case "w":
                    inputAxis.y = 1;
                    break;
                case "s":
                    inputAxis.y = -1;
                    break;
                default:
                    inputAxis.y = 0;
                    break;
            }
        }
        else{
            inputAxis.y = 0;
        }
        
        inputAxis.x = Math.clamp(inputAxis.x,-1, 1);
        inputAxis.y = Math.clamp(inputAxis.y,-1, 1);
        
        move(inputAxis, deltaTime);
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
