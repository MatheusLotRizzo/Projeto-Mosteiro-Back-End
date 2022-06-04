# Projeto Mosteiro Piratininga

### RestController para envio de email.

#### Requisitos

- Tomcat 8.5.x
- Maven 3.8.x
- Java 11.x

#### Atualização de servidor de e-mail que irá os disparos dos emails

No arquivo OracaoService (com.example.mosteiro.domains.service.OracaoService) nas linhas 44 e 52, colocar o endereço de e-mail e a devida senha de seu servidor de e-mail

#### Atualização de endereços de e-email que irão receber os e-mails

No arquivo OracaoService (com.example.mosteiro.domains.service.OracaoService) nas linhas 26 a 28, alterar para os e-mails que irão receber, caso não utilize todos, basta apagar a linha, caso queria adicionar mais, basta duplicar a linha e alterar o e-mail

#### Gerar arquivo War

Na pasta base do projeto ({Seu local de gravação}\mosteiro), executar o seguinte comando para extração do war:

```sh
mvn clean package
```

Após o comando, o arquivo war estará com o nome de "mosteiro-0.0.1-SNAPSHOT.war" na pasta ({Seu local de gravação}\mosteiro\target)

#### Deploy do projeto no tomcat

Colocar o arquivo "mosteiro-0.0.1-SNAPSHOT.war" dentro da seguinte pasta do tomcat

```sh
({Seu local de gravação}\apache-tomcat-8.5.x\webapps\)
```

Após isso, basta iniciar o tomcat que a aplicação estará no ar.
Documentação de apoio para start do tomcat

```sh
https://www.ibm.com/docs/pt-br/elm/6.0.6?topic=tomcat-starting-server
```

## Colaboradores

| Nome               | GitHub                                  |
| ------------------ | --------------------------------------- |
| Matheus Rizzo      | https://github.com/MatheusLotRizzo      |
| Guilherme Oliveira | https://github.com/Guilherme1-jpg       |
| Lucas Sanches      | https://github.com/LucasSanchesFaustino |
| Ulisses Rosa       | https://github.com/UlissesSRosa         |
| Gabriel Orbeli     | https://github.com/Orbeli               |
| Edson Bergamo      | https://github.com/edddjunior           |
| Gustavo            | em breve                                |
| Caio Grandino      | em breve                                |

## Front-End do Projeto

| GitHub                                           |
| ------------------------------------------------ |
| https://github.com/Guilherme1-jpg/Social-project |

## Back-End do Projeto

| GitHub   |
| -------- |
| em breve |
