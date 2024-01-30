package src;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame {
  InputHandler input = new InputHandler();
  Window()
  {
    JFrame frame = new JFrame("Ping Pong");
    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    setFocusable(true);
    
    addKeyListener(input);
    
  }
}
