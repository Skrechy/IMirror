########################################################
# this file handle the folder structure
#
# renews the the file description for services
# to start a new capture file
#
# Author: Mikko Eberhardt
#
##########################################################

import time
import sys

f = file('data.txt', 'r+')

i = 0;

for line in f:
    line = line.rstrip()
    print(line)
    if line == '#temperature':
        i = 1;
    elif i == 1:
        i = 0
        f.write('test')
