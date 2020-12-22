### API - Votação - Em desenvolvimento - 40% Desenvolvido

**Utilizado:**

- Maven 3.6.3
- Java 8
- Spring Boot
- Spring Data
- Banco de dados: H2
- Swagger 2.9.2 - Acesso via:  servidor:8090/api-votacao/swagger-ui.html
- JWT - 0.9.1

#### Entidade Relacionamento - Banco de Dados

Defini o modelo de relacionamento da seguinte forma:

![Entidade Relacionamento - Banco de Dados](https://i.ibb.co/vkw71Gq/entidade-relacionamento.png "Entidade Relacionamento - Banco de Dados")

USER - Tabela que registra o usuário que irá usar a api e seu nível de perfil. São dois perfis, PRODUÇÂO e VOTANTE.
PARTICIPANT - Cadastro dos participantes do BBB e que serão usados para o paredão.
VOTING - Tabela que será criada a Votação. Com data inicio e termino. 
VOTINGPARTICIPANTS - Tabela filha de VOTING, onde será registrado os participantes da votação e contabilização de todos os votos de cada emparedado. 
VOTINGLOG - Tabela de log onde são registrados log de todos os votos, por usuário e data/time. (Tabela que será possivel resgatar vários tipos de relatórios da votação)

##Autorização para acesso API

A api é protegida pelo JWT. É necessário um token para acesso da api. 
Para ter acesso ao token é necessário fazer o login na chamada POST no servidor:8090/api-votacao/login utilizando o json abaixo.

```json
{ 
     "username" : "user",
	 "password" : "pass"
}
```
Obs: Por padrão pode ser usado o login: admin e senha: 1234.  
É possível criar um novo usuário tambem, executando a chamada no Swagger ou  servidor:8090/api-votacao/user/register com o JSON:

```json
{ 
     "username" : "user",
	 "password" : "pass",
	 "accountType" : 0
}
```
0 - Conta de votante
1 - Conta da produção.
O cenário ideal seria uma tabela no banco para armazenar os perfis e acesso, mas devido ao tempo, criei uma Enum no java (EnumAccountType.java) para armazenar essa informação. 