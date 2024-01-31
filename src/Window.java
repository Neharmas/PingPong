package src;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements KeyListener{
  public InputHandler input = new InputHandler();
  Window()
  {
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
    this.setFocusable(true);
    this.addKeyListener(this);
  }
  
  @Override
  public void keyTyped(KeyEvent e) {
    // Not commonly used for game input
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    input.setKey(String.valueOf(e.getKeyChar()));
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
    input.deleteKey();
  }
  
}
