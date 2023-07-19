<h1>Java Spring</h1>
<h6>Neste repositório está armazenado o conteúdo da aula de Java com o framework Spring.</h6>

<h2>Aula de Java Spring Web</h2>
<h4>Técnologias utilizadas</h4>
<ul>
  <li>SPRING</li>
  <li>JPA</li>
  <li>THYMELEAF</li>
  <li>HIBERNATE</li>
  <li>HMTL</li>
  <li>CSS</li>
  <li>POSTGRESQL</li>
  <li>METODOS DE CRUD</li>  
</ul>

<h2>Aula de Java Spring Boot</h2>
<h4>Técnologias utilizadas</h4>
<ul>
  <li><details>
      <summary>INSOMNIA</summary>
      <p>Aplicativo utilizado para facilitar nos testes em HTTP, já que neste projeto o objetivo principal é criar somente uma API Rest sem interface gráfica, portanto utilizamos o INSOMNIA para validar os métodos do Controller.</p>
  </li></details>
  <li><details>
      <summary>FLYWAY</summary>
      <p>Framework utilizado para fazer o versionamento de script dos arquivos SQL, onde existe um padrão de nomenclatura de diretórios e arquivos que o mesmo identifica automaticamente e versiona o script.</p>
  </li></details>
  <li><details>
      <summary>BEAN VALIDATION</summary>
      <p>Framework utilizado para fazer a validação dos dados enviados ao banco de dados, ele ajuda a ser menos verboso o código e tem algumas validações prontas bem específicas como @Email, @NotBlank, @NotNull e caso queira     criar em padrão específico é possível utilizar o REGEX com @Pattern(regexp = "\\d{4,6}".</p>
      <p>A documentação oficioal deste código pode ser encontrada no site: https://jakarta.ee/specifications/bean-validation/3.0/jakarta-bean-validation-spec-3.0.html#builtinconstraints , segue abaixo a imagem mostrando como foi utilizado em uma das classes java o BEAN VALIDATION.</p>
      <img>![image](https://github.com/LucasOliveira321/Java_Spring/assets/107444159/70db922c-cdaa-4a53-9cf9-6caf6c60b954)</img>
  </li></details>
  <li><details>
      <summary>LOMBOK</summary>
      <p>Framework utilizado para deixar o código menos verboso, criando GETTER's e CONSTRUCTOR's como mostra na imagem abaixo como foi aplicado em um dos objetos.</p>
      <img>![image](https://github.com/LucasOliveira321/Java_Spring/assets/107444159/8757ad7e-735d-4c80-a452-0e204c52528c)
</img>
  </li></details>
  <li><details>
      <summary>STACK TRACE</summary>
      <p>Método utilizado para o tratamento de erros do Spring, ele pode ser encontrado na documentação oficial, e serve para que em caso de erro em alguma requisição do HTML ele não retorne o trace, que traz informações sensíveis referente ao código criado o que não seria interessante aparecer para o usuário que está utilizando a API desenvolvida no curso em questão.</p>
    <p>Mais informações sobre este método e outros, podem ser encontrados neste link: https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html#application-properties.server.server.error.include-stacktrace</p>
  </li></details>
  <li><details>
      <summary>BCRYPT</summary>
      <p>Bcrypt é um hashing de senha, que é uma funcionalidade de autenticação, senhas são dados sensíveis e não devem ser armazenados em texto, por isto utilizamos esta funcionalidade Hashing que nada mais é do que uma função matemática que converte um texto em outro texto totalmente diferente e de difícil dedução.</p>
    <p>Existem diversos algoritmos de hashing que podem ser utilizados para fazer essa transformação nas senhas dos usuários, sendo que alguns são mais antigos e não mais considerados seguros hoje em dia, como o MD5 e o SHA1. Os principais algoritmos recomendados atualmente são:</p>
    <li>Bcrypt</li>
    <li>Scrypt</li>
    <li>Argon2</li>
    <li>PBKDF2</li>
  </li></details>
  <li><details>
      <summary>JSON WEB TOKEN</summary>
      <p>É uma biblioteca, utilizada para gerar token's em JSON.</p>
      <p>Documentação oficial: https://jwt.io/</p>
  </li></details>
  <li>CONCEITOS SOLID</li>
  <li>METODOS DE CRUD</li>
  <li>POSTGRESQL</li>
  <li>JPA</li>
</ul>
