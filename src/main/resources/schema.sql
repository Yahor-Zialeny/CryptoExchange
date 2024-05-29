CREATE TABLE IF NOT EXISTS transactions (
    id int PRIMARY KEY,
    exchangeFromCurrency VARCHAR(255) NOT NULL,
    amountSell DOUBLE NOT NULL,
    amountBuy DOUBLE NOT NULL,
    iban VARCHAR(255) NOT NULL,
    createdAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

