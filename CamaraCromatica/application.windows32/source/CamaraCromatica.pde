import gab.opencv.*;
import processing.video.*;
import java.awt.*;

Capture Face;
OpenCV System;

int trans;

void setup() {
 size(640, 480);
 
 Face = new Capture(this, 640, 480);
 System = new OpenCV(this, 640, 480);
 System.loadCascade(OpenCV.CASCADE_FRONTALFACE);

 Face.start();
}

void draw() {
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

void captureEvent(Capture c){
  c.read();
}
