class Int < ActiveRecord::Base
	validates :num, :presence => true
	
  def add_int(num)
    self.create(:num => 1)
  end
	
	
end
