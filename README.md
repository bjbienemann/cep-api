# CEP-API
#### API Rest para localização de endereços por CEP

### Requisitos

* Java 8
* Maven
* Docker
* Docker compose

### Construir

Executar com maven:
<pre><code>./mvnw compile quarkus:dev</code></pre>

### Instalar

Iniciar o serviço com docker compose:
<pre><code>docker-compose up --build -d</code></pre>

Parar o serviço com docker compose:
<pre><code>docker-compose down --volumes</code></pre>

### Especificação

Link para acessar as específicações com swegger-ui:
<pre><code>http://localhost:8080/swagger-ui</code></pre>

### Referência

<https://quarkus.io/get-started/>
<https://github.com/quarkusio/quarkus-quickstarts.git>

