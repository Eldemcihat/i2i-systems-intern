package main

import (
	"bufio"
	"fmt"
	"log"
	"math"
	"os"
	"strconv"
)

func isPrime(num int) string {
	if num < 2 {
		return "\n"
	}

	sq_root := int(math.Sqrt(float64(num)))
	for i := 2; i <= sq_root; i++ {
		if num%i == 0 {
			return "\n"
		}
	}
	return " --> Prime\n"
}

func main() {
	file, err := os.Open("numbers.txt")
	if err != nil {
		log.Fatal(err)
	}

	defer file.Close()

	writefile, err := os.Create("result.txt")
	if err != nil {
		log.Fatal(err)
	}
	defer writefile.Close()

	var finalresults string = ""

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		number, err := strconv.Atoi(scanner.Text())
		if err != nil {
			log.Fatal(err)
		}

		concatenated := fmt.Sprintf("%d%s", number, isPrime(number))
		finalresults = fmt.Sprintf("%s%s", finalresults, concatenated)
	}
	error := os.WriteFile("result.txt", []byte(finalresults), 0644)
	if error != nil {
		log.Fatal(error)
	}
}
