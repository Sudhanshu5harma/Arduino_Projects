#include <Q2HX711.h>
float val,cal;
const byte hx711_data_pin = A2;
const byte hx711_clock_pin = A3;


Q2HX711 hx711(hx711_data_pin, hx711_clock_pin);

void setup() 
{
  //0->light
  //1->gnd
  pinMode(0,OUTPUT);
  pinMode(1,OUTPUT);
  
  digitalWrite(1,LOW);
  delay(1500);
  digitalWrite(0,LOW);
  
  Serial.begin(19200);
  val=hx711.read()/1000;
  
}
 void loop()
{
   calibrate();
  float w;
  w=weigh();  //Reading the Weight
  char string[10];
  Serial.println(float (w));
 
}
float weigh()
 {
  float weight=0.00;
  for(int i=0;i<5;i++)   
  {
  cal=hx711.read()/1000;
  weight=weight+(abs(val-cal));   
  delay(100);
 }
  float w=weight/5;   //Calculating the Avg. Weight
   return w;
 }
 void calibrate()
 {

  val=hx711.read()/1000;  //Calibrating by replacing the reference value by the current value
  Serial.println("calibrated");
   
  
 }
 
