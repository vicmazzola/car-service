create TABLE IF NOT EXISTS cars (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    brand VARCHAR(255),
    model VARCHAR(255),
    car_year INT,
    color VARCHAR(255),
    daily_price DECIMAL(10,2)
);

create TABLE IF NOT EXISTS customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    cpf VARCHAR(255),
    phone VARCHAR(255),
    email VARCHAR(255)
);

insert into cars (brand, model, car_year, color, daily_price) values
('Opel', 'Astra', 2012, 'Black', 100.00);

insert into customers (name, cpf, phone, email) values
('Victor', '47116978844', '11974874744', 'victor@gmail.com');