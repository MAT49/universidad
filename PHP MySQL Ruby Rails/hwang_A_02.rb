# hwang_A_02.rb
#
# input: list of numbers from keyboard
#
# output: 2 lists of numbers, one with input numbers greater than 0, and other with less than 0 
# (ignore 0 valued numbers).  Must first build 2 arrays with required output numbers before displaying.

listOrig = Array.new(1)
listPos = Array.new(1)
listNeg = Array.new(1)

i = 0
puts "Please input a number, enter '-777' when you are finished entering numbers"
listOrig[i] = STDIN.gets.to_i

while listOrig[i] != -777 do
	if listOrig[i] == 0
		next
	elsif listOrig[i] > 0
		listPos << listOrig[i]
	else 
		listNeg << listOrig[i]
	end
	i += 1
	puts "Please input a number, enter '-777' when you are finished entering numbers"
	listOrig[i] = STDIN.gets.to_i
end


listPos.each do |pos|
    puts pos
end
listNeg.each do |neg|
    puts neg	
end