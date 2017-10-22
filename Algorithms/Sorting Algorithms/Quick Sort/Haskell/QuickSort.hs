module QuickSort where

import Data.List (partition)

sort :: Ord a => [a] -> [a]
sort [] = []
sort [x] = [x]
sort (x:xs) = let (l, r) = partition (x >=) xs in
  (sort l) ++ [x] ++ (sort r) 
