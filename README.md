<html>
<header>
<h1>Api-administracao<h1>
</header>
<body>
🧪 Tecnologias

<p>Esse projeto foi desenvolvido com as seguintes tecnologias:</p>
<ol>
<li>
<strong>Backend</strong>
</li>
<ul>
<li><a href="https://docs.oracle.com/en/java/javase/11/core/java-core-libraries1.html">Java 11</a></li>
<li><a href="https://spring.io/projects/spring-boot">Spring Boot 2.5.5</a></li>
<li><a href="https://swagger.io/">Swagger</a></li>
<li><a href="https://www.postgresql.org/">PostgreSQL</a></li>
</ul>
</ol>
<p>
<strong>Gerenciameto de dependências</strong>
<ul>
<li>
<a href="https://gradle.org/">Gradle</a>
</li>
</ul>
</p>
<p>Api-administracao permite criar e editar um Setor, adicionar um cargo ao setor, ao trabalhador e permite criar, editar um trabalhador.</p>
<p>
<strong>Regra de negócios</strong>
<ul>
<li>
<p>Não deve ser possível cadastrar um setor com o mesmo nome de outro</p> existente;
</li>
<li>
<p>Cargos ficam vinculados a um setor e não podem ser cadastrados em outros setores;</p>
</li>
<li>
<p>Um trabalhador está vinculado a um setor e a um cargo;</p>
</li>
<li>
<p>Não é possível ter dois trabalhadores com mesmo CPF;</p>
</li>
</ul>
</p>
<p>
<strong>
Diagrama de classe:</strong>
<img src="assets/SEA_solutions.svg" alt="SEA_solutions.svg">
</P>

</body>

<footer>
<strong>Contato :</strong>
<a href="https://www.linkedin.com/in/philogene/">Linkedin</a>
</footer>
</html>