package src;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener{
  //public InputHandler input = new InputHandler();
  private InputHandler input;
  Window()
  {
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setLocation(2720, 300);
    this.setFocusable(true);
    this.addKeyListener(this);
  }
  public void addInputHandler(InputHandler input){
    this.input = input;
  }
  @Override
  public void keyTyped(KeyEvent e) {
    // Not commonly used for game input
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    input.addKey(e.getKeyCode());
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
    input.removeKey(e.getKeyCode());
  }
  
}
