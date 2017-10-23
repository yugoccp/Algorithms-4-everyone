package main

import (
    "fmt"
)

func BubbleSort(a []int) {
    for i := 0; i < len(a); i++ {
        for j := 0; j < len(a)-i-1; j++ {
            if a[j] > a[j + 1] {
                t := a[j]
                a[j] = a[j + 1]
                a[j + 1] = t
            }
        }
    }
}

func main() {
    a := []int{8, 6, 7, 5, 3, 0, 9}
    fmt.Println("Elements Before Bubble sort-->", a)
    BubbleSort(a)
    fmt.Println("Elements After Bubble Sort-->", a)
}