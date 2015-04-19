json.array!(@ints) do |int|
  json.extract! int, :id, :num
  json.url int_url(int, format: :json)
end
