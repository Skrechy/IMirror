#!/usr/bin/python

import sys
import time
import Adafruit_DHT

#df = file('home/pi/iMirror/data.txt', 'r')
#
#for line in df:
#    line.rstrip()
#    if line == '#temperature':
#        path = df.readLine()
#        print(path)
#        break;

f = file('2016/temperature.txt', 'a')

# Try to grab a sensor reading.  Use the read_retry method which will retry up
# to 15 times to get a sensor reading (waiting 2 seconds between each retry).
humidity, temperature = Adafruit_DHT.read_retry(Adafruit_DHT.DHT11, 17)

# Un-comment the line below to convert the temperature to Fahrenheit.
# temperature = temperature * 9/5.0 + 32

# Note that sometimes you won't get a reading and
# the results will be null (because Linux can't
# guarantee the timing of calls to read the sensor).
# If this happens try again!
if humidity is not None and temperature is not None :
    #print('Temp={0:0.1%f}*'.format(temperature))
    s = time.strftime('%d_%H:%M;')
    s += "{:.2f}".format(temperature) + "\n"
    f.write(s)
    #print(s)
else:
    print('Failed to get reading. Try again!')
    sys.exit(1)

f.close()
