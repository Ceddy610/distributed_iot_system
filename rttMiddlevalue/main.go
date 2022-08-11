package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"os"
	"strconv"
)

func main() {
	rttMap := getJson()
	var packageLoss int = 0
	var rttSumValue float64 = 0
	var rttSumCounter float64 = 0
	var rttMiddlevalue float64 = 0
	for _, time := range rttMap {
		if time == "null" {
			packageLoss++
		} else {
			value, err := strconv.ParseFloat(time, 10)
			if err != nil {
				panic(err)
			}
			rttSumValue += value
			rttSumCounter++
		}
	}
	rttMiddlevalue = rttSumValue / rttSumCounter
	rttMiddlevalue /= 1000000

	fmt.Printf("RTT - Mittelwert ist: %v aus %v einträgen, die nicht null enthalten.\n", rttMiddlevalue, rttSumCounter)
	fmt.Printf("Package losses: %v \n", packageLoss)

}

func getJson() map[string]string {
	jsonFile, err := os.Open("../iot_gateway_java/rtt.json")
	// if we os.Open returns an error then handle it
	if err != nil {
		panic(err)
	}
	fmt.Println("Successfully Opened rtt.json")
	// defer the closing of our jsonFile so that we can parse it later on
	defer func(jsonFile *os.File) {
		err := jsonFile.Close()
		if err != nil {

		}
	}(jsonFile)

	byteValue, _ := ioutil.ReadAll(jsonFile)

	var result map[string]string
	err = json.Unmarshal([]byte(byteValue), &result)
	if err != nil {
		panic(err)
	}

	return result
}
