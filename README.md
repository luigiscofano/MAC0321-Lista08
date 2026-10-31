# MAC0321 · Lista 08 de orientação a objetos

> Exercícios independentes em Java: fatorial com Swing, testes JUnit, coleções, adaptador e comparação de concatenação de strings. Coautoria de Luigi Scofano e Hugo Spadete.

[O que faz](#o-que-este-projeto-faz) · [Módulos](#funcionalidades-e-módulos) · [Executar](#como-executar) · [Aprendizagem](#o-que-desenvolvi-e-aprendi) · [Estado atual](#estado-atual) · [Documentação](#documentação-e-navegação)

## O que este projeto faz

Reúne os fontes da Lista 08 de MAC0321, desenvolvida por **Luigi Scofano de Araujo e Hugo Spadete**, com o professor **Marcelo Finger**. São exercícios de programação orientada a objetos, e não funcionalidades de um único produto. Cada pacote tem um objetivo próprio e pode ser estudado separadamente.

## Qual problema resolve

A lista exercita como separar interface e lógica, testar regras, escolher estruturas de dados e adaptar uma interface existente. Preserva o código acadêmico e também permite analisar suas limitações. Não é o mesmo repositório que [usp-mac0321-poo](https://github.com/luigiscofano/usp-mac0321-poo), que reúne outros estudos, implementações e documentação ampliada.

## Funcionalidades e módulos

| Pacote | Exercício | Como usar |
| --- | --- | --- |
| [ex1](src/br/usp/ime/mac321/lista08/ex1/README.md) | Calculadora de fatorial com interface Swing | Execute `FactorialView`; entrada 5 deve mostrar 120 |
| [ex2](src/br/usp/ime/mac321/lista08/ex2/README.md) | Teste do controlador e exemplos de aceitação da interface | Requer JUnit 4; testes gráficos abrem janelas e diálogos |
| [ex3](src/br/usp/ime/mac321/lista08/ex3/README.md) | Wrappers de ArrayList, LinkedList, HashSet e Stack | Importe as classes; compare inclusão, união e igualdade |
| [ex4](src/br/usp/ime/mac321/lista08/ex4/README.md) | Adaptador para iterar valores únicos | Recebe `MultisetArrayList` e usa um conjunto para retirar duplicatas da iteração |
| [extra](src/br/usp/ime/mac321/lista08/extra/README.md) | Comparação entre concatenação com String e StringBuffer | Execute `StringPerformanceTest`; os tempos variam por máquina |

### 1. Fatorial e interface

`FactorialController` calcula o produto dos inteiros de 1 a n e rejeita números negativos. `FactorialView` lê o campo de texto, aciona o controlador, atualiza o rótulo e mostra erros em diálogos. `0!` vale 1. O retorno usa `long`: **acima de 20!, o resultado pode sofrer overflow sem aviso**. A interface não deve ser usada como calculadora de precisão arbitrária.

### 2. Testes de unidade e de aceitação

O teste de unidade verifica o controlador sem precisar de janela. Os exemplos de aceitação criam uma interface Swing e incluem diálogos modais; exigem ambiente gráfico e interação. Sua presença não significa que uma suíte automatizada de interface rode sem intervenção ou em um servidor sem tela.

### 3. Coleções e semântica

Os wrappers de listas e Stack conservam repetições e comparam a ordem das coleções internas. O wrapper de HashSet elimina repetições. Portanto, o nome histórico “Multiset” não garante, sozinho, igualdade matemática por multiplicidade. Essa diferença faz parte da análise do exercício; não foi escondida nem corrigida silenciosamente.

### 4. Adapter

`MultisetAdapter` implementa `Iterable`, não toda a interface `Set`. Sua iteração entrega valores únicos por meio de HashSet, cuja ordem não é garantida. O adaptador depende da classe do exercício 3; os demais exercícios não dependem dele.

### 5. Strings e medição

O programa extra concatena 10.000 letras e mede o tempo com `currentTimeMillis`. É uma demonstração de imutabilidade e alocações, não um benchmark controlado como JMH. Tempos curtos, aquecimento da JVM e carga do computador afetam o resultado.

## Como executar

**Requisitos:** JDK 17+; ambiente gráfico para Swing. Para os testes, acrescente JUnit 4 com `assertThrows` (4.13+) e suas dependências ao classpath. O projeto conserva arquivos de configuração Eclipse e não inclui build Maven/Gradle.

```sh
git clone https://github.com/luigiscofano/MAC0321-Lista08.git
cd MAC0321-Lista08
```

### Executar o fatorial sem instalar JUnit

```sh
javac -encoding UTF-8 -d build/classes -sourcepath src src/br/usp/ime/mac321/lista08/ex1/FactorialView.java
java -cp build/classes br.usp.ime.mac321.lista08.ex1.FactorialView
```

Digite `5` e pressione **Calcular**: o rótulo deve exibir `Resultado: 120`. Experimente `0`, `-1` e `abc`. Os dois últimos casos abrem mensagens de erro. Feche a janela para encerrar.

### Executar a comparação de strings

```sh
javac -encoding UTF-8 -d build/classes src/br/usp/ime/mac321/lista08/extra/StringPerformanceTest.java
java -cp build/classes br.usp.ime.mac321.lista08.extra.StringPerformanceTest
```

A saída informa dois tempos em milissegundos; não há um valor fixo esperado.

### Compilar e experimentar o adaptador

```sh
javac -encoding UTF-8 -d build/classes -sourcepath src src/br/usp/ime/mac321/lista08/ex4/MultisetAdapter.java
jshell --class-path build/classes
```

No JShell:

```java
import br.usp.ime.mac321.lista08.ex3.MultisetArrayList;
import br.usp.ime.mac321.lista08.ex4.MultisetAdapter;
var valores = new MultisetArrayList<Integer>();
valores.add(2); valores.add(2); valores.add(3);
for (var valor : new MultisetAdapter<>(valores)) System.out.println(valor);
```

Devem aparecer 2 e 3 uma vez cada, em ordem não especificada. Use `/exit` para sair.

### Rodar os testes no Eclipse

Importe **Existing Projects into Workspace**, selecione um JDK e adicione a biblioteca **JUnit 4** ao Java Build Path. Execute como JUnit Test as classes `FactorialControllerTest`, `MultisetTest` e `MultisetAdapterTest`. Rode `FactorialAcceptanceTest` separadamente, com tela e disponibilidade para fechar diálogos. O erro `package org.junit does not exist` indica dependência ausente, não um defeito do compilador.

## O que desenvolvi e aprendi

Em coautoria, a lista reúne separação entre interface e cálculo, tratamento de exceções, testes, generics, estruturas de dados e adaptação por composição. O aprendizado central é verificar se o comportamento de uma estrutura realmente corresponde ao contrato desejado: uma lista, um conjunto e um multiconjunto têm semânticas diferentes.

## Estado atual

| Situação | Conteúdo |
| --- | --- |
| Disponível | 13 fontes Java, interface, controlador, testes, wrappers, adaptador e demonstração de strings |
| Limitações | Overflow no fatorial; semântica histórica das coleções; testes gráficos com diálogos; sem CI ou build automático de dependências |
| Evoluções possíveis | Detecção de overflow/BigInteger, testes gráficos robustos, build reproduzível e coleções com contrato explícito |

## Validação e limites

A compilação e as demonstrações sem GUI podem ser verificadas pelo terminal. A abertura efetiva de Swing depende da máquina do leitor. Os testes recuperados não constituem evidência de aprovação por um avaliador institucional. Consulte os guias de cada exercício para não misturar dependências ou pressupor uma única aplicação integrada.

## Documentação e navegação

O [índice do código](src/README.md) relaciona todos os pacotes. Os READMEs de [ex1](src/br/usp/ime/mac321/lista08/ex1/README.md), [ex2](src/br/usp/ime/mac321/lista08/ex2/README.md), [ex3](src/br/usp/ime/mac321/lista08/ex3/README.md), [ex4](src/br/usp/ime/mac321/lista08/ex4/README.md) e [extra](src/br/usp/ime/mac321/lista08/extra/README.md) detalham cada parte.

## Autoria e licença

**Luigi Scofano de Araujo e Hugo Spadete Arrivabene.** Os cabeçalhos originais identificam a coautoria e o contexto da disciplina. O repositório não tem licença geral declarada; a documentação não atribui uma nova licença aos fontes.


## Tópicos do repositório

`java` · `object-oriented-programming` · `swing` · `junit` · `collections` · `adapter-pattern` · `software-testing` · `usp` · `educational`
