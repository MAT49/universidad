class Two < ActiveRecord::Base
	validates :first, :second, :presence => true
end
