package main

import (
	"fmt"
	"log"
	"net"
	"strconv"
)

func setupGateway(cfg Cfg) (Cfg, *net.UDPConn) {
	println("Sensor is starting up...")

	addr, err := net.ResolveUDPAddr("udp4", ":"+strconv.Itoa(cfg.Gateway.Port))

	conn, err := net.DialUDP("udp", nil, addr)

	if err != nil {
		panic(err)
	}

	str := "Sensor Startup"
	data := []byte(str)

	fmt.Printf("Initaial communication with gateway: %v \n", str)

	localAddr := conn.LocalAddr().(*net.UDPAddr)
	cfg.Sensor.Ip = localAddr.IP.String()
	cfg.Sensor.Port = localAddr.Port

	_, err = conn.Write(data)
	if err != nil {
		log.Fatal(err)
	}

	return cfg, conn
}
