#include <SoftwareSerial.h>

SoftwareSerial esp8266(2,3); // make RX Arduino line is pin 2, make TX Arduino line is pin 3.
                             // This means that you need to connect the TX line from the esp to the Arduino's pin 2
                             // and the RX line from the esp to the Arduino's pin 3
String data="";
int count = 0;                                          // count = 0
char input[12];
String inp;// character array of size 12 
boolean flag = 0;

String server = "192.168.1.6"; // www.example.com

String uri = "/EasyKey/rfid.php";// our example is /esppost.php
void setup()
{
  Serial.begin(9600);
  esp8266.begin(9600); // your esp's baud rate might be different

  
  //esp8266.println("AT+RST");
  delay(500);
  esp8266.println("AT+CWMODE=1");
  delay(500);
  esp8266.println("AT+CWJAP=\"NETGEAR31\",\"ajourneli003\"");
  delay(1000);
 httppost();
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
      //MSerial.println(input);
 //data="rfid="+input+"";
inp = String(input[12]);
data = "rfid=" + inp ;

  if(esp8266.available()) // check if the esp is sending a message 
  {
    while(esp8266.available())
    {
      // The esp has data so display its output to the serial window 
      char c = esp8266.read(); // read the next character.
      Serial.write(c);
      
    }  
  }
  

  
  if(Serial.available())
  {
    // the following delay is required because otherwise the arduino will read the first letter of the command but not the rest
    // In other words without the delay if you use AT+RST, for example, the Arduino will read the letter A send it, then read the rest and send it
    // but we want to send everything at the same time.
    delay(1000); 
    
    String command="";
    
    while(Serial.available()) // read the command character by character
    {
        // read one character
      command+=(char)Serial.read();
    }
    esp8266.println(command); // send the read character to the esp8266
  }
  


delay(1000);
}
}
void httppost () 
{
Serial.print("Starting http ");

esp8266.println("AT+CIPSTART=\"TCP\",\"" + server + "\",80");//start a TCP connection.

if( esp8266.find("OK")) {

Serial.println("TCP connection ready");

 delay(1000);

String postRequest =

"POST " + uri + " HTTP/1.0\r\n" +

"Host: " + server + "\r\n" +

"Accept: *" + "/" + "*\r\n" +

"Content-Length: " + data.length() + "\r\n" +

"Content-Type: application/x-www-form-urlencoded\r\n" +

"\r\n" + data;

String sendCmd = "AT+CIPSEND=";//determine the number of caracters to be sent.

esp8266.print(sendCmd);

esp8266.println(postRequest.length() );

delay(500);
Serial.print("end of http connection");
if(esp8266.find(">")) 
{ Serial.println("Sending.."); 
esp8266.print(postRequest);

Serial.print("completed http ");
// close the connection

esp8266.println("AT+CIPCLOSE");
}
}

}

