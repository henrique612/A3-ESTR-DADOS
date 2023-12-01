# A3-ESTR-DADOS<br>
<br>
Nome completo e RA dos integrantes:<br>
Gabriel de Almeida Araujo - 822134612 <br>
Henrique Patrick Paulino - 820138472 <br>
Hiago Silva Florêncio - 822140407 <br>
Matheus de Paula Oliveira - 822160889 <br>
Rodrigo Teru Nakamura - 82211408<br>
<br>
 - Explicação da implementação utilizada no projeto e justificativas das estruturas utilizadas:<br>
<br>
Implementamos os grupos como uma lista na qual cada elemento é uma árvore ordeneda de nomes para facilitar a busca de indivíduos<br>
A função existe procura um nome dado no input em cada uma das árvores e retorna true se este nome for encontrado em alguma arvore<br>
A função conhece busca os dois nomes em cada arvore e retorna true apenas se ambos os nomes existirem na árvore<br>
A estrutura de fila é uma lista na qual cada elemento é uma outra lista com nomes dos membros naquela fila<br>
A função chegou passa uma variavel Position que armazena a melhor posição e melhor fila por todas as filas, a melhor posição em cada fila é definida quando é percorrida por completo, quando ela passa da melhor posição atual ou quando encontramos uma posição entre um conhecido da pessoa a chegar e um desconhecido.<br>
Após passar por todas as filas alocamos a nova pessoa com base na melhor posição encontrada.<br>
A função atende procura nas filas pelo ID especificado e remove o primeiro membro da lista desta fila<br>
A função desiste  procura nas filas pelo nome de uma pessoa especificado e remove este menbro da lista de sua fila<br>
A função imprime cria uma string por fila concatenando todos os nomes dos membros dela e depois mostra na tela, este processo é feito fila a fila<br>
<br>
 - Código fonte da implementação em Java:<br>
<a href="Parser">Código Fonte</a><br>
<br>
 - Entradas utilizadas para simulação com suas respectivas saídas:<br>
<a href="Simulations">Simulações</a><br>
