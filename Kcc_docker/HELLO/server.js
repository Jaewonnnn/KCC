const express = require("express");
const redis = require("redis");

const PORT = 8082;
const app = express();

//레디스 클라이언트 생성
const client = redis.createClient({
  host: "redis-server", // 이름
  port: 6379, // 포트
});

client.set("number", 0);

app.get("/", (req, res) => {
  client.get("number", (err, number) => {
    res.send("숫자가 1씩 증가한다. 숫자: " + number);
    client.set("number", parseInt(number) + 1);
  });
});

app.listen(PORT);
console.log("Server is running...");
