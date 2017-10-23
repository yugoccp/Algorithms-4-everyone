<?php

function quickSort(array $array): array
{
  $length = count($array);
  
  if ($length <= 1){
    return $array;
  }
	
  $firstItem = $array[0];

  $left = $right = array();

  for ($i = 1, $len = count($array); $i < $len; $i++) {
    if ($array[$i] < $firstItem) {
      $left[] = $array[$i];
    } else {
      $right[] = $array[$i];
    }
  }

  // use recursion to now sort the left and right lists
  return array_merge(quickSort($left), array($firstItem), quickSort($right));
}


$unsorted = array(36, 48, 50, 52, 51, 90, 126, 401, 2, 60);

print("Unsorted:" . PHP_EOL);
print_r($unsorted);

print(PHP_EOL . "Sorted:" . PHP_EOL);
$sorted = quickSort($unsorted);
print_r($sorted);
