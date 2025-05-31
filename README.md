# 📘 Documentação do Projeto: Árvore AVL em Java

Este projeto consiste em uma implementação de uma **Árvore AVL** usando a linguagem Java. A Árvore AVL é uma estrutura de dados do tipo árvore binária de busca que se mantém balanceada automaticamente após inserções e remoções. O principal objetivo da árvore AVL é garantir um bom desempenho nas operações de busca, inserção e remoção, mantendo a altura da árvore equilibrada.

---

## 🧱 Estrutura do Projeto

O projeto é composto por três arquivos principais:

### 1. `No.java`

Este arquivo define a estrutura do nó da árvore. Cada nó armazena:

- Um valor inteiro;
- A altura do nó;
- Referência para o filho da esquerda;
- Referência para o filho da direita.

### 2. `ArvoreAVL.java`

Contém toda a lógica da árvore AVL:

- Inserção de elementos com balanceamento automático;
- Remoção de elementos com reajuste da estrutura;
- Cálculo do fator de balanceamento;
- Realização das rotações (simples e duplas);
- Impressão visual da árvore no console;
- Busca de valores.

Também há um contador para exibir quantas rotações foram feitas durante a execução do programa.

### 3. `Principal.java`

É a classe com o método `main`, ou seja, o ponto de entrada do programa. Exibe um menu interativo no terminal com as opções:

- Inserir número;
- Remover número;
- Buscar número;
- Imprimir a árvore;
- Mostrar o número de rotações;
- Sair do programa.

---

## 🛠️ Como compilar e executar o programa no computador

### Pré-requisitos:

- Ter o Java instalado (JDK 8 ou superior);
- Estar com os três arquivos (`No.java`, `ArvoreAVL.java` e `Principal.java`) dentro da **mesma pasta**.

### Passo a passo:

1. Abra o terminal (Prompt de Comando ou PowerShell);
2. Acesse a pasta onde estão os arquivos, por exemplo:

   cd C:\Users\Luis\Desktop\arvore-avl

   ```

   ```

3. Compile todos os arquivos Java com:

   javac \*.java

   ```

   ```

4. Execute o programa com:

   java Principal

   ```

   ```

---

## 🎯 Objetivo e utilidade

## Este projeto é útil para aprender e visualizar como funciona uma árvore AVL na prática. Ele pode ser usado para fins didáticos, trabalhos acadêmicos ou como base para projetos maiores que precisem de estruturas de dados balanceadas.

## 📚 Exemplos de Reequilíbrio (Rotações)

### 🔁 Exemplo 1: Rotação Simples à Direita (caso LL)

Inserções: 30 → 20 → 10

Antes do rebalanceamento:

```
    30
   /
  20
 /
10
```

Após rotação simples à direita:

```
   20
  /  \
10   30
```

### 🔁 Exemplo 2: Rotação Simples à Esquerda (caso RR)

Inserções: 10 → 20 → 30

Antes do rebalanceamento:

```
10
  \
   20
     \
      30
```

Após rotação simples à esquerda:

```
   20
  /  \
10   30
```

### 🔁 Exemplo 3: Rotação Dupla (caso LR)

Inserções: 30 → 10 → 20

Antes:

```
    30
   /
  10
    \
     20
```

Após rotação dupla (esquerda em 10, direita em 30):

```
   20
  /  \
10   30
```

---

## 👥 Identificação do Grupo

| Nome do Aluno                    | RA         |
| -------------------------------- | ---------- |
| LUIS CARLOS SANTOS MELO DE JESUS | 1272122545 |
|                                  |            |
|                                  |            |
|                                  |            |
|                                  |            |
