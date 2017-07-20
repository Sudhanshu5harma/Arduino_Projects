int ldr =0,ldr1=1;
int ldrv=0,ldrv1=0; 
void setup() {
  Serial.begin(9600);
  }

void loop() {
 ldrv=analogRead(ldr);
 delay(50);
 ldrv1=analogRead(ldr1);
 Serial.print(ldrv);
 Serial.print("-");
 Serial.println(ldrv1);
 
}
