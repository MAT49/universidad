class Name < ActiveRecord::Base
	validates :name1, :name2, :name3, :presence => true
end
