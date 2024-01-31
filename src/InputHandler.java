package src;

public class InputHandler {
  private String keyPressed;
  
  public void setKey(String key)
  {
    keyPressed = key;
  }
  
  public void deleteKey()
  {
    keyPressed = null;
  }
  
  public String getKey()
  {
    if (keyPressed == null)
    {
      return null;
    }
    return keyPressed;
  }
}
