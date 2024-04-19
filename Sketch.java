import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

  PImage imgMeteor;
  PImage imgBackground;
  
  // x and y coordinate for meteor
  float fltMeteorX = 50;
  float fltMeteorY = 100;
  float fltBackX = 0;
  float fltBackY = 0;
  float fltEllipseX = 50;
  float fltEllipseY = 100;
  float fltRectX = 50;
  float fltRectY = 100;
  float fltRectAngle;


  // meteor speed variables
  float fltXSpeed = random(1, 5);
  float fltYSpeed = random(1, 5);
  float fltEllipseXSpeed = random(1,5);
  float fltEllipseYSpeed = random(1,5);
  float fltRectangleSpeed = (float)0.3;
  // define colours
  int black = color(0);
  int white = color(255);
  int magenta = color(255, 0, 255);

  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(0, 0, 0);
    // load meteor
    imgMeteor = loadImage("george.jpeg");
    // resize meteor
    // imgMeteor.resize(50, 50);
    imgMeteor.resize(imgMeteor.width/2, imgMeteor.height/2);
    // load missile

    // resize missile

    // load rocket

    // resize rocket

    // background
    imgBackground = loadImage("size.png");
    imgBackground.resize(imgBackground.width*2, imgBackground.height*2);


    
  }

  public void draw() {
    
    image (imgBackground, fltBackX, fltBackY);
    fill(black);
    ellipse(fltEllipseX,fltEllipseY,50,50);
    fltEllipseX+=fltEllipseXSpeed;
    fltEllipseY+=fltEllipseYSpeed;
    fill(magenta);
    rect(fltRectX, fltRectY, 20,20);
    fltRectX += width / 4 * cos(fltRectAngle) * fltRectangleSpeed;
    fltRectY += height / 4 * sin(fltRectAngle) * fltRectangleSpeed;
    
    
    // draw meteor and move
    image(imgMeteor, fltMeteorX, fltMeteorY);

    fltMeteorX += fltXSpeed;
    fltMeteorY += fltYSpeed;


    if (fltMeteorX >= width - imgMeteor.width || fltMeteorX <= 0) {
      fltXSpeed *= -1;
    }

    if (fltMeteorY >= height - imgMeteor.height || fltMeteorY <= 0) {
      fltYSpeed *= -1;
    }
    if (fltEllipseX >= width - fltEllipseX/25|| fltEllipseX <= 20) {
      fltEllipseXSpeed *= -1;
    }

    if (fltEllipseY >= height || fltEllipseY <= 25) {
      fltEllipseYSpeed *= -1;
    }

    fltRectX = constrain(fltRectX, 0, width - 25);
    fltRectY = constrain(fltRectY, 0, height - 25);
    fltRectAngle += fltRectangleSpeed;
    // draw missile and move


    // draw rocket and move

  }
}