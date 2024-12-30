package handler

import (
	"net/http"

	"github.com/gin-gonic/gin"
)

func TestProductHandler(c *gin.Context) {
	c.JSON(http.StatusOK, gin.H{"message": "API working ok!"})
}

func CreateProductHandler(c *gin.Context) {
	c.JSON(http.StatusOK, gin.H{"message": "Create product"})
}

func DeleteProductHandler(c *gin.Context) {
	c.JSON(http.StatusOK, gin.H{"message": "Delete Product"})
}

func UpdateProductHandler(c *gin.Context) {
	c.JSON(http.StatusOK, gin.H{"message": "Update Product"})
}

func ShowProductHandler(c *gin.Context) {
	c.JSON(http.StatusOK, gin.H{"message": "Get Product"})
}

func ListProductHandler(c *gin.Context) {
	c.JSON(http.StatusOK, gin.H{"message": "List Products"})
}
