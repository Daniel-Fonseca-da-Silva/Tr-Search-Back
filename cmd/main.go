package main

import (
	"github.com/Daniel-Fonseca-da-Silva/Tr-Search-Back/controller"
	"github.com/Daniel-Fonseca-da-Silva/Tr-Search-Back/db"
	"github.com/Daniel-Fonseca-da-Silva/Tr-Search-Back/repository"
	"github.com/Daniel-Fonseca-da-Silva/Tr-Search-Back/usecase"
	"github.com/gin-gonic/gin"
)

func main() {
	server := gin.Default()

	dbConnection, err := db.ConnectDB()
	if err != nil {
		panic(err)
	}

	// Layer repository
	ProductRepository := repository.NewProductRepository(dbConnection)

	// Layer usercase
	ProductUseCase := usecase.NewProductUsecase(ProductRepository)

	// Layer controller
	ProductController := controller.NewProductController(ProductUseCase)

	server.GET("/ping", func(c *gin.Context) {
		c.JSON(200, gin.H{"message": "pong"})
	})

	server.GET("/products", ProductController.GetProducts)
	server.POST("/product", ProductController.CreateProduct)
	server.GET("/product/:productId", ProductController.GetProductById)

	server.Run(":8000")
}
