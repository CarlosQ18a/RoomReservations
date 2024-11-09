CREATE TABLE IF NOT EXISTS room_reservations (
                                                 id SERIAL PRIMARY KEY,
                                                 room_number VARCHAR(50) NOT NULL,
    type VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    customer VARCHAR(255),
    check_in DATE,
    check_out DATE,
    status VARCHAR(50) NOT NULL
    );

