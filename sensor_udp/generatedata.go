package main

import (
	"fmt"
	"math/rand"
	"strconv"
)

func randomData() sensorData {

	data := sensorData{}

	min := 10
	max := 30

	sund := strconv.Itoa(rand.Intn(max-min) + min)
	temp := strconv.Itoa(rand.Intn(max-min) + min)
	hum := strconv.Itoa(rand.Intn(max-min) + min)

	data.Sundensity = sund
	data.Temperature = temp
	data.Humidity = hum

	fmt.Printf("Sensor values: ( temperature: %v ) ( humidity: %v ) ( sudensity: %v )\n", temp, hum, sund)

	return data
}

func incrementData(oldData sensorData) sensorData {

	data := sensorData{}

	oldsund, _ := strconv.Atoi(oldData.Sundensity)
	oldtemp, _ := strconv.Atoi(oldData.Temperature)
	oldhum, _ := strconv.Atoi(oldData.Humidity)

	sund := strconv.Itoa(oldsund + 1)
	temp := strconv.Itoa(oldtemp + 1)
	hum := strconv.Itoa(oldhum + 1)

	data.Sundensity = sund
	data.Temperature = temp
	data.Humidity = hum

	fmt.Printf("Sensor values: ( temperature: %v ) ( humidity: %v ) ( sudensity: %v )\n", temp, hum, sund)

	return data
}
