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
	Image HeroImg[][]= new Image[4][3];
	
	int LeftFlag=0,
		RightFlag=0,
		UpFlag=0,
		DownFlag=0;

	// int X=222,Y=262 x,y boundary
	int X=120,Y=100;
	public MainCanvas(){
		try
		{	
			// 0:up 1:down 2:left 3:right
			
			for(int i=0;i<HeroImg.length;i++){
				for(int j=0;j<HeroImg[i].length;j++){
					HeroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}

			currentImg=HeroImg[1][1];
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public void paint(Graphics g){
		g.setColor(120,180,120);   //green backgroung
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg , X , Y , 0);
	}

	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==DOWN){
			if (DownFlag==0){
				currentImg=HeroImg[1][0];
				DownFlag++;
			}
			if (DownFlag==1){
				currentImg=HeroImg[1][2];
				DownFlag--;
			}
			if(Y>0&&Y<258) Y+=3;
			repaint();			
		}
		if(action==UP){
			if (UpFlag==0){
				currentImg=HeroImg[0][0];
				UpFlag++;
			}
			if (UpFlag==1){
				currentImg=HeroImg[0][2];
				UpFlag--;
			}
			if(Y>=4&&Y<262) Y-=3;
			repaint();
		}
		if(action==LEFT){
			if (LeftFlag==0){
				currentImg=HeroImg[2][0];
				LeftFlag++;
			}
			if (LeftFlag==1){
				currentImg=HeroImg[2][2];
				LeftFlag--;
			}
			if(X>6&&X<222) X-=3;
			repaint();
		}
		if(action==RIGHT){
			if (RightFlag==0){
				currentImg=HeroImg[3][0];
				RightFlag++;
			}
			if (RightFlag==1){
				currentImg=HeroImg[3][2];
				RightFlag--;
			}
			if(X>3&&X<218) X+=3;
			repaint();		
		}

	}
}