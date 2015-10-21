//// For object-oriented programming, you will need class definitions like these ////

class Ball {
  //// PROPERTIES:  position, speed, color, etc. ////   (What a Ball "has".)
  float x,y, dx,dy;
  int r,g,b;
  int number;
  
  //// CONSTRUCTORS (if any). ////
  
  //// METHODS:  show, move, detect a "hit", etc. ////  (What a Ball "does".)
  void show() {
    fill(r,g,b);
    ellipse( x,y, 30,30 );
  }
  void move() {
    x=  x+dx;
    y=  y+dy;
  }
  // Detect if this Ball has hit abother Ball. 
  boolean hit( Ball other ) {
    if ( dist( this.x,this.y, other.x,other.y ) < 60 ) return true;
    else return false;
  }
}
  
  
  
