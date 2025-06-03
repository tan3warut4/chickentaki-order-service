
-- Create tables
CREATE TABLE IF NOT EXISTS "menus" (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(1000),
    price INTEGER,
    category VARCHAR(20),
    imageUrl VARCHAR(1000),
    available VARCHAR(20),
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP
);

CREATE TYPE OrderStatus AS ENUM ('PENDING', 'PAID');

CREATE TABLE IF NOT EXISTS "orders" (
    id UUID PRIMARY KEY,
    customerName VARCHAR(255),
    totalPrice INTEGER,
    status OrderStatus,  -- use the ENUM type here
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP
);

CREATE TABLE IF NOT EXISTS "order_items" (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    order_id UUID NOT NULL REFERENCES "orders"(id),
    menu_id UUID NOT NULL REFERENCES "menus"(id),
    quantity INTEGER,
    createdAt TIMESTAMP,
    updatedAt TIMESTAMP
);
