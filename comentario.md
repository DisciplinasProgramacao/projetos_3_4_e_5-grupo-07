## Correção Projeto 3 (branch de 02/05)

### Nota base: 8,25

### Comentários
- Backlog preenchido parcialmente
- Instruções de uso preenchido
- Não fizeram video de apresentação
- Classe App apenas iniciada
- Como as classes Filme e Serie possui muitos elementos em comum, o ideal seria usar generalização facilitando assim o uso de polimorfismo
- Idioma e Genero em ambos os casos possuem o mesmo comportamento esperado, principalmente ao considerar a carga de dados
- Rever necessidade de getGENEROS() e setGENEROS()
- Não entendi porque o Filme está como abstrato
- Realizando as alterações acima, o Cliente e a PlataformaStreaming possuiriam listas de Midia, por exemplo e quase todas as operações que eram realizadas individualmente por cada um deles (Filme e Seria) serão realizadas pela classe pai
- Não implementaram todas as filtragens especificadas (nome)
- Verificar metodo adicionarFilme() na PlataformaStreaming
- Documentação não foi realizada em toda a aplicação
- Diagrama desatualizado
- Não estão realizando carga e salvamento de dados


1. Aderência às classes do diagrama: 1,5/2 pontos
  - Diagramas

2. Requisitos de corretamente implementados: 4/12 pontos
  - Carga de dados					0/2 pontos
  - Cadastro + salvar dados			0,25/2 pontos
  - Robustez básica					0,25/1 ponto
  - Clientes							1/2 pontos
	Listas, audiência sem repet
  - Séries							0,5/1 ponto
	 - audiência
  - Filme/Herança de mídia			0,5/1 ponto
  - Buscas 							1,5/3 pontos
	 - nome, gênero, idioma

3. Documentação de código: 2/4 pontos

4. Implementação na aula inicial: 0,75/2 pontos (cliente e série testados)
- Classes de teste não condizentes