# Case pismo Real 2
### Objetivo

Este projeto faz parte da construção de uma api com Java, Groovy ou Go de acordo com especificações da Pismo.

### Arquitetura

O projeto foi elabora com  o *Spring Boot* + *Groovy* para o microserviço e para o Banco de Dados foi utilizado o *Mysql 5.7*.

### O Spring Boot
A *stack* utilizada no *Spring Boot* foi a seguinte:

1. JPA como camada de persistência;
2. Swagger para documentação e testes das apis;
3. REST como interface de comunicação das apis;
4. Gradle como gestão de build.

### Swagger

Foi incluido o Swagger como parte da documentação no projeto. Basta acessar http://[sua maquina]:8080/swagger-ui.html para visualizar e testar as apis.

### Docker

Este projeto foi preparado com o *docker compose* compondo duas stacks: o MySql e a API REST (Spring Boot).
Mais adiante, veremos como excutar de duas formas: na máquina local ou através do container docker.

### Quick Start

Existem duas formas de rodar o projeto, sendo que a primeira, deve-se partir do pressuposto que já existe na máquina um ambiente MySQL instalado. A seguir veremos como executar o projeto de duas maneiras:

#### Via Gradle

1.Fazer o clone do projeto:

``
git clone https://github.com/adriangois/casepismo.git
``

2.Verificar o arquivo de configuração */casepismo/src/resources/application.properties* e alterar as seguintes linhas de acordo com seu ambiente:

``spring.datasource.url=jdbc:mysql://localhost:<Porta, geralmente 3306>/casepismo``

``spring.datasource.username=<seu usuario>``

``spring.datasource.password=<sua senha>``
>Não esqueça de criar o banco *casepismo* no MySQL local. Não precisa se preocupar com as tabelas. Elas serão criadas automaticamente pela aplicação.

3.Rodar o build do gradle:

Linux ou Mac

``./gradlew build -x test``

Windows

``gradle.bat build -x test``

4.Dentro da pasta do projeto, digitar:

Linux ou Mac

``
./gradlew bootRun
``

Windows

``
gradlew.bat bootRun
``

Se tudo estiver devidamente instalado, sua aplicação deve rodar sem problemas. 

#### Via Docker

O projeto contém dois arquivos de configuração Docker. O arquivo padrão *Dockerfile* na raiz do projeto prepara o container responsável pela subida do microserviço em Spring Boot.
O `docker-compose.yml`, configura os dois containers (MySql e Spring Boot), cria um **Compose** e faz o deploy no docker. Veja a seguir um exemplo:

![alt text](https://github.com/adriangois/casepismo/blob/master/docs/stack.png?raw=true)


Para rodar o projeto você precisa apenas dos seguintes comandos:

1. Execute os passos 1 e 3 da seção anterior para o gradle fazer o build do projeto. Não precisamos do passo 2, pois toda configuração de usuário, senha e criação de banco está em `docker-compose.yml`;

2. Agora execute:

``
sudo docker-compose up --build -d
``

Aguarde e pronto! Sua api deve estar no ar. 

![alt text](https://github.com/adriangois/casepismo/blob/master/docs/noar.png?raw=true)


> **Atenção** para o tempo de subida dos containers. Geralmente, quando é a primeira vez, demora-se um pouco mais, pois o *helthcheck* da aplicação aguarda a subida do MySql para continuar.

Abaixo um exemplo em que o Spring Boot "aguarda" a subida completa do MySql.

![alt text](https://github.com/adriangois/casepismo/blob/master/docs/helthcheck.png?raw=true)


### Postman

Na pasta `/casepismo/docs/`, o arquivo PISMO.postman_collection.json pode ser importado no Postman para execução das apis.

### Carga inicial

O projeto executa uma carga com 4 tipos de operações na tabela `operations_type`, conforme documentação, para facilitar nos testes de criação das `transactions`.
