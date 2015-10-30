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
 float ratX, ratY, ratDX; 
 
 String title= "CST112 MIDTERM EXAM";
 String news= "Press 1 to reset marble, Press 2 to reset jungle, Press 3 to reset tron";
 String author= "Matthew Testa";
 
 float left=50, right=590, top=120, bottom=380; //TABLE BOUNDARIES
 float middle= (left+right)/2;
 boolean wall=true;
 int frame;
 int tableRed=180, tableGreen=220, tableBlue=120; //COLOR OF TABLE
 
 
 void setup() {
   size(640,480);
   reset();
    
 }
 
 void draw() {
   background(220,160,120);
   rectMode( CORNERS );
   table( left, top, right, bottom);
   bounce();
   collisions();
   show();
   buttons();
   rat();
 }
 
 void table( float left, float top, float right, float bottom ) {
   fill( tableRed, tableGreen, tableBlue );
   strokeWeight(20);
   stroke( 110, 20, 10);
   rect(left-10, top-10, right+10, bottom+10);
   
   if (wall) {
     float middle= ( left + right)/2;
     stroke( 255,0,0,60);
     line( middle, top, middle, bottom);
    } 
  stroke(0);
  strokeWeight(1);
 }


 void bounce() {
   if (wall) {
   marbleX += marbleDX; if (marbleX<middle || marbleX>right) marbleDX *= -1;
   marbleY += marbleDY; if (marbleY<top|| marbleY>bottom) marbleDY *= -.1;
   
   jungleX += jungleDX; if (jungleX<middle || jungleX>right) jungleDX *= -1;
   jungleY += jungleDY; if (jungleY<top|| jungleY>bottom) jungleDY *= -1;
   
   tronX += tronDX; if (tronX<middle || tronX>right) tronDX *= -1;
   tronY += tronDY; if (tronY<top|| tronY>bottom) tronDY *= -1; 
 }
   else {
   marbleX += marbleDX; if (marbleX<left || marbleX>right) marbleDX *= -1;
   marbleY += marbleDY; if (marbleY<top|| marbleY>bottom) marbleDY *= -.1;
   
   jungleX += jungleDX; if (jungleX<left || jungleX>right) jungleDX *= -1;
   jungleY += jungleDY; if (jungleY<top|| jungleY>bottom) jungleDY *= -1;
 
   tronX += tronDX; if (tronX<middle || tronX>right) tronDX *= -1;
   tronY += tronDY; if (tronY<top|| tronY>bottom) tronDY *= -1; 
   }
 }
 void collisions() {
  float tmp;
  //elastic impact//
  if ( dist (marbleX, marbleY, jungleX, jungleY ) < 30 ) {
    tmp=marbleDX;  marbleDX=jungleDX; jungleDX=tmp;
    tmp=marbleDY; marbleDY=jungleDY; jungleDY=tmp;
  }
  if ( dist (marbleX, marbleY, tronX, tronY ) < 30 ) {
    tmp=marbleDX;  marbleDX=tronDX; tronDX=tmp;
    tmp=marbleDY; marbleDY=tronDY; tronDY=tmp;
  }
  if ( dist (jungleX, jungleY, tronX, tronY ) < 30 ) {
    tmp=jungleDX;  jungleDX=tronDX; tronDX=tmp;
    tmp=jungleDY; jungleDY=tronDY; tronDY=tmp;
  }
 }
 
 void show() {
   stroke(0);
   strokeWeight(1);
   fill(255, 0, 0); ellipse( marbleX, marbleY, 30,30);
   fill(0, 255, 0); ellipse( jungleX, jungleY, 30,30);
   fill(230,240,180); ellipse( tronX, tronY, 30,30);
   text("m", marbleX, marbleY);
   text("j", jungleX, jungleY);
   text("t", tronX,tronY);
 }

void reset() {
  marbleX= random( middle, right); marbleY= random(top, bottom);
  jungleX= random( middle, right); jungleY= random(top, bottom);
  tronX= random( middle, right); tronY= random(top, bottom);
  
  marbleX= random( -3,3); marbleY= random( -3,3);
  jungleX= random( -3,3); jungleY= random( -3,3);
  tronX= random( -3,3); tronY= random( -3,3);
}

 void keyPressed() {
   if (key == 'r') { 
   reset(); 
   }
 } 
 
 void buttons() {
   rectMode( CORNER );
   strokeWeight(2);
   fill(180,100,50);
   rect(20,20,100,50);
   rect(180,20,100,50);
   rect(380,20,100,50);
   rect(520,20,100,50);
   fill(255);
   text("Reset 'R'", 45,45);
   text("Turn Off Wall 'W'", 185,45);
   text("Pink Table 'P'", 395, 45);
   text("Release Mouse 'M'", 520, 45);
 }
   
   void rat() {          
  /*if (rat){*/                
    fill(128,128,128);
    strokeWeight(1);
    rect(ratX, ratY,10,20);
    ratX += ratDX;
    frame = frame + 1;
     if ( ratX<left || ratX>right ) ratDX *= -1;       
     if (ratDX == -1){
       if(frame/30 % 2 == 0){
         line(ratX+15,ratY+5,ratX+10,ratY+4);
         
       }else{
         line(ratX+10,ratY+4,ratX+20,ratY-1);
       }
     
     }else if (ratDX == 1){
       if(frame/30 % 2 == 0){
         line(ratX-10,ratY+4,ratX-20,ratY+4);
       }else{
         line(ratX-10,ratY+4,ratX-20,ratY-1);
       }
   }
 }
 
   
 
