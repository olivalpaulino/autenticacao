# Projeto 1 – Autenticação com Spring Boot, Spring Security e Thymeleaf

Este projeto demonstra uma aplicação Java Web utilizando Spring Boot e Spring Security com **formulário de login personalizado** (Thymeleaf) e autenticação baseada em usuários salvos em banco de dados H2 em memória.

## 🎯 Objetivo

Ensinar como implementar autenticação básica com:
- Spring Boot
- Spring Security
- Thymeleaf (páginas HTML)
- Spring Data JPA
- Banco de dados H2

## 🔐 Recursos implementados

- Tela de login com formulário personalizado
- Autenticação com username/senha
- Senha criptografada com BCrypt
- Página protegida (`/home`)
- Logout seguro
- Banco H2 inicializado com um usuário:  
  - `joao / 12345`

## ▶️ Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/olivalpaulino/autenticacao
   cd projeto1-login-basico
2. Compile e rode a aplicação:
./mvnw spring-boot:run

3. Acesse: http://localhost:8080/login

4. Faça login com:
- Usuário: joao
- Senha: 12345

## Testes manuais
- Acesse /home sem login → será redirecionado para /login.
- Faça login correto → será redirecionado para /home.
- Faça login errado → verá mensagem de erro.
- Clique em logout → será redirecionado para tela de login com aviso.

🗂️ Estrutura de pacotes
- dominio → entidade Usuario
- repositorio → interface UsuarioRepository
- config → SecurityConfig, DataLoader
- controle → HomeController
- templates → login.html, home.html

📝 Observações
Todas as senhas são armazenadas com BCrypt.

Nenhum papel de usuário (role) é utilizado neste projeto. Todos têm o mesmo nível de acesso.

Ideal para aprender os fundamentos da autenticação web com Spring.

Gostou? Adquira o Curso de Criação de API Java com Spring Boot (Spring MVC, Data JPA, Security, H2 e MySQL) aqui: [https://pay.kiwify.com.br/XVcZbZy](https://pay.kiwify.com.br/XVcZbZy)
Ou, adquira apenas os projetos Documentados com Spring Security aqui: [https://pay.kiwify.com.br/1BOIOP9](https://pay.kiwify.com.br/1BOIOP9)
