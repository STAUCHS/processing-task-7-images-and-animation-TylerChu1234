import processing.core.PApplet;
import processing.core.PImage;

/**
* A program that animates a face, circle, and a rectangle.
* @author: T.Chu
* 
*/

public class Sketch extends PApplet {

  // sets face and backgroudn variables
  PImage imgFace;
  PImage imgBackground;
  
  // x and y coordinate for face
  float fltFaceX = 50;
  float fltFaceY = 100;

  // x and y coordinate for background
  float fltBackX = 0;
  float fltBackY = 0;

  // x and u coordinate for circle
  float fltEllipseX = 50;
  float fltEllipseY = 100;

  // x and y coordinate for rectangle
  float fltRectX = 50;
  float fltRectY = 100;

  // creates float for the angle of the rectangle
  float fltRectangleAngle;

  // face speed variables
  float fltXSpeed = random(1, 5);
  float fltYSpeed = random(1, 5);

  // circle speed variables
  float fltEllipseXSpeed = random(1,5);
  float fltEllipseYSpeed = random(1,5);

  // rectangle speed variables
  float fltRectangleSpeed = (float)0.3;

  // define colours
  int black = color(0);
  int magenta = color(255, 0, 255);

   /**
  * @param settings sets the size of the window
  * @author T.Chu
  */

  public void settings() {
    size(400, 400);
  }

 /**
  * @param setup loads and resizes the face and background images
  * @author T.Chu
  */

  public void setup() {

    // load Face
    imgFace = loadImage("quan.jpg");

    // resize Face
    imgFace.resize(imgFace.width / 8, imgFace.height / 8);

    // load background
    imgBackground = loadImage("size.png");

    // resize background
    imgBackground.resize(imgBackground.width * 2, imgBackground.height * 2);

  }

  /**
  * @param Draw Draws the face, circle, and rectangle, and animates them
  * @author T.Chu
  */

  public void draw() {
    
    // draws background
    image (imgBackground, fltBackX, fltBackY);

    // set color circle to black
    fill(black);

    // draws circle
    ellipse(fltEllipseX, fltEllipseY, 50, 50);

    // moves circle 
    fltEllipseX += fltEllipseXSpeed;
    fltEllipseY += fltEllipseYSpeed;

    // set rectangle color to magenta
    fill(magenta);

    // draws rectangle
    rect(fltRectX, fltRectY, 20,20);

    // makes rectangle move in a circular pattern
    fltRectX += width / 4 * cos(fltRectangleAngle) * fltRectangleSpeed;
    fltRectY += height / 4 * sin(fltRectangleAngle) * fltRectangleSpeed;
    
    // draw face
    image(imgFace, fltFaceX, fltFaceY);

    // moves face
    fltFaceX += fltXSpeed;
    fltFaceY += fltYSpeed;

    // sets boundaries for face
    if (fltFaceX >= width - imgFace.width || fltFaceX <= 0) {
      fltXSpeed *= -1;
    }

    if (fltFaceY >= height - imgFace.height || fltFaceY <= 0) {
      fltYSpeed *= -1;
    }

    // sets boundaries for circle
    if (fltEllipseX >= width - fltEllipseX/25|| fltEllipseX <= 20) {
      fltEllipseXSpeed *= -1;
    }

    if (fltEllipseY >= height || fltEllipseY <= 25) {
      fltEllipseYSpeed *= -1;
    }

    // sets boundaries for rectangle
    fltRectX = constrain(fltRectX, 0, width - 25);
    fltRectY = constrain(fltRectY, 0, height - 25);
    fltRectangleAngle += fltRectangleSpeed;
   
  }

}