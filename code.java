#include <LiquidCrystal.h>

int inches = 0;
int cm = 0;


LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

void setup() {
  
  lcd.begin(16, 2);
 
  lcd.setCursor(2, 0);                   	

  lcd.print("Projeto CanSat");               
  
  lcd.setCursor(0, 1);
  
  lcd.print("Fillipy Monteiro");
  
  delay(2000); 
  
  pinMode(7, INPUT);
}

void loop() {
  lcd.clear();
  
  cm = 0.01723 * readUltrasonicDistance(7);
  
  lcd.setCursor(0, 0);                   	

  lcd.print("Distancia em"); 
  
  lcd.setCursor(0, 1);
 
  lcd.print("Centimetro: ");
  
  lcd.print(cm);
  
  delay(1000);
}
long readUltrasonicDistance(int pin)
{
  
  pinMode(pin, OUTPUT);
  digitalWrite(pin, LOW);
  delayMicroseconds(2);
 
  digitalWrite(pin, HIGH);
  delayMicroseconds(10);
  digitalWrite(pin, LOW);
  pinMode(pin, INPUT);
  
  return pulseIn(pin, HIGH);
}
