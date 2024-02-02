package src;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class InputHandler {
  private List<Integer> keysPressed = new ArrayList<>();
  
  public void addKey(int key) {
    if(keysPressed.contains(key))
      return;
    keysPressed.add(key);
    //System.out.println(key + " was Pressed");
  }
  
  public void removeKey(int key) {
    keysPressed.remove(Integer.valueOf(key));
    //System.out.println(key + " was released");
  }
  
  public boolean isKeyPressed(int request) {
    return keysPressed.contains(request);
  }
  public boolean isKeyPressed(char request) {
    return keysPressed.contains(KeyEvent.getExtendedKeyCodeForChar(request));
  }
  public boolean isAnyKeyPressed()
  {
    return !keysPressed.isEmpty();
  }
}
