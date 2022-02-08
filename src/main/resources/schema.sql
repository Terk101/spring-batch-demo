CREATE TABLE address (
    id   INTEGER   NOT NULL AUTO_INCREMENT,
    houseNo VARCHAR(120),
    street VARCHAR(120),
    soi VARCHAR(120),
    PRIMARY KEY (id)
);

CREATE TABLE CompanyH2 (
    id   INTEGER   NOT NULL AUTO_INCREMENT,
    CName varchar(255) PRIMARY KEY,
    StockPrice DECIMAL,
    Country varchar(255)
);

CREATE TABLE ProductH2 (
    PName varchar(255) PRIMARY KEY,
    Price DECIMAL,
    Category varchar(255),
    Manufacturer varchar(255),
    FOREIGN KEY (Manufacturer) REFERENCES CompanyH2(CName)
);

CREATE TABLE PurchaseH2 (
    id varchar(255) PRIMARY KEY AUTO_INCREMENT,
    product varchar(255) NOT NULL,
    buyer varchar(255) NOT NULL,
    FOREIGN KEY (product) REFERENCES ProductH2(PName)
);




