<?php

include "func.php";

// if(isset($_POST["rfid"])){
//     //get the rfid number
//     //get the user id
//     $rfid = $_POST["rfid"];
//     //$userid = getUserId($rfid);
//     $userid=2;
//     addPaymentRequest($userid,$rfid);
//     //add record in the payment table
//     //firebase request to android
// }


//swsguest01
//S!emen$WiFi@2017
//bang_hack_2017

if(isset($_GET["rfid"])){
    //get the rfid number
    //get the user id
    $rfid = $_GET["rfid"];


    switch ($_GET["context"]){
        case "door_unlock":
            //make door unlock in specified area
          echo "RFID".$_GET["rfid"]."rfid authenticated"
            break;
        case "health":
            $health->name = "Mridul";
            $health->bgroup = "B+ve";
            echo json_encode($health); 
            break; 
        case "pay-per-print":
            $doc = $_GET["doc"];
            //will give amount to be deducted from card
            echo "RFID ".$_GET["rfid"]." amount deducted is :40";
            break;
            case"item-inventory":
            $item_code = $_GET["item_code"];
            echo "RFID ".$_GET["rfid"]." item has been taken";
            break;

        case "attendance":
            //get usn 
        $usn = $_GET["usn"];
            //mark attendance
  	echo "RFID ".$_GET["rfid"]." Class Attended";
            break;
            case
        case "payment":
             $amount = $_GET["amount"];
             $vendor = $_GET["vendor"];
             
            //http://192.168.1.6/EasyKey/rfid.php?rfid=1234&context=payment&vendor=abc&amount=12
             echo "Payment done";
    }

//    $userid = getUserId($rfid);
    $userid=1;
     
    //save to db
    //addPaymentRequest($userid,$rfid);
    

    //add record in the payment table
    //firebase request to android
}

function addPaymentRequest($userid,$rfid){
  $c = connectDB();
  $sql = "insert into payment(RFID,user_id) values('".$rfid."',".$userid.")";
//  echo $sql;
  if (executeDB($c,$sql)){
  	echo "We got this covered!";
  	disconnectDB($c);  
  	return 1;
  }
else
    {
    echo "You ran out of luck";
    }
  	disconnectDB($c);
  
}



function getUserEmail($rfid){

	$c = connectDB();
	$sql = "select * from user where rfid='".$rfid."'";
	echo $sql;
	$ret = queryDB($c,$sql);
	while ($row = $ret->fetch_assoc()){
        $id = $row["id"];
        $name = $row["Name"];
		disconnectDB($c);	
		return $id;
	}
	
}

?>
