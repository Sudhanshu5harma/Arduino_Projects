


// these constants describe the pins. They won't change:

const int xpin = A0;                  // x-axis of the accelerometer
                  // z-axis (only on 3-axis models)

void setup() {
  // initialize the serial communications:
  Serial.begin(9600);
  
}

void loop() {
  // print the sensor values:
  Serial.print(analogRead(xpin));
  // print a tab between values:
  Serial.print("\t");
 
  Serial.println();
  // delay before next reading:
  delay(100);
}
