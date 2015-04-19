#!/bin/bash
: '
multi line comment syntax for future reference
A very challenging exercise for a bash n00b, like as hard as python as a n00b
spent endless hours...
@ author: Ha K Hwang
'
while read line
do
	#strips all punctuations and does not add space
	#then converts uppercase letters into lowercase
	#then turn space into newline, putting each word into each line
	#sorts alphabetically in descending order	
	#http://bashshell.net/shell-scripts/script-find-frequency-of-words-in-a-file/
	#http://ss64.com/bash/sort.html
	#sed -e 's/[[:punct:]]//g' also works for removing punctuations	
	tr -d  [:punct:] | tr [:upper:] [:lower:] | tr -s [:space:] '\n' | sort > hw4_sh.txt	
done < text_to_use.txt

#only keeps one of several same words and counts how many


uniq < hw4_sh.txt > hw4_sh1.txt
#then sorts in descending/reverse count number
#sed ${1:-100}q also displays first 100 lines	
uniq -c < hw4_sh.txt | sort -k 1,1nr -k 2 | sed '100 q' > hw4_sh3.txt 		

#empties out temp text file
truncate -s 0 hw4_sh2_temp.txt	
while read line	
do
	#echo -n disables automatic newline character being added
	#double echo prints ('#of char' 'string') and adds each line to temp text
	echo $(echo -n "$line" | wc -c) "$line" >> hw4_sh2_temp.txt		
done < hw4_sh1.txt		

#sorts in reverse numerical order using the first column (numbers)
#then saves the first 10 elements into text file
sort -rn -k1 < hw4_sh2_temp.txt | head -10 > hw4_sh2.txt