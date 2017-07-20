int count = 0;                                          // count = 0
char input[12];                                         // character array of size 12 
boolean flag = 0;
void setup()
{
  Serial.begin(9600);
}
void loop()
{
 if(Serial.available())
   {
      count = 0;
      while(Serial.available() && count < 12)          // Read 12 characters and store them in input array
      {
         input[count] = Serial.read();
         count++;
         delay(5);
      }
      Serial.println(input); 
}
}
