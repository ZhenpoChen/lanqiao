# lanqiao
# 安装环境


# 创建项目

C:\Users\Administrator\j2mewtk\2.5.2\apps


文件接收柜 目录中



标识符、变量、运算符、流程控制、方法、数组：游戏案例


AI：人工智能


#11月14日

## 1.1 显示hero到屏幕上


## 1.2 让hero实现转向



###在所要CLONE的目录下右键鼠标打开git bash即可进入路径



代码上传到github的步骤

1. git clone 仓库地址

2. cd 仓库名称

3. 按日期创建目录，例如11-14

4. 拷贝AI目录到11-14号里面

5. git add 11-14

6. git commit -m "显示hero、实现转向"

7. git push（会提示输入github的用户名和密码）

#接着11月14号的代码继续完善功能，11月17日



# 1、实现4个方向转向

- 变量声明（固定语法）
- 给变量赋值（固定语法）
- 流程控制之if....else

# 2、让hero可以4个方向移动

- 声明变量（声明变量的区域）
```java
int x,y;
```
- 给变量赋值
```java
x=120;
y=100;
```

- 把drawImage中的120替换为x，100替换为y

```java
g.drawImage(currentImg,x,y,0);
```

- 在keyPressed中的UP、DOWN、LEFT、RIGHT中对x和y进行加或减的操作

```java
if(action==LEFT){
    currentImg=img1;
    x=x-1;
    repaint();
}
if(action==UP){
    currentImg=img2;
    y=y-1;
    repaint();
}
if(action==RIGHT){
    currentImg=img3;
    x=x+1;
    repaint();
}
if(action==DOWN){
    currentImg=img;
    y=y+1;
    repaint();
}
```

# 创建公钥私钥 ssh-keygen -t rsa -C "673214953@qq.com"

# 3、 让hero走路更逼真（2个图片来回切换）

- 声明变量
- 增加一个标志


1、让hero的图片切换

- 声明变量
- 给变量赋值

- 把向左的2个图片初始化

  ```java
  img4=Image.createImage("/sayo02.png");
  img5=Image.createImage("/sayo22.png");
  ```
- 2个图片进行切换
```java
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

```

  

协作开发（N个人开发一个项目）
代码版本管理


2、优化代码

- 一维数组
```java
Image[] imgLeft =new Image[3];
Image[] imgRight=new Image[3];
Image[] imgDown =new Image[3];
Image[] imgUp   =new Image[3];
```
- 使用for循环
```java
for(int i=0;i<3;i++){
	imgLeft[i]=Image.createImage("/sayo"+i+"2.png");
	imgRight[i]=Image.createImage("/sayo"+i+"6.png");
	imgDown[i]=Image.createImage("/sayo"+i+"0.png");
	imgUp[i]=Image.createImage("/sayo"+i+"4.png");
}
```

##程序能做三件事-->代码优化

- 做某件事
- 在某个条件下做某件事（if....else）
- 重复做某件事（for、while）

#4、二维数组进行优化
1、二维数组的声明
```java
Image HeroImg[][]= new Image[4][3]; // 4行3列，4个方向每个方向3张图片
```

2、二维数组的赋值
```java
for(int i=0;i<HeroImg.length;i++){
	for(int j=0;j<HeroImg[i].length;j++){
		HeroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
	}
}
```


