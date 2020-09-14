Copy rules directory from _resources_ and place to /tmp <br /> 
<br />cURL to fetch fine for 2 wheelers<br />
`curl --location --request POST 'localhost:8080/fines/vehicles' \
--header 'Content-Type: application/json' \
--data-raw '{
    "speed": 200,
    "vehicle": "4 Wheeler"
}'`

<br/>
cURL to fetch fine for 2 wheelers<br />

`curl --location --request POST 'localhost:8080/fines/vehicles' \
--header 'Content-Type: application/json' \
--data-raw '{
    "speed": 200,
    "vehicle": "4 Wheeler"
}'`


<br/>
cURL to fetch discount on mobile when purchased from HDFC card<br />

`curl --location --request POST 'localhost:8080/orders/discount' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Mobile",
    "cardType": "HDFC",
    "price": "100000"
}'`

<br/>
cURL to fetch discount on mobile when purchased from ICICI card<br />

`curl --location --request POST 'localhost:8080/orders/discount' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name": "Mobile",
    "cardType": "ICICI",
    "price": "100000"
}'`