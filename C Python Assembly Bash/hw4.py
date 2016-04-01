#!/usr/bin/python

import re
file = open('text_to_use.txt', 'r')
#.lower() replaces all uppercase letters into lowercase
text = file.read().lower()
file.close()

#deletes all which is not lowercase letter, space, return char, or newline char
text = re.sub('[^a-z\ \r\n]+', '', text)
#breaks the whole read file into a list of words
words = list(text.split())

#adds unique words into new list words2
words2 = []
for i in words:
	if (i not in words2):
		words2.append(i)
		
#places each word (string) into separate line
words1 = ('\n'.join(words2))
#saves answer to problem #1 to hw4.ans1.txt file
outFile = open('hw4_ans1.txt', 'w')
outFile.write(words1)
outFile.close()		
		
#sorts by string length from big to small
words2.sort(key = len, reverse = True)

#prints out ten longest words
print '2. the ten longest words in the document are:' + '\n'
for i in range(0, 10):
	print words2[i]	


#uses python dictionary to count frequency
#still not 100% sure how a dictionary works...
#http://programminghistorian.org/lessons/counting-frequencies
freqWords = []
wordCount = {}
for each in words:
    if (each in wordCount):
        wordCount[each] += 1
    else:
        wordCount[each] = 1
		
#sorts from big counter values to small counter values
freqWords = sorted(wordCount, key = wordCount.get, reverse = True)

#prints 100 most frequent words 
hundred = freqWords[0:100]
print '\n' + '3. the hundred most frequent words in the document are:' + '\n'
print hundred