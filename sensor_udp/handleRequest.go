package main

import (
	"bytes"
	"encoding/json"
	"fmt"
	"log"
	"net"
	"os"
)

func handleRequest(conn *net.UDPConn, data sensorData) sensorData {
	p := make([]byte, 4096)
	length, addr, err := conn.ReadFromUDP(p[:])
	if err != nil {
		panic(err)
	}

	request := requestData{}
	err = json.Unmarshal(p[0:length], &request)
	if err != nil {
		fmt.Printf("Bad Request! : %v \n", request)
	}

	switch request.Request {
	case "getData":
		{
			fmt.Printf("Got request to send data from %v... \n", addr)
			data = randomData()

			reply := replyData{Uuid: request.Uuid, Time: request.Time, SensorData: data}

			jsonReply := new(bytes.Buffer)
			err := json.NewEncoder(jsonReply).Encode(reply)
			if err != nil {
				panic(err)
			}

			_, err = conn.Write(jsonReply.Bytes())
			if err != nil {
				log.Fatal(err)
			}
		}
	case "close":
		{
			str := "Shutdown Sensor"
			data := []byte(str)

			_, err = conn.Write(data)
			if err != nil {
				log.Fatal(err)
			}
			fmt.Printf("Shutdown Sensor by request: %v... \n", request)
			os.Exit(1)
		}
	default:
		fmt.Printf("No such request: %v... \n", request)
	}

	return data
}
