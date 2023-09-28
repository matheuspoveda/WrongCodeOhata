# Revisao do codigo
• A unica parte do codigo que esta com uma simples documentacao é a parte da "Instrucao SQL" que na verdade nao documenta nada!

• As variaveis que foram usadas no codigo nao sao horriveis mas existem diversas possibilidades melhores para usar no lugar, por exemplo, uma boa pratica que eu tenho é sempre escolher em qual lingua vou codar, para assim nao ficar intercalando entre ingles e portugues. No codigo tem uma parte que esta escrita em portugues "login" ai no outro campo ao inves de usar "password" pra seguir a mesma linha de raciocinio ele usou "senha", isso fica meio feio de se ler, seria mais facil ter uma lingua fixa.

• Como mencionado a cima, de cara ja temos dois problemas, as nomenclatura nao estao tao boas e o codigo nao tem documentacao alguma para facilitar a vida de quem vai ver entender; tirando esses dois pontos, o codigo nao esta formatado, as linhas nao estao quebradas das formas corretas, tem chaves fechando em lugares que se voce nao prestar atencao voce nem ve aonde foi fechada, poderia tambem ter tratamento nas excecoes lancadas pelo try catch e por ultimo mas nao menos importante essa concatenacao que ele fez da Query do sql ficou completamente errada, sujou muito o codigo.

• Nao, temos dois nullpointer que nao foi tratados,  o "Connection conn" no metodo "conectarBD"  se ocorrer uma excecao durante a criacao da conexao ou algum problema no driver a variavel "conn" vai continuar nula; e o outro que nao foi tratado é o "Statment st" e o "ResultSet rs" no metodo "verificarUsuario", se ocorrer algum problema na criacao ou na execucao da consulta do "Statment" ele permanecera nulo pois nao foi tratado

• A arquitetura nao foi devidamente respeitada pelos diversos outros problemas citados anteriores, por exemplo: nomes dos metodos mais descritivos, se possivel diminuir os tamanhos dos metodos e funcoes dividindo eles em sub-tasks, tratar melhor as excecoes, formatar o codigo para melhorar a visualizacao do codigo, se possivel tambem fazer testes unitarios para previnir erros futuros.

• As conexoes nao foram fechadas corretamente, seria mais correto se no final do try catch a gente usasse o finally para ir verificando cada conexao individualmente e ir fechando uma de cada vez, assim para nao deixar o banco de dados sobrecarregado e melhorar o desempenho da nossa aplicacao.
