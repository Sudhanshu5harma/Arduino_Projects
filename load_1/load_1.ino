
#include "HX711.h"

// HX711.DOUT   - pin #A1
// HX711.PD_SCK   - pin #A0

HX711 scale(A1, A0);      // parameter "gain" is ommited; the default value 128 is used by the library
HX711 scale1(A3, A2);           // parameter "gain" is ommited; the default value 128 is used by the library

void setup() {
  float cal1=0;
  float cal2=0;
  
  Serial.begin(9600);
  //Serial.println("HX711 x 2 ");
  
  
  
  scale.set_gain(128);
  scale1.set_gain(128); 
  

  Serial.println("Before setting up the scale:");
  Serial.print("read scale 0: \t\t");
  Serial.println(scale.read());         // print a raw reading from the ADC
  Serial.print("read scale 1: \t\t");
  Serial.println(scale1.read());         // print a raw reading from the ADC

  Serial.print("read average scale 0: \t\t");
  Serial.println(scale.read_average(20));     // print the average of 20 readings from the ADC
  
  Serial.print("read average scale 1: \t\t");
  Serial.println(scale1.read_average(20));     // print the average of 20 readings from the ADC

  Serial.print("get value scale 0: \t\t");
  Serial.println(scale.get_value(5));      // print the average of 5 readings from the ADC minus the tare weight (not set yet)
  
  Serial.print("get value scale 1: \t\t");
  Serial.println(scale1.get_value(5));      // print the average of 5 readings from the ADC minus the tare weight (not set yet)

  Serial.print("get units scale 0: \t\t");
  Serial.println(scale.get_units(5), 1);   // print the average of 5 readings from the ADC minus tare weight (not set) divided 
                  // by the SCALE parameter (not set yet) 
  Serial.print("get units scale 1: \t\t");
  Serial.println(scale1.get_units(5), 1);   // print the average of 5 readings from the ADC minus tare weight (not set) divided 
                  // by the SCALE parameter (not set yet)
  
  Serial.println("Calibrating HX711 1");
  scale.set_scale();
  scale.tare();   
  Serial.println("Put 1000g over LC #1");
  delay(5000);
  cal1=scale.get_units(10);
  scale.set_scale(cal1/1000);
  Serial.print("Calibration value : ");
  Serial.println (cal1/1000);
  
  Serial.println("Calibrating HX711 2");
  delay(2000);
  
  scale1.set_scale();
  scale1.tare();   
  Serial.println("Put 1000g over LC #2");
  delay(5000);
  cal2=scale1.get_units(10);
  scale1.set_scale(cal2/1000);
  
  Serial.print("Calibration value: ");
  Serial.println (cal2/1000);
  
  
  scale.set_gain(128);  
  scale.read();
  scale.set_scale(107.f);
  scale.tare();
  
  scale1.set_gain(128);
  scale1.read(); 
  scale1.set_scale(107.f);
  scale1.tare();
  
  
  /*
  scale.set_gain(32);
  scale.read();  
  scale.set_scale(107.f);
  scale.tare();
  
  scale1.set_gain(32);
  scale1.read(); 
  scale1.set_scale(107.f);
  scale1.tare();
  
  scale.set_gain(128);
  scale1.set_gain(128); 
  scale.read();
  scale1.read();

  */
  
  Serial.println("After setting up the scale:");

  Serial.print("read scale 0: \t\t");
  Serial.print(scale.read());                 // print a raw reading from the ADC
  
  Serial.print("\t read scale 1: \t\t");
  Serial.println(scale1.read());

  Serial.print("read average scale 0: \t\t");
  Serial.print(scale.read_average(20));       // print the average of 20 readings from the ADC
  
  Serial.print("\t read average scale 1: \t\t");
  Serial.println(scale1.read_average(20));       // print the average of 20 readings from the ADC

  Serial.print("get value scale 0: \t\t");
  Serial.print(scale.get_value(5));      // print the average of 5 readings from the ADC minus the tare weight, set with tare()
  
  Serial.print("\t get value scale 1: \t\t");
  Serial.println(scale1.get_value(5));      // print the average of 5 readings from the ADC minus the tare weight, set with tare()

  Serial.print("get units scale 0: \t\t");
  Serial.print(scale.get_units(5), 1);        // print the average of 5 readings from the ADC minus tare weight, divided 
                  // by the SCALE parameter set with set_scale

  Serial.print("\t get units scale 1: \t\t");
  Serial.println(scale.get_units(5), 1);        // print the average of 5 readings from the ADC minus tare weight, divided 
                  // by the SCALE parameter set with set_scale

  Serial.println("Readings:");
  
}

void loop() {
//  Serial.print("one reading scale 0:\t");
//  Serial.print(scale.get_units(), 1);

  scale.set_gain(128);
  scale1.set_gain(128); 
  delay(100);  
  float A = scale.get_units(10);
  float B = scale1.get_units(10);
  
  /*
  scale.set_gain(32);
  scale1.set_gain(32);  
  delay(100);
  float C = scale.get_units(10);
  float D = scale1.get_units(10);
  */
    
  Serial.print("\t A:\t");
  Serial.print(A, 1);
  Serial.print("\t B:\t");
  Serial.print(B, 1);
  
  /*
  Serial.print("\t C:\t"); 
  Serial.print(C, 1);
  Serial.print("\t D:\t");
  Serial.print(D, 1);  
  */
  
  Serial.print("\t Weight: \t");
  Serial.println((A+B), 1);

  Serial.print("\t Pos:\t");
  if ((A+B)>500)
    {
    Serial.println((A*10-B*10)/(A+B), 1);
    }
  else 
    {
    Serial.println(0, 1);
    }
  

  //scale.power_down();                 // put the ADC in sleep mode
  //scale1.power_down();
  //delay(500);
  //scale.power_up();
  //scale1.power_up();
}

