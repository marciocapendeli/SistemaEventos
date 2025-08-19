# SistemaEventos
Projeto de sistema de cadastro e notificação de eventos em Java – console

## Funcionalidades

- Cadastro de usuários com atributos como nome, e-mail e telefone (mínimo de 3 atributos por usuário);
- Cadastro de eventos com: nome, endereço, categoria, horário e descrição;
- Consulta de eventos disponíveis;
- Participação e cancelamento de participação em eventos;
- Ordenação de eventos por horário, mostrando quais estão ocorrendo e quais já ocorreram;
- Armazenamento de eventos em arquivo `events.data` para persistência entre execuções.

## Tecnologias

- Linguagem: Java (Paradigma Orientado a Objetos)
- IDE recomendada: VS Code, Eclipse, NetBeans ou IntelliJ
- Persistência: arquivo de texto (`events.data`)

## Como executar

1. Baixar os arquivos do repositório;
2. Compilar os arquivos `.java` usando `javac *.java`;
3. Executar o programa usando `java NomeDaClassePrincipal`.
