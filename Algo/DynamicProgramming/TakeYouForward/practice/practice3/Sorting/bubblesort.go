package main

import "fmt"

func swap1(src int, dest int, arr [8]int) [8]int {
	temp := arr[src]
	arr[src] = arr[dest]
	arr[dest] = temp
	return arr
}

func main1() {
	fmt.Println("Bubble Sort!!")
	arr := [8]int{3, 2, 8, 1, 6, 3, 9, 5}
	n := len(arr)
	for i := 0; i < n; i++ {
		for j := i; j < n; j++ {
			fmt.Printf(" i=%d, j=%d \n", i, j)
			if arr[i] > arr[j] {
				arr = swap(i, j, arr)
			}
		}
	}
	fmt.Print(arr)
}
