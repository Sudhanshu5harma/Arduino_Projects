#include <SoftwareSerial.h>
SoftwareSerial SIM900(2,3);//tx conn rx conn

char incoming_char = 0;
String readString;
int ledpin =8;
void setup()
{
  Serial.begin(9600); // for serial monitor
  SIM900.begin(9600); // for GSM shield
  delay(2000);  // give time to log on to network.
  SIM900.print("AT\r");
  SIM900.print("ATE1\r");
  delay(100);
  SIM900.print("ATE1\r");
  delay(100);
  SIM900.print("AT+CMGF=1\r");
  delay(100);
  SIM900.print("AT+CMGF=1\r");// set SMS mode to text
  delay(100);
  SIM900.print("AT+CNMI=2,2,0,0,0\r");
  // blurt out contents of new SMS upon receipt to the GSM shield's serial out
  delay(100);
  SIM900.print("AT+CNMI=2,2,0,0,0\r");
  Serial.println("Send text message");
}

String readSIM900()
{
    String buffer;

    while (SIM900.available())
    {
        char c = SIM900.read();
        buffer.concat(c);
        delay(10);
    }

    return buffer;
}

void loop()
{
    String buffer = readSIM900();
    
    if (buffer.startsWith("\r\n+CMT: "))
    {   
               
        //Serial.println("*** RECEIVED SMS ***");
        
        // Remove first 51 characters
        buffer.remove(0, 51);
        int len = buffer.length();
        // Remove \r\n from tail
        buffer.remove(len - 2, 2);
        //Serial.print("Message send :");
        Serial.println(buffer);
        
      //  Serial.println("*** END SMS ***");
          }
     //Serial.print(Serial.read());
        
        if (buffer=="On")
        {// Serial.println("Message Recieved is ON hence Motor is ON"); 
          digitalWrite(ledpin, HIGH);
          }
      if(buffer=="Off")
     { // Serial.println("Message Recieved is OFF hence Motor is OFF");
       digitalWrite(ledpin, LOW);
        }

    delay(100);
}
