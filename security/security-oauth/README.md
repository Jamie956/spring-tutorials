password:
post -> 
http://localhost:8080/oauth/token?username=user_1&password=123456&grant_type=password&scope=select&client_id=client_2&client_secret=123456
(
username=user_1
password=123456
grant_type=password
scope=select
client_id=client_2
client_secret=123456
)
respond -> 
{
    "access_token": "8bf1f0b7-91c0-4300-9588-aa1ae3832a8e",
    "token_type": "bearer",
    "refresh_token": "0dfb9a53-e839-4ed9-bcb3-5b1ad339717a",
    "expires_in": 43199,
    "scope": "select"
}

client:
post->
http://localhost:8080/oauth/token?grant_type=client_credentials&scope=select&client_id=client_1&client_secret=123456
(
grant_type=client_credentials
scope=select
client_id=client_1
client_secret=123456
)
respond->
{
    "access_token": "e26918db-a680-4e34-9fce-26e74de72091",
    "token_type": "bearer",
    "expires_in": 43199,
    "scope": "select"
}

http://localhost:8080/order/1

http://localhost:8080/product/1

password:
http://localhost:8080/order/1?access_token=e5e5007b-0d67-44bf-9d1d-d00a84f4a5d7

client:
http://localhost:8080/order/1?access_token=56465b41-429d-436c-ad8d-613d476ff322