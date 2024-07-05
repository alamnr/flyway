CREATE TABLE orders
(
   id bigint PRIMARY KEY  NOT NULL,
   tracking_number varchar(255) NOT NULL,
   items jsonb
);
CREATE UNIQUE INDEX orders_tracking_number_key ON orders(tracking_number);
