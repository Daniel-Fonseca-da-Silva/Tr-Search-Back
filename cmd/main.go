package main

import (
	"github.com/Daniel-Fonseca-da-Silva/Tr-Search-Back/config"
	"github.com/Daniel-Fonseca-da-Silva/Tr-Search-Back/router"
)

var (
	logger *config.Logger
)

// func init() {
// 	err := godotenv.Load("/home/dafon/Study/Tr-Search-Back/.env")
// 	if err != nil {
// 		log.Fatal("Error loading .env file")
// 	}
// }

func main() {

	logger = config.GetLogger("main")

	err := config.Init()
	if err != nil {
		logger.Errorf("Config initilization error: %v", err)
		return
	}

	router.Initialize()

	// dbConnection, err := db.ConnectDB()
	// if err != nil {
	// 	panic(err)
	// }

	// Layer repository
	// ProductRepository := repository.NewProductRepository(dbConnection)

	// Layer usercase
	// ProductUseCase := usecase.NewProductUsecase(ProductRepository)

	// Layer controller
	// ProductController := controller.NewProductController(ProductUseCase)

	// server.GET("/ping", func(c *gin.Context) {
	// 	c.JSON(200, gin.H{"message": "pong"})
	// })

	// server.GET("/products", ProductController.GetProducts)
	// server.POST("/product", ProductController.CreateProduct)
	// server.GET("/product/:productId", ProductController.GetProductById)

	// server.Run(":8000")
}
