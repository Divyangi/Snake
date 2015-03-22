/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 *
 * @author Dev
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author a
 */
import java.awt.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.util.Random;
public class Snake extends Frame implements Runnable {
    //private Rectangle rect = new Rectangle(10, 50,5,5);
    int x,y,size=5,turn,dotx,doty,ary[][];
    char dir='N',odir='N';
    char str[];
    boolean flg;
    Thread t;
    public Snake(){
        super();
        
        t=new Thread(this,"Demo");
        str =new char[100];
        ary=new int[100][100];
        flg=true;
        for(int i=0;i<size;i++)
        {
            str[i]='N';
        }
        str[size]='Z';
        setSize(500, 500);
        x=20;
        y=50;
        dotx=200;
        doty=200;
        t.start();
        addWindowListener(new WindowAdapter() {


            @Override
            public void windowClosing(WindowEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              System.exit(0);
              
            }

        });
        addKeyListener(new  KeyAdapter(){
  public void keyPressed(KeyEvent ke){
      odir=dir;
  if(ke.getKeyCode() == KeyEvent.VK_DOWN)
            {
               dir='W';
               turn=1;
               str[0]='W';
            }
if(ke.getKeyCode() == KeyEvent.VK_UP)
            {
                
               dir='E';
            }
if(ke.getKeyCode() == KeyEvent.VK_RIGHT)
            {
               dir='N';
            }
if(ke.getKeyCode() == KeyEvent.VK_LEFT)
            {
               dir='S';
            }
  }
  } );
    }
   
   
    
    public void paint(Graphics g) {
        
        //g.drawString("This is stringggg", 10, 50);
        g.setColor(Color.red);
        g.drawString(dotx+" "+doty+" "+size, 50, 50);
        g.drawRect(dotx,doty,5,5);
        g.fillRect(dotx,doty,5,5);
        
            for(int i=size-1;i>=0;i--)
            {
                
                if(flg==true)
                {
                   ary[i][0]=x-(i*5);
                   ary[i][1]=y;
                    g.drawRect(ary[i][0], ary[i][1], 5, 5);
                    g.fillRect(ary[i][0], ary[i][1], 5, 5); 
                   System.out.println(ary[i][0]+"   "+ary[i][1]);
                   
                }
                else
                {
                     if(i==0)
                    {
                        ary[i][0]=x;
                        ary[i][1]=y;    
                    }
                    else
                    {
                        ary[i][0]=ary[i-1][0];
                        ary[i][1]=ary[i-1][1];
                    }
                    g.drawRect(ary[i][0], ary[i][1], 5, 5);
                    g.fillRect(ary[i][0], ary[i][1], 5, 5); 
                    System.out.println(ary[i][0]+"   "+ary[i][1]);
                }
                
            }
            if(ary[0][0]==dotx && ary [0][1]==doty)
            {
                size+=1;
            }
         flg=false;
//        try{
//            Thread.sleep(1000);
//        }
//        catch(InterruptedException ee){}
    }
    public void run()
    {
        while(true)
        {
           this.repaint();
            try {
                Thread.sleep(200);
                }
            catch (InterruptedException ie) {   } 
             if(dir=='N')
             {
                 x+=5;
             }
             else if(dir=='W')
             {
                 y+=5;
             }
             else if(dir=='S')
             {
                 x-=5;
             }
             else if(dir=='E')
             {
                 y-=5;
             }
             ary[0][0]=x;
             ary[0][1]=y;  
        }

     }
    
    public static void main(String []args) {
    Snake sk1 = new Snake();
    sk1.setVisible(true);
        
    }
}

