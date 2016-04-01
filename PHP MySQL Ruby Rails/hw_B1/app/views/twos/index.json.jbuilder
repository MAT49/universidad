json.array!(@twos) do |two|
  json.extract! two, :id, :first, :second
  json.url two_url(two, format: :json)
end
