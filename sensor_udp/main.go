package main

import (
	"encoding/json"
	"fmt"
	"os"
)

func main() {
	fmt.Println("Sensor is starting up...")
	config := getConfig()
	fmt.Println("Setup gateway connection...")

	config, conn := setupGateway(config)
	data := randomData()

	for {
		data = handleRequest(conn, data)
	}
}

func getConfig() Cfg {
	file, _ := os.Open("config.json")
	defer file.Close()
	decoder := json.NewDecoder(file)
	config := Cfg{}
	err := decoder.Decode(&config)
	if err != nil {
		fmt.Println("error:", err)
	}
	fmt.Printf("Read config: %v \n", config)
	return config
}
