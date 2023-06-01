# Tiny URL

```
-- It is a URL shortener implementation that utilizes base 62 encoding and a snowflake ID generator.
-- It provides a RESTful API with GET and POST methods for shortening and redirecting URLs.
-- It aims to generate short URLs with 8 characters length, allowing for a large number of unique URLs.
```

### URL Generation
```
It generates short URLs using a combination of base 62 encoding
and a snowflake ID generator.
Base 62 encoding allows for a larger character set compared to traditional base 10 encoding, enabling more compact representations of numbers.
With a short URL length of 8 characters, there are a total of 62^8 (218,340,105,584,896) possible combinations.
```

### RestFul API Description
Method: POST 

Endpoint: /api/v1/shorten

Status Code: 200

Request:
````
{
    "longUrl" : "www.airbnb.com"
}
````

Response:
```
{
  "shortUrl": "tiny.url/1zAx7"
}
```

Method GET 

Endpoint: /api/v1/redirect

Status code: 302

Request:
```
{
    "shortUrl" : "tiny.url/1zAx7"
}
```

Response:
```
{
  "longUrl": "www.airbnb.com"
}
```







