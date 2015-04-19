json.array!(@names) do |name|
  json.extract! name, :id, :name1, :name2, :name3
  json.url name_url(name, format: :json)
end
