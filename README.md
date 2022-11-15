## Endpoint para converter para troco.

- Mais moedas:
```
curl --location --request POST 'localhost:8080/changes-controller/more-change/20'
```
- Menos moedas:
```
curl --location --request POST 'localhost:8080/changes-controller/less-change/20'
```

## Endpoint para adicionar ou remover moedas.

- Para adicionar moedas:
```
curl --location --request POST 'localhost:8080/back-office/update-coin' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": "1",
    "amount": 200
}'
```

- Para remover moedas:
```
curl --location --request POST 'localhost:8080/back-office/update-coin' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": "1",
    "amount": -200
}'
```

- Valores de moeda padrão:

| Moedas        | ID     | Quantidade  |
| ------------- |:------:| -----:|
| 0,25          | 4      | 100 |
| 0,10          | 3      |   100 |
| 0,05          | 2      |    100 |
| 0,01          | 1      |    100 |
