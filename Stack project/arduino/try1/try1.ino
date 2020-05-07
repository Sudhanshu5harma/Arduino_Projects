int analogPin = 0; 
int analogPin1 = 1;
int analogPin2 = 2;  
int val = 0,val1=0,val2=0;         
//String p;
void setup()
{
  Serial.begin(9600);         

}

void loop()

{

  val = analogRead(analogPin); 
   val1 = analogRead(analogPin1); 
    val2 = analogRead(analogPin2); 

 /* Serial.print(val );
  Serial.print(" ");
  Serial.print(val1);
  Serial.print(" ");
  Serial.print(val2);
  
  Serial.println(" x-y-z");
  delay(100);

  */
 
 if (val<315)
 {  Serial.println("forward");
  }
  
if (val>370)
 {  Serial.println("backward");
  }
  
if (val1<315)
 {  Serial.println("right");
   }

if (val1>370)
 {  Serial.println("left");
  }
  

}
