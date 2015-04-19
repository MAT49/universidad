class MainController < ApplicationController
  def index
	#@mult = Two.first * Two.second
  end
  
  def result
	@value1 = params[:value1].to_i
	@value2 = params[:value2].to_i
	#@value3 = value1 * value2
	
  end
end
