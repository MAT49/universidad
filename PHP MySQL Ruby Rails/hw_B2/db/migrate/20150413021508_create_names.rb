class CreateNames < ActiveRecord::Migration
  def change
    create_table :names do |t|
      t.string :name1
      t.string :name2
      t.string :name3

      t.timestamps
    end
  end
end
