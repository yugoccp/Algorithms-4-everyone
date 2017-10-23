def LinearSearch(list, value)
    list.each_with_index do |item, index|
        if item === value
            return index
        end
    end
    return -1;
end

arr = [1, 7, 5, 3, 13, 2]
puts LinearSearch(arr, 5)