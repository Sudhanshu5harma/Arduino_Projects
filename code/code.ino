
#include <Q2HX711.h>
#include <Keypad.h>
#include <SPI.h>
#include <Adafruit_GFX.h>
#include <Adafruit_PCD8544.h>
#include "thermistor.h"
#include "HardwareSerial.h"

#define NTC_PIN A1

//NTC THERMISTOR Resistance=10000ohms
//Series Resistance=10000ohms

THERMISTOR thermistor(NTC_PIN,10000,3950,10000);

float temp,temp1;

/*LCD DISPLAY PINS
  RST  14;
  CE   15;
  DC   16;
  DIN  17;
  CLk  18;*/

Adafruit_PCD8544 display = Adafruit_PCD8544(18, 17, 16, 15, 14);

const byte ROWS = 4; // Four ROWS

const byte COLS = 3; // Three COLS

char keys[ROWS][COLS] = 
{
  {'1','2','3'},
  {'4','5','6'},
  {'7','8','9'},
  {'*','0','#'}
};

// ROWS
byte rowPins[ROWS] = { 9, 8, 7, 6 };

// COLUMNS
byte colPins[COLS] = { 12, 11, 10 }; 

// Keypad
Keypad kpd = Keypad( makeKeymap(keys), rowPins, colPins, ROWS, COLS );

const byte hx711_data_pin = A2;
const byte hx711_clock_pin = A3;

float val,cal;

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
  
  Serial.begin(9600);
  val=hx711.read()/1000;
  display.begin();

  display.setContrast(20);

  display.display(); 
  delay(2000);
  display.clearDisplay();   // clears the screen and buffer


  display.setTextSize(1);
  display.setTextColor(BLACK);
  display.setCursor(0,0);
  display.println("PRESS 0 to   continue");
  display.display();
  
}

void loop()
{
 char key=kpd.getKey();    //Reading the key from keypad
 if(key)
 {
 Serial.println(key);      
 }
 if(key=='0')
  {
  display.clearDisplay();
  display.setCursor(0,0);
  display.println("1->CALIBRATE"); //Displaying the Options
  display.display();
  display.println("2->WEIGH");
  display.display();
  display.println("3->CHECK TEMPERATURE");
  display.display();
  display.println("4->DENSITY at TEMP 15C");
  display.display();
  } 
  if(key=='2')
  {
  Serial.println(key);
  float w;
  w=weigh();  //Reading the Weight
  char string[10];
  
  
  Serial.println(w);
  display.clearDisplay();

  display.println(dtostrf(w,10,4,string));  //Converting the Weight from floating point to String
  display.display();
  display.println("PRESS 0 to return to MENU");
  display.display();
  }

  else if(key=='1')
  {
  calibrate();  //Calibrating the Scale
  }

  else if(key=='3')
  {
   float temp1;
   temp1=temperature();  //Reading the Temperature from the NTC THERMISTOR
   char string[10];
  
  
  Serial.println(temp1);
  display.clearDisplay();  //Clearing the Display

  display.println(dtostrf(temp1,10,4,string));  //Converting the Temperatute from Floating point to String
  display.display();
  display.println("PRESS 0 to return to MENU");
  display.display();
  }

  else if(key=='4')
  {
  float j=density();
  char string[20];
  display.clearDisplay();
  display.println(dtostrf(j,10,4,string));  //Converting the Density from Floating point to String
  display.display();
  display.println("PRESS 0 to return to MENU");
  display.display();
  
  return; 
  }
}

//Function to Weigh the Object
float weigh()
 {
  float weight=0.00;
  for(int i=0;i<3;i++)   
  {
  cal=hx711.read()/1000;
  weight=weight+(abs(val-cal));   
  delay(50);
  } 
  float w=weight/3;   //Calculating the Avg. Weight
  return w;
 }

//Function to Calibrate the Scale
void calibrate()
 {

  val=hx711.read()/1000;  //Calibrating by replacing the reference value by the current value
  Serial.println("calibrated");
  display.clearDisplay();
  display.println("CALIBRATED");
  display.display();
  display.println("PRESS 0 to return to MENU");
  display.display();
  
 }


//Function to Check the Temperature
float temperature()
{

   temp = thermistor.read();  //Reading the temperature from THERMISTOR  
   temp1=temp/10;
     
   return temp1;

}


//Function to Calculate the Density at 15C
float density()
 {

  
  float w;
  w=weigh();   //Reading the weight of the Object
  
  float current_density=w/1000;float current_temp=temperature(); 
  
  //Calculating the density at 15C using the Natural Density
  
  float cur_den=current_density*1000,k=(((int)current_temp*20+0.5)/20)-15;
  
  float kdensity=(cur_den*(1-(0.000023*k)-(0.00000002*k*k)));
  float BFV,AFV;
  if(kdensity>839)
     BFV=186.9696;
  else
    BFV=0;
  if((kdensity>787.5)&&(kdensity<=839))
    AFV=594.5418;
  else
    AFV=BFV;
  float AAF;
  if((kdensity>770.5)&&(kdensity<=787.5))
    AAF=2680.32;
  else
    AAF=AFV;
  float FINALAF;
  if(kdensity<=770.5)
    FINALAF=346.4228;
  else
    FINALAF=AAF;
  float BFV1,AFV1;
  if(kdensity>839)
    BFV1=0.4862;
  else
    BFV1=0;
  if((kdensity>787.5)&&(kdensity<=839))
    AFV1=0;
  else
    AFV1=BFV1;
  float AAF1;
  if((kdensity>770.5)&&(kdensity<=787.5))
    AAF1=-0.00336312;
  else
    AAF1=AFV1;
  float FINALAF1;
  if(kdensity<=770.5)
    FINALAF1=0.4388;
  else
    FINALAF1=AAF1;
  float H=((FINALAF/(kdensity*kdensity))+(FINALAF1/kdensity));
  float H2;
  if(true&&(kdensity>770.5)&&(kdensity<=787.5))
    H2=(FINALAF/(kdensity*kdensity)+FINALAF1);
  else
    H2=H;
  float K,l,m;
  K=H2*k;
  l=0.8*K;
  m=l*K;
  float n,i;
  n=-K-m;
  i=pow(2.71828,n);
  float j;
  j=kdensity/i;
  
  return j;
  }




