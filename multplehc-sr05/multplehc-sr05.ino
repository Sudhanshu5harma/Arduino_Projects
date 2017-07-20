#define trigPin1 13
#define echoPin1 12
#define trigPin2 6
#define echoPin2 7


long duration, distance, fSensor,sSensor;

void setup()
{
Serial.begin (9600);
pinMode(trigPin1, OUTPUT);
pinMode(echoPin1, INPUT);
pinMode(trigPin2, OUTPUT);
pinMode(echoPin2, INPUT);

}

void loop() {
SonarSensor(trigPin1, echoPin1);
fSensor = distance;
SonarSensor(trigPin2, echoPin2);
sSensor = distance;


Serial.print(sSensor);
Serial.print("-");
Serial.println(fSensor);
}

void SonarSensor(int trigPin,int echoPin)
{
digitalWrite(trigPin, LOW);
delayMicroseconds(2);
digitalWrite(trigPin, HIGH);
delayMicroseconds(10);
digitalWrite(trigPin, LOW);
duration = pulseIn(echoPin, HIGH);
distance = (duration/2) / 29.1;

}


