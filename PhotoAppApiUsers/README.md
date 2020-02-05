# HTTP :

POST /users-ws/users HTTP/1.1
Host: 10.6.21.31:8011
Content-Type: application/json
Accept: application/json
Cache-Control: no-cache
Postman-Token: c3008061-e7f0-3340-7aa7-bf1e06f5df50

{
	"firstName":"yashwant",
	"lastName": "kumar",
	"password":"12345678",
	"email":"test@test.com"
}


# Java HTTP 

OkHttpClient client = new OkHttpClient();

MediaType mediaType = MediaType.parse("application/json");
RequestBody body = RequestBody.create(mediaType, "{\n\t\"firstName\":\"yashwant\",\n\t\"lastName\": \"kumar\",\n\t\"password\":\"12345678\",\n\t\"email\":\"test@test.com\"\n}");
Request request = new Request.Builder()
  .url("http://10.6.21.31:8011/users-ws/users")
  .post(body)
  .addHeader("content-type", "application/json")
  .addHeader("accept", "application/json")
  .addHeader("cache-control", "no-cache")
  .addHeader("postman-token", "041ac395-780b-504c-25eb-67cd865dcf09")
  .build();

Response response = client.newCall(request).execute();


# Node native :

var http = require("http");

var options = {
  "method": "POST",
  "hostname": "10.6.21.31",
  "port": "8011",
  "path": "/users-ws/users",
  "headers": {
    "content-type": "application/json",
    "accept": "application/json",
    "cache-control": "no-cache",
    "postman-token": "7579bf72-1d4e-ffa8-27e6-a158bba9f026"
  }
};

var req = http.request(options, function (res) {
  var chunks = [];

  res.on("data", function (chunk) {
    chunks.push(chunk);
  });

  res.on("end", function () {
    var body = Buffer.concat(chunks);
    console.log(body.toString());
  });
});

req.write(JSON.stringify({ firstName: 'yashwant',
  lastName: 'kumar',
  password: '12345678',
  email: 'test@test.com' }));
req.end();



# Node request 

var request = require("request");

var options = { method: 'POST',
  url: 'http://10.6.21.31:8011/users-ws/users',
  headers:
   { 'postman-token': 'f9606c9f-769d-e985-f6fa-f41e27947435',
     'cache-control': 'no-cache',
     accept: 'application/json',
     'content-type': 'application/json' },
  body:
   { firstName: 'yashwant',
     lastName: 'kumar',
     password: '12345678',
     email: 'test@test.com' },
  json: true };

request(options, function (error, response, body) {
  if (error) throw new Error(error);

  console.log(body);
});



# Node Unrest

var unirest = require("unirest");

var req = unirest("POST", "http://10.6.21.31:8011/users-ws/users");

req.headers({
  "postman-token": "164902af-248d-61d9-0bec-55017464cfc5",
  "cache-control": "no-cache",
  "accept": "application/json",
  "content-type": "application/json"
});

req.type("json");
req.send({
  "firstName": "yashwant",
  "lastName": "kumar",
  "password": "12345678",
  "email": "test@test.com"
});

req.end(function (res) {
  if (res.error) throw new Error(res.error);

  console.log(res.body);
});



