CREATE TABLE orders
(
   id BIGSERIAL PRIMARY KEY  NOT NULL,
   tracking_number varchar(255) UNIQUE NOT NULL,
   items jsonb
);

