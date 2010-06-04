#! /bin/bash

source ../config.sh


ARGC=$#
ARGV=$@


if [ $ARGC != 0 ]; then
  echo "Usage: ./startIndexGateway.sh"
  echo "Example: ./startIndexGateway.sh"
  exit 2;
fi

NETWORK=$1

echo MAVEN_OPTS=\"-Xms$META_SERVICE_GATEWAY_XMS -Xmx$META_SERVICE_GATEWAY_XMX -XX:PermSize=$META_SERVICE_GATEWAY_PERM\" mvn jetty:run-exploded -DmetaService.external.host=$META_SERVICE_ADDRESS -DmetaService.external.port=$META_SERVICE_PORT -DmetaService.internal.host=$PRIVATE_NW_PREFIX.$METASERVICE_NW.$GATEWAY_IP -DmetaService.internal.port=$META_SERVICE_PORT
echo MAVEN_OPTS="-Xms$META_SERVICE_GATEWAY_XMS -Xmx$META_SERVICE_GATEWAY_XMX -XX:PermSize=$META_SERVICE_GATEWAY_PERM" mvn jetty:run-exploded -DmetaService.external.host=$META_SERVICE_ADDRESS -DmetaService.external.port=$META_SERVICE_PORT -DmetaService.internal.host=$PRIVATE_NW_PREFIX.$METASERVICE_NW.$GATEWAY_IP -DmetaService.internal.port=$META_SERVICE_PORT
