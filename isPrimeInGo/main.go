package main

import (
	"bufio"
	"fmt"
	"io"
	"log"
	"os"
	"strconv"
)

func openFile(name string) io.Reader {
	// open file
	file, err := os.Open(name)
	if err != nil {
		log.Fatal(err)
	}
	return file
}
func isPrime() {

	// read the file line by line using scanner
	file := openFile("numbers.txt")
	scanner := bufio.NewScanner(file)
	for scanner.Scan() {

		strVar := scanner.Text()
		number, _ := strconv.Atoi(strVar)
		var primcount = 0
		for i := 2; i < number; i++ {
			if number%i == 0 {
				primcount++
				break
			}
		}
		if primcount == 0 && number != 1 {
			fmt.Println(number, "is a Prime Number")
		} else {
			fmt.Println(number, "is Not a Prime Number")
		}
	}
	if err := scanner.Err(); err != nil {
		log.Fatal(err)
	}
}

func main() {
	isPrime()
}
