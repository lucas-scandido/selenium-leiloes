# Cadastro de Leilões 🔨💰

- Este projeto de automação de testes E2E foi realizado através da aplicação **Leilões**, encontrada no curso da **[Alura](https://cursos.alura.com.br/dashboard)** para os alunos matriculados em seus cursos.

## Instalação/Pré-requisitos
1. IDE de sua preferência.
2. `JDK` instalado para compilar e executar código Java.
3. ChromeDriver na versao `114`.
4. `Selenium WebDriver`.
5. Clone o projeto: `gh repo clone lucas-scandido/selenium-leiloes`.

## Cenários de Testes:

1. Disponibilidade da Aplicação:

| TESTE | STATUS |
| ----- | ----- |
| Deve validar se a aplicação esta online. | ✅ |

2. Login

| TESTE | STATUS |
| ----- | ----- |
| Deve realizar o login com um usuário e senha válidos. | ✅ |
| Quando tentar realizar o login com um usuário e senha inválidos, deve retornar um erro. | ✅ |
| Quando tentar acessar a página de listagem de leilões sem estar previamente logado, deve retornar um erro. | ✅ |

3. Leilões

| TESTE | STATUS |
| ----- | ----- |
| Deve cadastrar um leilão. | ✅ |
| Deve validar as mensagens de erro ao tentar cadastrar um leilão sem os dados necessários. | ✅ |

4. Editar Leilões ⌛

5. Dar Lances em Leilões ⌛
