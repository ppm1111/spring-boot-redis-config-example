spirng boot 配置 redis, 使用 StringRedisTemplate 和 gson, 將 employee object 轉成 json 存入 redis 裡, key 為 id。
取出的時候用 gson 將json 轉成 employee object。

測試網址：
GET http://localhost:8081/api/employee/?id=1

POST http://localhost:8081/api/employee
{
    "id": "1",
    "name": "test123",
    "age": 10,
    "salary": 1000000
}
