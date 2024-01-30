package src;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

public class InputHandler implements KeyListener {
  
  private Set<Integer> pressedKeys = new HashSet<>();
  
  @Override
  public void keyTyped(KeyEvent e) {
    // Not commonly used for game input
  }
  
  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println(
        "key pressed: " +
            "key char = " + e.getKeyChar() + "  " +
            "key code = " + e.getKeyCode()
    );
    pressedKeys.add(e.getKeyCode());
  }
  
  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println(
        "key released: " +
            "key char = " + e.getKeyChar() + "  " +
            "key code = " + e.getKeyCode()
    );
    //pressedKeys.remove(e.getKeyCode());
  }
  
  public boolean isKeyPressed(int keyCode) {
    return pressedKeys.contains(keyCode);
  }
}
