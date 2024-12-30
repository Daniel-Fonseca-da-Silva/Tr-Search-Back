package router

import (
	"github.com/Daniel-Fonseca-da-Silva/Tr-Search-Back/handler"
	"github.com/gin-gonic/gin"
)

func initializeRoutes(router *gin.Engine) {
	v1 := router.Group("/api/v1")
	{
		v1.GET("/test", handler.TestProductHandler)
		v1.POST("/product", handler.CreateProductHandler)
		v1.DELETE("/product", handler.DeleteProductHandler)
		v1.PUT("/product", handler.UpdateProductHandler)
		v1.GET("/product", handler.ShowProductHandler)
		v1.GET("/products", handler.ListProductHandler)
	}
}
