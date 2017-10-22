module InsertionSort where

sort :: Ord a => [a] -> [a]
sort [] = []
sort (x:xs) = sortedInsert x $ sort xs where
  sortedInsert :: Ord a => a -> [a] -> [a]
  sortedInsert z [] = [z]
  sortedInsert z (y:ys) = if z <= y then z:y:ys else y:(sortedInsert z ys)
