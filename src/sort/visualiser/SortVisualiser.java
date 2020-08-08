
package sort.visualiser;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 *
 * @author Yashraj Balidani
 */
public class SortVisualiser extends JPanel{

    int selected=0;
    int[] ar =new int[300];
    int xloc=40;
    int yloc=490;
    int width=3;
    
    public static void main(String[] args) 
    {
        JFrame a= new JFrame();
        SortVisualiser b= new SortVisualiser();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(1000, 600);
        a.setVisible(true);
        a.setLocationRelativeTo(null);
        b.fill();
        a.add(b);
        b.sort();
        
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.fillRect(0, 0, 1000, 600);
        draw(g);
    }
    
    public void fill()
    {
        Random set = new Random();
        for(int x=0;x<ar.length;x++)
        {
            ar[x]=set.nextInt(400)+1;
        }
    }
    
    public void sort()
    {
        for(int x=0; x<ar.length;x++)
        {
            for(int y=0;y<ar.length-1;y++)
            {
                int temp=0;
                int next=y+1;
                if(ar[y]>ar[next])
                {
                    selected=ar[y];
                    temp=ar[next];
                    ar[next]=ar[y];
                    ar[y]=temp;
                }
                try
                {
                    Thread.sleep(1);
                    repaint();
                }catch (Exception e)
                {
                }
            }
        }
        selected=-1;
        repaint();
    }
    public void draw(Graphics g)
    {
        for(int x=0;x<ar.length;x++)
        {
            if(ar[x]==selected)
            {
                g.setColor(Color.red);
            }else
            {
                g.setColor(Color.WHITE);
            }
            if(selected==-1) g.setColor(Color.YELLOW);
            xloc+= width;
            g.fillRect(xloc, yloc-ar[x], width, ar[x]);
        }
        xloc=40;
    }
}
    

