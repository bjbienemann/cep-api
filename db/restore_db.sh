#!/bin/bash
set -e

pg_restore --username "$POSTGRES_USER" \
--no-password \
--dbname "cep" \
--verbose "/tmp/cep.backup"

rm -rf /docker-entrypoint-initdb.d/*
rm -rf /tmp/*
