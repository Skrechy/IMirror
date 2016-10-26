#!/usr/bin/python

import sys
import os
import errno
import time
import Adafruit_DHT

year = time.strftime('%Y')
monthname = time.strftime('%B')
month = time.strftime('%m')

filename = year + '-' + month + '.temperature.txt'
path = year + os.sep + monthname + os.sep + filename

print(path)

# Try to grab a sensor reading.  Use the read_retry method which will retry up
# to 15 times to get a sensor reading (waiting 2 seconds between each retry).
humidity, temperature = Adafruit_DHT.read_retry(Adafruit_DHT.DHT11, 17)

# Un-comment the line below to convert the temperature to Fahrenheit.
# temperature = temperature * 9/5.0 + 32

# Note that sometimes you won't get a reading and
# the results will be null (because Linux can't
# guarantee the timing of calls to read the sensor).
# If this happens try again!
if temperature is not None :
    #print('Temp={0:0.1%f}*'.format(temperature))
    s = time.strftime('%d_%H:%M;')
    s += "{:.2f}".format(temperature)
    s += "\n"

    if not os.path.exists(os.path.dirname(filename)):
        try:
            os.makedirs(os.path.dirname(filename))
        except OSError as exc: # Guard against race condition
            if exc.errno != errno.EEXIST:
                raise
                with open(filename, "w") as f:
                    f.write(s)

else:
    print('Failed to get reading. Try again!')
    sys.exit(1)

f.close()
