#!/usr/bin/python
import re
file = open('Number_example', 'r')
#reads file
text = file.read()
file.close()

#replaces number with words
text = re.sub('[1]', 'one', text)
text = re.sub('[2]', 'two', text)
text = re.sub('[3]', 'three', text)
text = re.sub('[4]', 'four', text)
text = re.sub('[5]', 'five', text)
text = re.sub('[6]', 'six', text)
text = re.sub('[7]', 'seven', text)
text = re.sub('[8]', 'eight', text)
text = re.sub('[9]', 'nine', text)
text = re.sub('[0]', 'zero', text)

#saves the file
outFile = open('Number.txt', 'w')
outFile.write(text)
outFile.close()