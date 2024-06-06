# Ponto de Venda - Loja de Calçados

## Descrição
Este é um sistema de ponto de venda (PDV) para uma loja de calçados, desenvolvido em Java utilizando a biblioteca Swing para a interface gráfica. O sistema permite a gestão de produtos (tênis), clientes e a realização de vendas. Além disso, possui funcionalidades para gerar relatórios de vendas por data.

## Funcionalidades
- **CRUD de Calçados**: Adicionar, editar, visualizar e remover calçados.
- **CRUD de Tamanhos e Quantidade de Calçados**: Adicionar, editar, visualizar e remover tamahos e quantidades de calçados.
- **CRUD de Clientes**: Adicionar, editar, visualizar e remover clientes.  
- **Realizar Vendas**: Registrar vendas de Calçados para clientes.
- **Relatórios de Vendas**: Visualizar relatórios de vendas filtrados por data.
- **Relatórios de Itens da Vendas**: Visualizar relatórios de Itens da venda selecionada.

## Tecnologias Utilizadas
- **Java**: Linguagem de programação principal.
- **Swing**: Biblioteca para construção da interface gráfica.
- **JDBC**: Para conexão com o banco de dados MySQL.
- **Maven**: Gerenciamento de dependências e construção do projeto.

## Estrutura do Projeto
- `src/`: Código fonte do projeto.
  - `controller/`: Classes responsáveis pela lógica de negócio.
  - `model/`: Classes de modelo que representam os dados.
  - `view/`: Classes que representam a interface gráfica do usuário.
- `resources/`: Arquivos de configuração e outros recursos necessários.
## Configuração do Banco de Dados

1. Conecte-se ao seu banco de dados lojacalcados.
2. Abra o arquivo ConnectorDAO.java localizado em src/dao/ConnectorDAO.java.
3. Altere os valores de URL, login, e senha conforme necessário:
4. Copie e cole o conteúdo do arquivo sql.sql e execute.
