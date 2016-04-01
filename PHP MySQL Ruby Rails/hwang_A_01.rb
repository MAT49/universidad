# hwang_A_01.rb
#
# input: 3 names, on separate lines, from keyboard
# 
# output: input of names in alphabetical order, no arrays.

puts "Please input the name"
name1 = gets.chomp

puts "Please input the name"
name2 = gets.chomp

puts "Please input the name"
name3 = gets.chomp


if (name1 <=> name2) < 0
	if (name1 <=> name3) < 0
		puts name1
		if (name2 <=> name3) < 0
			puts name2
			puts name3
		else
			puts name3
			puts name2
		end	
	else
		puts name3
		puts name1
		puts name2
	end
else
	if (name2 <=> name3) < 0
		puts name2
		if (name1 <=> name3) < 0
			puts name1
			puts name3
		else
			puts name3
			puts name1
		end	
	else
		puts name3
		puts name2
		puts name1		
	end
end