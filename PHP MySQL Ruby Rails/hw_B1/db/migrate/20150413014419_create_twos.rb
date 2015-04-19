class CreateTwos < ActiveRecord::Migration
  def change
    create_table :twos do |t|
      t.integer :first
      t.integer :second

      t.timestamps
    end
  end
end
