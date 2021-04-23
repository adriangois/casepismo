#Case pismo

###Objetivo

Este projeto faz parte da construção de uma api com Java, Groovy ou Go para fins de seleção junto a Pismo.

###Arquitetura

O projeto foi construido em *Spring Boot* com *Groovy* para o microserviço. Para o Banco de Dados utilizei o *Mysql 5.7*.

###O Spring Boot
A *stack* utilizada no *Spring Boot* foi a seguinte:
1. JPA como camada de persistência;
2. Swagger para documentação e testes das apis;
3. REST como interface de comunicação das apis;
4. Gradle como gestão de build.


###Docker

O projeto foi preparado para ser um *docker compose* com duas stacks: o MySql e a aplicação.
Mais adiante, veremos como rodar em sua máquina local ou via docker.

###Quick Start

Existem duas formas de rodar o projeto, sendo que a primeira, devo partir do pressuposto que já existe na máquina um ambiente MySql instalado. Veja a seguir como rodar o projeto:

####Via Gradle

1.Fazer o clone do projeto:

``
git clone https://github.com/adriangois/casepismo.git
``

2.Verificar no o arquivo de configuração */casepismo/src/resources/application.properties* e alterar as seguintes linhas de acordo com seu ambiente:

``spring.datasource.url=jdbc:mysql://localhost:3306/casepismo``

``spring.datasource.username=<seu usuario>``

``spring.datasource.password=<sua senha>``

3.Dentro da pasta do projeto, digitar:

Linux ou Mac

``
./gradlew bootRun
``

Windows

``
gradlew.bat bootRun
``

####Via Docker

O projeto contem dois arquivos de configuração Docker. O arquivo padrão *Dockerfile* na raiz do projeto prepara o container responsável pela subida do serviço Spring Boot.
O docker-compose.yml, configura os dois containers (MySql e Spring Boot) dentra de uma stack só. Veja a seguir um exemplo:

![alt text](https://github.com/adriangois/casepismo/docs/master/stack.jpg?raw=true)


Para rodar o projeto você precisa apenas dos seguintes comandos:

1. Execute os passos 1 e 3 da seção anterior para o gradle fazer o build do projeto;

2. Agora execute:

``
sudo docker-compose --build
``

e pronto! Sua aplicação deve estar no ar. 

###Postman

Na pasta `/casepismo/docs/`, o arquivo PISMO.postman_collection.json pode ser exportada no Postman para execução das apis.

###Carga inicial

O projeto dá uma carga com 4 tipos de operações na tabela `operations_type` para facilitar nos teste de criação das `transactions`.
