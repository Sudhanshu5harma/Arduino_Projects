int wait = 10;
int p1 = 2;
int p2 = 3;
int p3 = 4;
char inChar;

void setup() { 
pinMode(p1, OUTPUT);
pinMode(p2, OUTPUT);
pinMode(p3, OUTPUT);
Serial.begin(9600);
}

// the loop routine runs over and over again forever:
void loop() {

digitalWrite(p1, 1); 
digitalWrite(p2, 1);
digitalWrite(p3, 0);
delay(wait); 
digitalWrite(p1, 1); 
digitalWrite(p2, 0);
digitalWrite(p3, 0);
delay(wait);
digitalWrite(p1, 1); 
digitalWrite(p2, 0);
digitalWrite(p3, 1);
delay(wait);
digitalWrite(p1, 0); 
digitalWrite(p2, 0);
digitalWrite(p3, 1);
delay(wait);
digitalWrite(p1, 0); 
digitalWrite(p2, 1);
digitalWrite(p3, 1);
delay(wait);
digitalWrite(p1, 0); 
digitalWrite(p2, 1);
digitalWrite(p3, 0);
delay(wait);
}
