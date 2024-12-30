package config

import (
	"github.com/Daniel-Fonseca-da-Silva/Tr-Search-Back/schemas"
	"gorm.io/driver/postgres"
	"gorm.io/gorm"
)

func InitializePostgres() (*gorm.DB, error) {
	logger := GetLogger("Postgres")

	// Create DB and connect
	db, err := gorm.Open(postgres.New(postgres.Config{
		DSN:                  "host=localhost user=postgres password=1234 dbname=postgres port=5432 sslmode=disable",
		PreferSimpleProtocol: true, // disables implicit prepared statement usage
	}), &gorm.Config{})
	if err != nil {
		logger.Errorf("Postgres opening error: %v", err)
		return nil, err
	}

	// Migrate the Schema
	err = db.AutoMigrate(&schemas.Product{})
	if err != nil {
		logger.Errorf("Postgres automigration error: %v", err)
		return nil, err
	}

	// Return the DB
	return db, nil

}
