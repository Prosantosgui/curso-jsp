# curso-jsp

<h1>Configuração Inicial - Import no eclipse</h1>

Será necessário:
<ul>
  <li>IDE Eclipse</li>
  <li>JDK 17</li>
  <li>Apache Tomcat 10.1</li>
</ul>

<p><b>É crucial a instalação prévia do servidor Apache Tomcat 10.1 na IDE Eclipse para a realização desta configuração de ambiente</b></p>

<h2>Dentro da IDE Eclipse:</h2>

Acesse a View de "Git Repositories" -> Clique com o botão direito -> Clone a Git Repository. E então clone este projeto

Após isso, na view de Project Explorer -> Clique com o botão direito -> Import -> Projetct from git (with smart import) -> Existing local repository -> selecione o repositório curso-jsp -> e marque apenas o projeto marcado como "Import as Maven"

<h2>Configurações do Build Path e Runtime</h2>

Na aba <b>Project explorer</b> -> Clique com o botão direito no projeto curso-jsp -> Properties

Em <b>Java Build Path</b> deixe como na imagem abaixo:
![image](https://github.com/Prosantosgui/curso-jsp/assets/66363478/ba6415fb-8efc-4d99-80e5-776598cf01a8)

Em <b>Java Compiler</b>:
![image](https://github.com/Prosantosgui/curso-jsp/assets/66363478/c9979570-8a1f-4614-9094-118860079c70)

Em <b>project Facets</b> deixe exatamente desta forma:
Nesta mesma tela, na aba "Runtimes" Selecione o Apache Tomcat 10.1
![image](https://github.com/Prosantosgui/curso-jsp/assets/66363478/658a720a-ee88-4d66-ac8f-f40a6ad48b62)

Em Targeted Runtimes selecione o Apache Tomcat 10.1:  

![image](https://github.com/Prosantosgui/curso-jsp/assets/66363478/4548c030-f681-47b2-a709-6f2f0d13e218)

Após isso, vá até a view "Servers" -> Clique com o botão direito no servidor Apache Tomcat 10.1 -> <b>Add and Remove...</b> -> Selecione o projeto e clique em <b>Add</b> -> <b>Finish</b>

![image](https://github.com/Prosantosgui/curso-jsp/assets/66363478/424f7347-061a-458c-ba64-58488eaf1ce5)

<h3>Iniciando o projeto</h3>

Para iniciar o projeto: Clique com o botão direito sobre o servidor Apache Tomcat 10.1 -> Start

Após isso, acesse http://localhost:8080/curso-jsp/ 

<i>Como desenvolvedor recomendo o uso da view <b>Package Explorer</b> para visualização de pastas dentro do projeto</i>

E pronto, o projeto já está configurado e rodando! 😀
