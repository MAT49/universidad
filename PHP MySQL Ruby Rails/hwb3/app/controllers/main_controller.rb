class MainController < ApplicationController
  def index
	#@ints = Int.find(:all, :conditions => “name like #{params[:name]}”)	
  end
  
  def result
    @number = params[:number].to_i   
	
    @int = Int.new(num: @number)
    @int.save!	  		
	
	@selected_posNums = Int.where(["num > 0", @number]).all
	@selected_negNums = Int.where(["num < 0", @number]).all

   end
   
end
