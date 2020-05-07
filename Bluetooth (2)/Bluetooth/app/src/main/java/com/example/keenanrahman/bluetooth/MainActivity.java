package com.example.keenanrahman.bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import android.os.PersistableBundle;

import java.util.UUID;
import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    ListView listviewl1;            //list view object
    Button buttonb1;            //button object
    ArrayAdapter<String> list1;     //contain paired devices name
    public BluetoothAdapter bt1;                //object of bluetooth
    Set<BluetoothDevice> bd1;               //conatin list of all the paired devices
    public BluetoothDevice connectedDevice;             //contain HAPTIKA bluetooth
    TextView number;                            //text view where number are placed
    private BluetoothSocket mmSocket;           //socket for bluetooth
    private BluetoothDevice mmDevice;               //device containing haptika
    private final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");           //uuid used for serial communication
    private BluetoothSocket socket;
    private InputStream mmInStream;             //for input stream
    Thread working;                             //thread built for data receiver
    int readBufferPosition;
    boolean work;
    byte[] buffer;          //contain data received



    @Override
    protected void onCreate(Bundle savedInstanceState) {                //called first when application is created
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);                 //set layout for the application
        firstcall();                    //after setting the layout firstcall() function is called

        if(bt1==null)       //if null so device has no bluetooth supported
        {
            Toast.makeText(getApplicationContext(),"Bluetooth Not Found",Toast.LENGTH_SHORT).show();
            finish();               //and then we goes to finish as we can not continue
        }
        else
        {
            //now we check if bluetooth is enable or not
            if(!bt1.isEnabled())        //if bluetooth is not enabled so it return false and we make it true
            {
                Intent i1 = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);         //request to enable bluetooth, now we have two result either user press yes or no
                startActivityForResult(i1,0);               //on either result we act upon the result and call ON ACTIVITY RESULT FUNCTION
            }
            getPairedDevices();         //call this function to get the paired devices

        }



        try {
            connection();               //after getting paired device connection function is called to connect mobile to HAPTIKA
        } catch (IOException e) {
        }


    }


    //   1.
    //-----------------FIRSTCALL FUNCTION-----------------//

    private void firstcall() {
        buttonb1=(Button)findViewById(R.id.button1);        //initialize button
        listviewl1=(ListView)findViewById(R.id.listView1);      //initialize view
        list1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,0);       //initialize list layout to simple list 1
        listviewl1.setAdapter(list1);               //listview set
        bt1=BluetoothAdapter.getDefaultAdapter();           //bt1 is given the default bluetooth of device -> return null if device has no bluetooth
        number=(TextView)findViewById(R.id.number);             //text view to have number

    }


    /* after the completion of this function we go back to where we called the firstcall() function*/



    //-----------------FIRSTCALL FUNCTION END-------------//




    //    2.
    //---------------------ON ACTIVITY RESULT FUNCTION---------------//

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);  //we get result of the activity
        if(resultCode == RESULT_CANCELED)       //if user press NO to open bluetooth so we go to IF statement
        {
            Toast.makeText(getApplicationContext(),"Can not Continue without Enabling Bluetooth",Toast.LENGTH_LONG).show();
            finish();   //as cant continue without bluetooth on so we go to finish
        }
    }

    // now we go back to oncreate function from where we left
    //---------------------ON ACTIVITY RESULT FUNCTION END-----------//



    //    3.
    //---------------GETPAIREDDEVICES FUNCTION -------------------//

    private void getPairedDevices() {
        boolean check=false;        //initialize to false
        bd1= bt1.getBondedDevices();        //bd1 is a set and we give set the bonded devices of mobile
        if(bd1.size()>0)        //if size > 0 so we have bonded devices
        {
            for (BluetoothDevice devices:bd1)               //loop the set
            {
                list1.add(devices.getName()+"\n");              //add each paired device to the list view
                printTheList();                     //to print the list
                if(  devices.getName().equals("HAPTIKA")     /*devices.getName()=="HAPTIKA"*/)       //to check if haptika is connected to the mobile or not
                {

                    check=true;          //make it true in irder to stop the bottom if to execute
                    connectedDevice=devices;             //save the haptika device to new variable
                    Toast.makeText(getApplicationContext(),"Mobile is Connected To "+connectedDevice.getName(),Toast.LENGTH_LONG).show();
                }
            }
            if(check==false)        //execute only when we dont have haptika in bonded devices
            {
                Toast.makeText(getApplicationContext(),"Please Connect Haptika to your Device",Toast.LENGTH_LONG).show();
            }
        }
    }


    //go back to oncreate function from where we left
    //---------------GETPAIREDDEVICES FUNCTION END----------------//



    //     4.
    //---------------------PRINT THE LIST FUNCTION--------------------//



    //print the list of devices currently paired with mobile
    private void printTheList() {
        ListView listviewl2=(ListView)findViewById(R.id.listView1);
        listviewl2.setAdapter(list1);               //print the paired devices on the list
    }

    //go back to get paired device function from where it is called
    //---------------------PRINT THE LIST FUNCTION END----------------//



    //      5.
    //----------CONNECTION FUNCTION------------------//

    void connection() throws IOException {


        mmDevice = connectedDevice;             //save haptika to mmDevice
        mmSocket = connectedDevice.createRfcommSocketToServiceRecord(MY_UUID);          //provide serial connection socket to mmSocket
        mmSocket.connect();                     //open the socekt
        try {
            mmInStream= mmSocket.getInputStream();              //make socket for input stream
        } catch (IOException e) {
        }
        Toast.makeText(getApplicationContext(),"Connection established",Toast.LENGTH_SHORT).show();

        //now wait for button to be pressed in order to receive data
        buttonb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                dataSender();          //function to receive data from bluetooth

            }
        });
    }

    //----------------CONNECTION FUNCTION END-------------------------------//




    //              6.
    //----------DATA SENDER FUNCTION------------------------//
    //function to receive data

    void dataSender()
    {
        Toast.makeText(getApplicationContext(),"Receiving Data",Toast.LENGTH_SHORT).show();


        final Handler handler = new Handler();          //object of handler
        final byte delimiter = 10; //This is the ASCII code for a newline character

        work = false;
        readBufferPosition = 0;
        buffer = new byte[1024];            //space to hold incoming data
        working = new Thread(new Runnable()             //thread is made
        {
            public void run()
            {
                while(!Thread.currentThread().isInterrupted() && !work)             //work until interrupted
                {
                    try
                    {
                        int bytesAvailable = mmInStream.available();            //to check if data available
                        if(bytesAvailable > 0)
                        {
                            byte[] packetBytes = new byte[bytesAvailable];              //make array of the size of data
                            mmInStream.read(packetBytes);
                            for(int i=0;i<bytesAvailable;i++)
                            {
                                byte b = packetBytes[i];            //receive data
                                if(b == delimiter)          //if newline occur
                                {
                                    byte[] encodedBytes = new byte[readBufferPosition];         //data send to be encoded in ASC code
                                    System.arraycopy(buffer, 0, encodedBytes, 0, encodedBytes.length);          //copy of data is made
                                    final String data = new String(encodedBytes, "US-ASCII");               //converted to ASC code
                                    readBufferPosition = 0;

                                    handler.post(new Runnable()
                                    {
                                        public void run()
                                        {
                                            number.setText(data);               //display the data
                                        }
                                    });
                                }
                                else
                                {
                                    buffer[readBufferPosition++] = b;           //if newline does not occur so continue to receive data
                                }
                            }
                        }
                    }
                    catch (IOException ex)
                    {
                        work = true;            //if exception so get out of while loop
                    }
                }
            }
        });

        working.start();            //start the loop again

    }
    //----------DATA SENDER FUNCTION END------------------//



    void close() throws IOException
    {
        work = true;
        mmInStream.close();
        mmSocket.close();
        number.setText("Bluetooth Closed");
    }
}
