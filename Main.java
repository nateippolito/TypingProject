import javax.swing.*;
import java.io.*;
public class Main
{
public static void main(String[] args) throws FileNotFoundException
{
  int w = 500;
		int h = 500;
		
JFrame frame = new JFrame("Typing Game");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.getContentPane().add(new DrawingPanel(w,h));
frame.pack();
frame.setVisible(true);
}
}
