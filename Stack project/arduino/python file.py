import serial
import pyautogui
from time import sleep

ser = serial.Serial('/COM3', 9600)
while True:
    p = (ser.readline()).decode()
    sleep(1)
    if (p[:7] == 'forward'):
        print ("working")
        pyautogui.press('w')
    elif (p[:8] == 'backward'):
        print ("working")
        pyautogui.press('s')
    elif (p[:5] == 'right'):
        print ("working")
        pyautogui.press('d')
    elif (p[:4] == 'left'):
        print ("working")
        pyautogui.press('a')
    else :
        print ("stable configuration")
