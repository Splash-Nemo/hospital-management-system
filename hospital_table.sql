CREATE TABLE admin_data (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL
);

ALTER TABLE hms.hospital_data
ADD COLUMN type VARCHAR(50);

Select * from hms.hospital_data;
