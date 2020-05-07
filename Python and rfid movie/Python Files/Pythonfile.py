import serial
import webbrowser

n1 = "090096E07708"
n2 = "090096E8E691"
n3 = "8400CE408A80"

dat = serial.Serial("COM6",9600)


while(1==1):
    inp = (dat.readline().strip())
    ID = inp.decode("utf-8")
    print (ID)
    if ID=='090096E07708':
        webbrowser.open('https://www.youtube.com/watch?v=v4pi1LxuDHc')
    else:
        print ("TRY AGAIN WITH DIFFERENT CARD")
    
