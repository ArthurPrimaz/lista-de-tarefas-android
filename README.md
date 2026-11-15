# Lista de Tarefas Android

App Android em Java para gerenciar tarefas, com armazenamento local em SQLite. Projeto acadêmico da disciplina de Desenvolvimento Mobile.

## Funcionalidades
- Adicionar tarefas com título e descrição
- Listar todas as tarefas salvas
- Editar uma tarefa: toque no item e escolha **Editar**
- Excluir uma tarefa: toque no item e escolha **Excluir**
- Os dados ficam salvos no aparelho, mesmo depois de fechar o app

## Como funciona
- A tela principal reúne os campos de título e descrição, o botão **Adicionar** e a lista de tarefas
- As tarefas são gravadas em uma tabela SQLite (`tarefas`) por meio da classe `DatabaseHelper`
- A classe `Task` representa uma tarefa (id, título e descrição)
- Ao tocar em um item, um `AlertDialog` oferece as opções de editar ou excluir

## Estrutura
- `MainActivity.java`: tela principal e lógica da lista
- `DatabaseHelper.java`: criação do banco e operações de inserir, listar, atualizar e excluir
- `Task.java`: modelo de tarefa
- `res/layout/activity_main.xml`: layout da tela

## Tecnologias
- Java 11
- Android SDK (minSdk 23)
- AndroidX AppCompat
- SQLite (`SQLiteOpenHelper`)
- `ListView`, `ArrayAdapter` e `AlertDialog`

## Como rodar
1. Clone o repositório
2. Abra a pasta do projeto no Android Studio
3. Aguarde a sincronização do Gradle
4. Execute em um emulador ou celular com Android 6.0 ou superior

## Próximos passos
- Marcar tarefas como concluídas
- Validar campos vazios
- Trocar o `ListView` por `RecyclerView`
- Adicionar data e prioridade às tarefas
