CREATE TABLE IF NOT EXISTS cars (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(255),
    model VARCHAR(255),
    car_year INT,
    color VARCHAR(255),
    daily_price DECIMAL(10,2)
);

INSERT INTO cars (brand, model, car_year, color, daily_price) VALUES
('Opel', 'Astra', 2012, 'Black', 100.00);