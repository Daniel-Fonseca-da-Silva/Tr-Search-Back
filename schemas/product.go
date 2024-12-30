package schemas

import (
	"time"

	"gorm.io/gorm"
)

type Product struct {
	gorm.Model
	Id    string
	Name  string
	Price int64
}

type ProductResponse struct {
	ID        uint      `json:"id"`
	CreatedAt time.Time `json:"createdAt"`
	UpdatedAt time.Time `json:"updatedAt"`
	DeletedAt time.Time `json:"deletedAt,omitempty"`
	Name      string    `json:"name"`
	Price     int64     `json:"price"`
}
