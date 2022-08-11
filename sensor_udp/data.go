package main

type sensorData struct {
	Temperature string `json:"temperature"`
	Humidity    string `json:"humidity"`
	Sundensity  string `json:"sundensity"`
}

type requestData struct {
	Uuid    string `json:"uuid"`
	Time    string `json:"time"`
	Request string `json:"request"`
}

type replyData struct {
	Uuid       string     `json:"uuid"`
	Time       string     `json:"time"`
	SensorData sensorData `json:"sensorData"`
}

type sensorCfg struct {
	Ip   string `json:"ip"`
	Port int    `json:"port"`
	Name string `json:"name"`
}

type gatewayCfg struct {
	Ip   string `json:"ip"`
	Port int    `json:"port"`
}

type Cfg struct {
	Sensor  sensorCfg  `json:"sensor"`
	Gateway gatewayCfg `json:"gateway"`
}
