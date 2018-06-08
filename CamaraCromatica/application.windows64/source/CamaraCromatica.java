import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import gab.opencv.*; 
import processing.video.*; 
import java.awt.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class CamaraCromatica extends PApplet {





Capture Face;
OpenCV System;

int trans;

public void setup() {
 
 
 Face = new Capture(this, 640, 480);
 System = new OpenCV(this, 640, 480);
 System.loadCascade(OpenCV.CASCADE_FRONTALFACE);

 Face.start();
}

public void draw() {
 System.loadImage(Face);
 
 colorMode(HSB,360,100,100,100);
  
 tint(trans,100,100,100);
 imageMode(CORNERS);
 image(Face,0,0);
 
 Rectangle[] faces = System.detect();

 //noFill();
 //strokeWeight(5);
 //stroke(trans,100,100,trans);
 for (int i = 0; i < faces.length; i++) {
  //rect(faces[i].x, faces[i].y, faces[i].width, faces[i].height);
  trans = faces[i].width;
 }
}

public void captureEvent(Capture c){
  c.read();
}
  public void settings() {  size(640, 480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "CamaraCromatica" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
