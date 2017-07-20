#include <Keypad.h>

const byte r =4;
const byte c =4;
char keys[r][c] ={
  {'1','2','3','A'},
  {'4','5','6','B'},
  {'7','8','9','C'},
  {'*','0','#','D'},
};
byte rowPins[r] = {2,3,4,5};
byte colmPins[c] = {6,7,8,9};

Keypad keypad =Keypad(makeKeymap(keys), rowPins,colmPins,r,c);

void setup(){
  Serial.begin(9600);
  
}
void loop(){
  char key = keypad.getKey();
  if(key){
    Serial.println(key);
    
  }
}

