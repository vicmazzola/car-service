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

create TABLE IF NOT EXISTS rent (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    car_id BIGINT NOT NULL,
    initial_date DATE,
    end_date DATE,
    total_value DECIMAL(10,2),
    FOREIGN KEY (customer_id) REFERENCES customers(id),
    FOREIGN KEY (car_id) REFERENCES cars(id)
);


insert into cars (brand, model, car_year, color, daily_price) values
('Porsche', 'Carrera', 2012, 'Yellow', 100.00);

insert into cars (brand, model, car_year, color, daily_price) values
('Ferrari', 'Testarossa', 1980, 'Red', 500.00);

insert into customers (name, cpf, phone, email) values
('Victor', '47116978844', '11974874744', 'victor@gmail.com');

insert into customers (name, cpf, phone, email) values
('Emilia', '47116978877', '11974874678', 'emilia@gmail.com');

insert into rent(customer_id, car_id, initial_date, end_date, total_value) values
(1, 1, '2026-10-1', '2026-10-15', 1500.00 );

insert into rent(customer_id, car_id, initial_date, end_date, total_value) values
(2, 2, '2026-06-1', '2026-06-15', 2500.00 );