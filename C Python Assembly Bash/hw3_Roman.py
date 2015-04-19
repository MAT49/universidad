#!/usr/bin/python
import re
file = open('Roman_example', 'r')
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
outFile = open('Roman.txt', 'w')
outFile.write(text)
outFile.close()