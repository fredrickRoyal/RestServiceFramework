source ./config.sh

URL=http://localhost:8080/api/racks/$1
echo "accessing $URL"
curl -H "$HEADERS" -D - $URL
echo ""
