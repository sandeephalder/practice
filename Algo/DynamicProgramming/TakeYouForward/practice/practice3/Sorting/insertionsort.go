package main

import "fmt"

func swap(src int, dest int, arr [8]int) [8]int {
	test := arr[src]
	arr[src] = arr[dest]
	arr[dest] = test
	return arr
}

func main() {
	fmt.Print("Insertion Sort")
	arr := [8]int{6, 5, 7, 4, 8, 3, 9, 1}
	n := len(arr)
	for i := 0; i < n-1; i++ {
		for j := i + 1; j > 0; j-- {
			if arr[j-1] < arr[j] {
				arr = swap(j-1, j, arr)
			}
		}
	}
	fmt.Print(arr)
}
