Consultec - Sistema de Agendamento de Consultas Médicas
Este projeto é um sistema de agendamento de consultas médicas desenvolvido com Spring Boot (back-end).

Pré-requisitos
Certifique-se de que você tenha os seguintes softwares instalados:

Java 17+
Maven
MySQL

Configuração do Back-End
1. Clonar o repositório

git clone https://github.com/seu-usuario/consultec-backend.git
cd consultec-backend

2. Configurar o banco de dados MySQL
Crie um banco de dados no MySQL com o nome consultec ou um nome de sua preferência.

Atualize o arquivo application.properties em src/main/resources com as credenciais do seu banco de dados:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/consultec
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

3. Compilar e rodar o projeto
No terminal, dentro do diretório consultec-backend, execute:

mvn spring-boot:run
O servidor será iniciado em http://localhost:8080.

4. Endpoints da API
Médicos: /api/medicos
Pacientes: /api/pacientes
Consultas: /api/consultas
