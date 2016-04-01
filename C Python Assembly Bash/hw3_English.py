#!/usr/bin/python
import re
file = open('English_example', 'r')
#reads file
text = file.read()
file.close()

#replaces word with number
text = re.sub('one', '1', text)
text = re.sub('two', '2', text)
text = re.sub('three', '3', text)
text = re.sub('four', '4', text)
text = re.sub('five', '5', text)
text = re.sub('six', '6', text)
text = re.sub('seven', '7', text)
text = re.sub('eight', '8', text)
text = re.sub('nine', '9', text)
text = re.sub('zero', '0', text)

#saves the file
outFile = open('English.txt', 'w')
outFile.write(text)
outFile.close()