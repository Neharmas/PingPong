package src.Game;

import Util.Vector2;
import src.BaseEntity;
import src.Components.Collision;
import src.Components.Physics;
import src.Components.Transform;

import java.awt.event.KeyEvent;

import static src.App.Input;

public class Player extends BaseEntity {
    Vector2 inputAxis = new Vector2();
    public Transform transform;
    public Physics physics;
    public Collision collision;
    public boolean isPlayerOne = false;
    float speed = 3.0f;
    
    Player(boolean isPlayerOne){
        this.isPlayerOne = isPlayerOne;
    }
    
    @Override
    public void start() {
        transform = (Transform) components.addComponent(new Transform());
        physics = (Physics) components.addComponent(new Physics());
        collision = (Collision) components.addComponent(new Collision());
        components.addComponent(new Collision());
        if (isPlayerOne)
            transform.position = new Vector2(-9, 0);
        else
            transform.position = new Vector2(9, 0);
        
        collision.setHeight(3);
        collision.setWidth(1);
    }
    
    @Override
    public void update(float deltaTime){
        if (Input.isAnyKeyPressed()) {
            if(isPlayerOne){
                if (Input.isKeyPressed(KeyEvent.VK_W)) {
                    inputAxis.y += 1;
                    if ( inputAxis.y > 1)
                    {
                        inputAxis.y = 1;
                    }
                }
                if (Input.isKeyPressed(KeyEvent.VK_S)) {
                    inputAxis.y -= 1;
                    if ( inputAxis.y < -1 )
                    {
                        inputAxis.y = -1;
                    }
                }
            }
            else{
                if (Input.isKeyPressed(KeyEvent.VK_UP)) {
                    inputAxis.y += 1;
                    if ( inputAxis.y > 1)
                    {
                        inputAxis.y = 1;
                    }
                }
                if (Input.isKeyPressed(KeyEvent.VK_DOWN)) {
                    inputAxis.y -= 1;
                    if ( inputAxis.y < -1 )
                    {
                        inputAxis.y = -1;
                    }
                }
            }
        }
        else{
            inputAxis.y = 0;
        }
        move(inputAxis, deltaTime);
        /** DEBUG PLAYER POSITION
        if(isPlayerOne)
            System.out.print("Player 1: X:" + transform.position.x + ", Y:" + transform.position.y + "; ");
        else
            System.out.println("Player 2: X:" + transform.position.x + ", Y:" + transform.position.y);
         **/
    }
    
    public void move(Vector2 direction, float deltaTime)
    {
        physics.velocity = direction.normalized().scale(speed * deltaTime);
        transform.position.add(physics.velocity);
    }
}
