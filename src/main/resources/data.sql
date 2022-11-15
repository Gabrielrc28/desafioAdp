CREATE TABLE IF NOT EXISTS Coin (
ID VARCHAR(255) NOT NULL,
VALUE_COIN VARCHAR(255) NOT NULL,
AMOUNT NUMERIC NOT NULL,
PRIMARY KEY (ID)
);

INSERT INTO Coin (ID, VALUE_COIN, AMOUNT) VALUES (1, 0.01, 100);
INSERT INTO Coin (ID, VALUE_COIN, AMOUNT) VALUES (2, 0.05, 100);
INSERT INTO Coin (ID, VALUE_COIN, AMOUNT) VALUES (3, 0.10, 100);
INSERT INTO Coin (ID, VALUE_COIN, AMOUNT) VALUES (4, 0.25, 100);