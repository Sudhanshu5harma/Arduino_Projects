#define MOTORPIN 11
#define WARNLEDPIN 12
char tag[] ="090096E8E691"; // Replace with your own Tag ID
char input[12];       // A variable to store the Tag ID being presented
int count = 0,i;        // A counter variable to navigate through the input[] character array
boolean flag = 0;     // A variable to store the Tag match status

void setup()
{
  Serial.begin(9600);   // Initialise Serial Communication with the Serial Monitor
  pinMode(MOTORPIN,OUTPUT); // RELAY OUTPUT
  pinMode(WARNLEDPIN,OUTPUT); //WRONG TAG INDICATOR
}
void loop()
{
  digitalWrite(WARNLEDPIN,LOW);
  digitalWrite (MOTORPIN,LOW);
   if(Serial.available())
   {
      count = 0;
      while(Serial.available() )          // Read 12 characters and store them in input array
      {
         input[count] = Serial.read();
         count++;
         delay(5);
      }
     // Serial.println(input); 
   // Serial.println(tag);
  for(i=0;i<12;i++)
{if(tag[i] == input[i])
{flag=1;
}else 
{flag=0;
  }
}

    if(flag==1) // If flag variable is 1, then it means the tags match
    {
      Serial.println("Access Allowed!");
      digitalWrite(MOTORPIN,HIGH);
      digitalWrite (WARNLEDPIN,LOW);
      
    }
    else
    {
      Serial.println("Access Denied"); // Incorrect Tag Message
      digitalWrite(WARNLEDPIN,HIGH);
      digitalWrite(MOTORPIN,LOW);
      
    }
     
   }
} 

