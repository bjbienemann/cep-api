FROM postgres:10.5

RUN localedef -i pt_BR -c -f UTF-8 -A /usr/share/locale/locale.alias pt_BR.UTF-8
ENV LANG pt_BR.utf8

COPY restore_db.sh /docker-entrypoint-initdb.d/restore.sh
COPY cep_2012.backup /tmp/cep.backup

RUN chmod 777 /docker-entrypoint-initdb.d && \
chmod 777 /tmp

ENTRYPOINT ["docker-entrypoint.sh"]

EXPOSE 5432
CMD ["postgres"]