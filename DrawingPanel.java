import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.awt.FontMetrics;
import java.lang.*;
import javax.swing.Timer;

public class DrawingPanel extends JPanel
{
   private long timeStart,timeStop,timeElapsed;
  private int w, h, passed, totalPassed,lastL,totalP, lastLength, curChars, correct;
  private double accuracy;
  private Timer time;
private int x, y, gonethru, letters,start;
  private String[] words = new String[1000];
  private String[] selWords=new String[30];
  private char[] charWords;
  private ArrayList<Character> typedWords;
  private Color[] colors;
  private int ku;
  public DrawingPanel(int w, int h) throws FileNotFoundException{
    correct=0;
    curChars=0;
    this.w = w;
    start=0;
		this.h = h;
		this.setPreferredSize(new Dimension(w,h));
    gonethru=0;
    this.gonethru=gonethru;
    this.setBackground(Color.white);
    Scanner fileScan=new Scanner(new File("words.txt"));
    int d=0;
     while(fileScan.hasNextLine()){
       String current=fileScan.nextLine();
       Scanner lineScan=new Scanner(current);
       String data=lineScan.next();
      
       words[d]=data;
       
       d++;
       this.addMouseListener(new PointListener());
       
     }
    
 
     Random rand=new Random();
   for(int u=0;u<30;u++){
     int randNum=rand.nextInt(1000);
    selWords[u]=words[randNum];

    
  }
   letters=0;
    for(int u=0;u<30;u++){
      for(int g=0;g<selWords[u].length();g++){
        letters++;  
      }
    }
    int wat=0;
    charWords=new char[letters];
     for(int u=0;u<selWords.length;u++){
      for(int g=0;g<selWords[u].length();g++){
charWords[wat]=selWords[u].charAt(g);
wat++;}
    }
    
    colors = new Color[letters];
    typedWords=new ArrayList<Character>();
    for(int awd=0;awd<colors.length;awd++)
        colors[awd]=Color.black;    

    getA();
    gonethru = 0;
    ku=0;
    
  }
  
{

  
addKeyListener(new Keys());
setBackground(Color.white);
setPreferredSize(new Dimension(WIDTH, HEIGHT));
setFocusable(true);
}
  public void paintComponent(Graphics g)
{
  
  
super.paintComponent(g);

  
  g.setColor(Color.black);
  Font myFont = new Font("Arial", Font.BOLD, 20);
  g.setFont(myFont);
  if(start==0){
    
  g.drawString("Best Typing Game Ever",30,40);
  g.drawString("Click to Start",30,60);
  g.drawString("No backspace key! (hard edition)",30,80);}
  if(start==1){
  
  
  lastLength=0;
  int b=0;
  int yPos=20;
  int lastLetter=0;
  
  if(ku<30){
  for(int e=0;e<selWords[ku].length();e++){

      String currentLetter=Character.toString(charWords[e+totalP]);
    
    int letterLength=g.getFontMetrics().stringWidth(currentLetter);
     
      
      g.setColor(colors[e+totalP]);
g.drawString(currentLetter,2+lastLength+b,yPos);
    lastLength+=letterLength;
    b+=1;
  
    
  }
  }
    if(ku==30){
      double wpm=(double)(30/(double)timeElapsed)*60;
      g.drawString(timeElapsed+" seconds",40,40);
      g.drawString(String.format("%.2f",accuracy)+"%",40,60);
      g.drawString("WPM: ",40,80);
      int[] xPoints= {60,160,260,240,80};
      int[] yPoints={190,90,190,290,290};
      Polygon p1=new Polygon(xPoints,yPoints,yPoints.length);
      g.setColor(Color.red);
      g.fillPolygon(p1);
      g.setColor(Color.black);
      g.drawPolygon(p1);
      Font myFont2 = new Font("Arial", Font.BOLD, 85);
      g.drawString(String.format("%.2f",wpm),150,210);
  g.setFont(myFont2);
      //g.drawString(String.format("%.2f",wpm)+" words per minute.",40,83);
    }
       }
repaint();
  
}
private class Keys implements KeyListener{
    
    public void keyPressed(KeyEvent e)
{
  //has to be here
}
  public void keyTyped(KeyEvent e){
     
  int y=0;
  //take input
  char typed=(char)e.getKeyChar();
  char c=Character.toLowerCase(typed);
        if(typed==e.VK_SPACE){
          if(curChars==selWords[ku].length()){
           lastL=selWords[ku].length();
          totalP+=lastL;
          //System.out.println(totalP+"passed");
          curChars=0;
          lastLength=0;
          ku++;
          System.out.println(ku+" words");}
          //System.out.println(ku);
          
        }else if(curChars<selWords[ku].length()){
      typedWords.add(c);
        curChars++;
      
 //check right or wrong

      if(charWords[gonethru]==(typedWords.get(gonethru)))       {
        colors[gonethru]=Color.green;
      }
      else{
        colors[gonethru]=Color.red;
      }
      
  gonethru++;
  for(int i=0;i<gonethru;i++){
   // System.out.println(colors[i]);
    
  }
  //System.out.println(typedWords);
          
  }

    if(ku==30){
      timeStop=System.currentTimeMillis();
      timeElapsed=(timeStop-timeStart)/1000;
      System.out.println(timeElapsed);
      for(int accC=0;accC<charWords.length;accC++){
        if(typedWords.get(accC)==charWords[accC]){
          correct++;
        }
      }
      accuracy=(double)((double)(correct/(double)(charWords.length))*100);

      System.out.println(accuracy);
    }
  }
  public void keyReleased(KeyEvent e){
    //has to be here
  }
  

}
  public void getA(){
    for(int i=0;i<selWords.length;i++){
      System.out.println(selWords[i]);
    }
  }
  public int getPassed(){
    for(int pV=0;pV<selWords[ku].length();pV++){
      passed++;
    }
  totalPassed+=passed;
    return totalPassed;
  }
  private class PointListener implements MouseListener{
    public void mouseClicked(MouseEvent e){
    start=1;
      timeStart=System.currentTimeMillis();
  }
    public void mouseReleased(MouseEvent e){
    
  }
  public void mousePressed(MouseEvent e){
    
  }
    public void mouseEntered(MouseEvent e){
      
    }
    public void mouseExited(MouseEvent e){
      
    }
  }
  
}



