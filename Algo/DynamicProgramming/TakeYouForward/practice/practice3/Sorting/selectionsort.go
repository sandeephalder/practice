package main

import "fmt"

func swap2(src int, dest int, arr [8]int) [8]int {
	temp := arr[src]
	arr[src] = arr[dest]
	arr[dest] = temp
	return arr
}

func main2() {
	fmt.Print(" Selection Sort")
	array := [8]int{8, 4, 2, 5, 1, 6, 3, 9}
	n := len(array)

	for i := 0; i < n; i++ {
		max := i
		for j := i; j < n; j++ {
			if array[j] > array[max] {
				max = j
			}
		}
		array = swap(max, i, array)
	}
	fmt.Print(array)
}
