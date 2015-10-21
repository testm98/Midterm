 /// Midterm code for 59CST112
 ///M1 TESTA

/**************************************************

    MY FIRST NAME IS.....Matthew
    MY MIDDLE NAME IS....James
    MY LAST NAME IS......Testa
    
  THREE WORDS THAT START WITH INITIALS
  
    First word..........marble
    Second word.........jungle
    third word..........tron
 
 *************************************************/

 float marbleX, marbleY, marbleDX, marbleDY;
 float jungleX, jungleY, jungleDX, jungleDY;
 float tronX, tronY, tronDX, tronDY;
 
 String title= "CST112 MIDTERM EXAM";
 String news= "Press 1 to reset marble, Press 2 to reset jungle, Press 3 to reset tron";
 String author= "Matthew Testa";
 
 float left, right, top, bottom; //TABLE BOUNDARIES
 float middle=360;
 boolean wall=true;
 
 int tableRed=180, tableGreen=220, tableBlue=120; //COLOR OF TABLE
 int score=0, m=0, k=0;
 
 void setup() {
   size(640,480);
    left= 80;
    right= width-200;
    top= 80;
    bottom= 600;
    middle= left + (right-left)/2; 
 }
 
 void draw() {
   background(220,160,120);
   rectMode( CORNERS );
   table( left, right, bottom, top);
   bounce();
   collisions();
   show();
 }
 
 void table( float left, float right, float bottom, float top ) {
   fill( tableRed, tableGreen, tableBlue );
   strokeWeight(20);
   stroke( 110, 20, 10);
   rect(left, right, bottom, top);
   
   if (wall) {
     float middle= ( left + right)/2;
     stroke( 255,0,0,60);
     line( middle, top+20, middle, bottom-180);
    } 
  stroke(0);
  strokeWeight(2);
 }


 void bounce() {
   marbleX += marbleDX; if (marbleX<left || marbleX>right) marbleDX *= -.05;
   marbleY += marbleDY; if (marbleY<top|| marbleY>bottom) marbleDY *= -.05;
   
   jungleX += jungleDX; if (jungleX<left || jungleX>right) jungleDX *= -.05;
   jungleY += jungleDY; if (jungleY<top|| jungleY>bottom) jungleDY *= -.05;
   
   tronX += tronDX; if (tronX<left || tronX>right) tronDX *= -.05;
   tronY += tronDY; if (tronY<top|| tronY>bottom) tronDY *= -.05; 
 }
 
 void collisions() {
  float tmp;
  //elastic impact//
  if ( dist (marbleX, marbleY, jungleX, jungleY ) < 20 ) {
    tmp=marbleDX;  marbleDX=jungleDX; jungleDX=tmp;
    tmp=marbleDY; marbleDY=jungleDY; jungleDY=tmp;
  }
  if ( dist (marbleX, marbleY, tronX, tronY ) < 20 ) {
    tmp=marbleDX;  marbleDX=tronDX; tronDX=tmp;
    tmp=marbleDY; marbleDY=tronDY; tronDY=tmp;
  }
  if ( dist (jungleX, jungleY, tronX, tronY ) < 20 ) {
    tmp=jungleDX;  jungleDX=tronDX; tronDX=tmp;
    tmp=jungleDY; jungleDY=tronDY; tronDY=tmp;
  }
 }
 
 void show() {
   fill(255, 0, 0); ellipse( marbleX, marbleY, 20,20);
   fill(0, 255, 0); ellipse( jungleX, jungleY, 20,20);
   fill(230,240,180); ellipse( tronX, tronY, 20,20);
 }

   
   
   
 
