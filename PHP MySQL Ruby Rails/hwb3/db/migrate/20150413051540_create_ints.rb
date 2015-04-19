class CreateInts < ActiveRecord::Migration
  def change
    create_table :ints do |t|
      t.integer :num

      t.timestamps
    end
  end
end
