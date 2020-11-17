import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;


public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;

	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}

class MainCanvas extends Canvas
{	
	Image currentImg,imgDown,imgUp,imgRight,imgLeft,imgLeft1,imgLeft2;
	boolean aa=true;
	int X=222,Y=262;
	public MainCanvas(){
		try
		{
			imgDown=Image.createImage("/sayo10.png");
			imgUp=Image.createImage("/sayo14.png");
			imgLeft=Image.createImage("/sayo12.png");
			imgLeft1=Image.createImage("/sayo02.png");
			imgLeft2=Image.createImage("/sayo22.png");
			imgRight=Image.createImage("/sayo16.png");
			
			
			currentImg=imgDown;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg , X , Y , 0);

	}

	public void keyPressed(int keyCode){

		int action=getGameAction(keyCode);
		if(action==DOWN){
			currentImg=imgDown;
			System.out.println("向下转");
			if (Y>=0&&Y<262){
				Y=Y+3;
			}
			repaint();
		}
		if(action==UP){
			currentImg=imgUp;
			System.out.println("向上转");
			if (Y>0&&Y<=262){
				Y=Y-3;
			}
			repaint();
		}
		if(action==LEFT){
			
			if (aa){
				currentImg=imgLeft1;
				System.out.println("第一步");
				aa=false;
			}
			else {currentImg=imgLeft2;System.out.println("第二步");aa=true;}
			System.out.println("向左转");
			if (X>0&&X<=222){
				X=X-3;
			}
			repaint();
		}
		if(action==RIGHT){
			currentImg=imgRight;
			System.out.println("向右转");
			if (X>=0&&X<222){
				X=X+3;
			}
			repaint();
		}

	}
}