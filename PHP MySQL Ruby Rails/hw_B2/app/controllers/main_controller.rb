class MainController < ApplicationController
  def index
	
  end
  def result
	@name1 = params[:name1].chomp.downcase.capitalize
	@name2 = params[:name2].chomp.downcase.capitalize
	@name3 = params[:name3].chomp.downcase.capitalize
		
  if (@name1 <=> @name2) < 0
	if (@name1 <=> @name3) < 0
		@nameA = @name1
		if (@name2 <=> @name3) < 0
			@nameB = @name2
			@nameC = @name3
		else
			@nameB = @name3
			@nameC = @name2
		end	
	else
		@nameA = @name3
		@nameB = @name1
		@nameC = @name2
	end
  else
	if (@name2 <=> @name3) < 0
		@nameA = @name2
		if (@name1 <=> @name3) < 0
			@nameB = @name1
			@nameC = @name3
		else
			@nameB = @name3
			@nameC = @name1
		end	
	else
		@nameA = @name3
		@nameB = @name2
		@nameC = @name1		
	end
  end


  end
end
