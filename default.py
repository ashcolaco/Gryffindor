# -*- coding: utf-8 -*-
"""
Created on Sat Sep  9 07:27:22 2017


# comments will be available soon #
# for raspberry pi 3 #
"""

from subprocess import call
import RPi.GPIO as GPIO
from time import sleep 

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)

red = 14
yellow = 15
green = 18


GPIO.setup(red, GPIO.OUT)
GPIO.setup(yellow, GPIO.OUT)
GPIO.setup(green, GPIO.OUT)

class information:
    status=0
    priority=0
    distance=0
    
    def writestatus( value ):
        status = value
    def getstatus( ):
        return status  
    def getdist():
        return distance
    def getprior():
        return priority
        
        
# normal behaviour

while True:
    info = open("FILE_NAME","rb")
    if ( info.getstatus() == True ):
        call("sudo python emerg.py")
        exit()
    GPIO.output(red,True)
    sleep(30)
    GPIO.output(red,False)
    GPIO.output(yellow,True)
    sleep(3)
    GPIO.output(yellow,False)
    GPIO.output(green,True)
    sleep(15)



