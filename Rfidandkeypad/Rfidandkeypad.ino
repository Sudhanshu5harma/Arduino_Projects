#include <Keypad.h>

const byte r =4;
const byte c =4;
char keys[r][c] ={
  {'1','2','3','A'},
  {'4','5','6','B'},
  {'7','8','9','C'},
  {'*','0','#','D'},
};
byte rowPins[r] = {2,3,4,5};
byte colmPins[c] = {6,7,8,9};
Keypad keypad =Keypad(makeKeymap(keys), rowPins,colmPins,r,c);
int count = 0,pin1=1247,i=0;                                          // count = 0
char input[12];                                         // character array of size 12 
boolean flag = 0,done=0;

char tag[] ="090096E8E691";
void setup()
{
  Serial.begin(9600);
}
/*int pinP()
{ char key = keypad.getKey();
  if(key){
    Serial.print(key);
     }
return key;
}*/
void loop()
{
  char key=keypad.getKey();
  if(key=='A'){
 Serial.println("Scan Your Tag"); 
  }
  if((key=='C') && (done==1))
  {Serial.println("PIN ACCEPTED");
  }
 if(Serial.available())
   {
      count = 0;
      while(Serial.available() && count < 12)          // Read 12 characters and store them in input array
      {
         input[count] = Serial.read();
         count++;
         delay(5);
      }
for(i=0;i<12;i++)
{if(tag[i] == input[i])
{flag=1;
}else 
{flag=0;
  }
}

 
if(flag==1) // If flag variable is 1, then it means the tags match
{
  Serial.println("Welcome Sudhanshu Sharma ");
  Serial.println("Please enter pin ");
  done = 1;
}
if(flag==0)
{ done=0;
  Serial.println("Sorry Card Not Registered ");
   }

}
}
    

  

