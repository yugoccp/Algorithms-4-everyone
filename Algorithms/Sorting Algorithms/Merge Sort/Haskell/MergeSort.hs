module MergeSort where

sort :: Ord a => [a] -> [a]
sort [] = []
sort [x] = [x]
sort x = let (l,r) = half x in
  merge (sort l) (sort r) where
  half :: [a] -> ([a], [a])
  half [] = ([], [])
  half y = let halfLength = (length y) `div` 2 in 
    (take halfLength y, drop halfLength y)

  merge :: Ord a => [a] -> [a] -> [a]
  merge [] z = z
  merge z [] = z
  merge zl@(z:zs) wl@(w:ws) = if z <= w then z:(merge zs wl) else w:(merge ws zl)
  
