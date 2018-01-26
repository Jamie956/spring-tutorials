url: localhost:8084/token
post:
{
	"userName": "tomcat",
	"role": "user"
}
return:
eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0b21jYXQiLCJ1c2VySWQiOiIwIiwicm9sZSI6InVzZXIifQ.050kFh9-nbxg0-r625bDOiyi47J8xH96KDVaHMVVFHCNzbbttuTTmd5BOa8qS8nca0H4C88kbXDinyGFHRwhSA

url: localhost:8084/rest/music
get
header:
[{"key":"Authorization","value":"token  eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0b21jYXQiLCJ1c2VySWQiOiIwIiwicm9sZSI6InVzZXIifQ.050kFh9-nbxg0-r625bDOiyi47J8xH96KDVaHMVVFHCNzbbttuTTmd5BOa8qS8nca0H4C88kbXDinyGFHRwhSA","description":""}]