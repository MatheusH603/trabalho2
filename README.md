Trabalho 2 da Disciplina de Desenvolvimento Web 2021/22.

Alunos: Mateus Felipe Ribeiro; Matheus Henrique B. Miranda; Paulo Mauricio H. Filho.

Requisitos para rodar a Aplicação secauth:
- Instalar o Java 8 ou versão superior;
- Instalar o Apache Maven;
- Instalar o Apache Tomcat 8.5 ou superior;
- Instalar o SGBD PostgreSQL.

Instruções.

Abra o postgreSQL e crie uma nova senha para o usuário "postgres" e, em seguida, um novo banco de dados chamado "editora".
em seguida, abra o arquivo src/main/resources/application.properties e substitua o campo "Sua_Senha" pela senha definida no passo anterior.
Para executar a aplicação, abra um terminal na pasta da aplicação e digite o comando mvn spring-boot:run.
No seu navegador de preferência, digite a URL http://localhost:8080/secauth/.
Crie sua conta e faça login para ter acesso a aplicação. 

Conteudo da API:
| Metodo || URL | Descrição |
| --- | --- |
| POST | | /cadastrarArtigo | Insere um novo artigo no banco de dados. |
| GET | | /listarTudo | Lista todos os artigos cadastrados no banco. |
| DELETE | | /excluir/{id} | Exclui um artigo pelo seu ID. |
| DELETE | | /excluirTodos | Exclui todos os artigos do banco de dados. |
