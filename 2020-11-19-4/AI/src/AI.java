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
	Image currentImg;
	Image[] imgLeft =new Image[3];
	Image[] imgRight=new Image[3];
	Image[] imgDown =new Image[3];
	Image[] imgUp   =new Image[3];
	
	int LeftFlag=0,
		RightFlag=0,
		UpFlag=0,
		DownFlag=0;

	/*int X=222,Y=262;*/
	int X=120,Y=100;
	public MainCanvas(){
		try
		{	
			for(int i=0;i<3;i++){
				imgLeft[i]=Image.createImage("/sayo"+i+"2.png");
				imgRight[i]=Image.createImage("/sayo"+i+"6.png");
				imgDown[i]=Image.createImage("/sayo"+i+"0.png");
				imgUp[i]=Image.createImage("/sayo"+i+"4.png");
			}
			
			currentImg=imgDown[1];
			
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
			if (DownFlag==0){
				currentImg=imgDown[0];
				DownFlag++;
			}
			if (DownFlag==1){
				currentImg=imgDown[2];
				DownFlag--;
			}
			Y++;
			repaint();
			
		}
		if(action==UP){
			if (UpFlag==0){
				currentImg=imgUp[0];
				UpFlag++;
			}
			if (UpFlag==1){
				currentImg=imgUp[2];
				UpFlag--;
			}
			Y--;
			repaint();
		}
		if(action==LEFT){
			if (LeftFlag==0){
				currentImg=imgLeft[0];
				LeftFlag++;
			}
			if (LeftFlag==1){
				currentImg=imgLeft[2];
				LeftFlag--;
			}
			X--;
			repaint();
		}
		if(action==RIGHT){
			if (RightFlag==0){
				currentImg=imgRight[0];
				RightFlag++;
			}
			if (RightFlag==1){
				currentImg=imgRight[2];
				RightFlag--;
			}
			X++;
			repaint();		
		}

	}
}