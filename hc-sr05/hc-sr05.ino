#define trigPin 13
#define echoPin 12
#define trigPin1 6
#define echoPin1 7
void setup() {
  Serial.begin (9600);
  pinMode(trigPin, OUTPUT);
  pinMode(echoPin, INPUT);
  pinMode(trigPin1, OUTPUT);
  pinMode(echoPin1, INPUT);
 }

void loop() {
  long duration, distance,duration1,distance1;
  digitalWrite(trigPin, LOW);
   digitalWrite(trigPin1, LOW);// Added this line
  delayMicroseconds(2); // Added this line
  digitalWrite(trigPin, HIGH);
  digitalWrite(trigPin1, HIGH);
  delayMicroseconds(10); // Added this line
  digitalWrite(trigPin, LOW);
  digitalWrite(trigPin1, LOW);
  duration = pulseIn(echoPin, HIGH);
  duration1 = pulseIn(echoPin, HIGH);
  distance = (duration/2) / 29.1;
  distance1 = (duration/2) / 29.1;
   if (distance >= 200 || distance <= 0){
    Serial.println("Out of range for sensor 1st");
  }
  else {
     Serial.print("distance of 1st sensor");
    Serial.print(distance);
    Serial.println(" cm");
  }
  delay(500);
  if (distance1 >= 200 || distance1 <= 0){
    Serial.println("Out of range for sensor 2nd ");
  }
  else {
    Serial.print("distance of 2nd sensor");
    Serial.print(distance1);
    Serial.println(" cm");
  }
  delay(500);
}
