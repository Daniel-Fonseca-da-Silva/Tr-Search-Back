package main

import (
	"github.com/Daniel-Fonseca-da-Silva/Tr-Search-Back/config"
	"github.com/Daniel-Fonseca-da-Silva/Tr-Search-Back/router"
)

var (
	logger *config.Logger
)

func main() {

	logger = config.GetLogger("main")

	err := config.Init()
	if err != nil {
		logger.Errorf("Config initilization error: %v", err)
		return
	}

	router.Initialize()
}
