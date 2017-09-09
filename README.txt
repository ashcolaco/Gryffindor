              #############################	Team GRYFFINDOR	   ##########################

Problem statement: The project is to help ease the traffic situation in Bnagalore to help emergency vehicles easy passage.
		   The app lifts the current location and destination as of now and sends it to Firebase. It is then retrieved
		   from Firebase to the Raspberry Pi which ultimately controls the traffic signal
		   

Traffic Run Final- holds the apk which gets the current location and destination as of now.

py.py (beta version)- is the application expected to run the traffic lights deriving data from firebase through vncserver.

default.py- emulates default working of traffic signals untill and unless a command (file) is received from the traffic run 	    
            app and executes py.py when received

Problem components yet to be completed: Retieving data using the Raspberry pi.
					Establishing a definite route for controlling the Raspberry pi.(As of now just based on shortest distance).