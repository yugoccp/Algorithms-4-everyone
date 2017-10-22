def bubble_sort(array)
  swapped = true # This keeps track of when the algo has swapped
  n = array.length - 1 # This is for a later loop

  # The sort
  while swapped do
    swapped = false # Reset the var
    n.times do [i] 
      if array[i] > array[i+1] # Checks if items need swapping
        array[i], array[i+1] = array[i+1], array[i] # Does the swap
        # We have to do the swap on one line so no entry gets overwritten
        # Otherwise we need a third variable to store data temporarily
        swapped = true # Marks the swap
      end
    end
  end
  array # Return the sorted array
end