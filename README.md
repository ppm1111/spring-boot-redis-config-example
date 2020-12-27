spirng boot 配置 redis, 使用 RedisTemplate、keyGenerator、@Cachable、@CacheEvict。

測試網址：

GET http://localhost:8081/api/employees/find/?id=1
取得id = 1 的 employee並快取。

GET http://localhost:8081/api/employees
取得所有employee並快取。

POST http://localhost:8081/api/employee
刪除所有employe的快取。
