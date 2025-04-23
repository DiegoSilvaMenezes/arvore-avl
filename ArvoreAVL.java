public class ArvoreAVL {
    private No raiz;
    public int rotacoes = 0;

    private int altura(No no) {
        if (no == null) {
            return 0;
        } else {
            return no.altura;
        }
    }

    private int fatorBalanceamento(No no) {
        if (no == null) {
            return 0;
        } else {
            return altura(no.esquerdo) - altura(no.direito);
        }
    }

    private No rotacaoDireita(No y) {
        No x = y.esquerdo;
        No T2 = x.direito;

        x.direito = y;
        y.esquerdo = T2;

        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;
        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;

        rotacoes++;
        return x;
    }

    private No rotacaoEsquerda(No x) {
        No y = x.direito;
        No T2 = y.esquerdo;

        y.esquerdo = x;
        x.direito = T2;

        x.altura = Math.max(altura(x.esquerdo), altura(x.direito)) + 1;
        y.altura = Math.max(altura(y.esquerdo), altura(y.direito)) + 1;

        rotacoes++;
        return y;
    }

    public void inserir(int valor) {
        raiz = inserir(raiz, valor);
    }

    private No inserir(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }

        if (valor < no.valor) {
            no.esquerdo = inserir(no.esquerdo, valor);
        } else if (valor > no.valor) {
            no.direito = inserir(no.direito, valor);
        } else {
            return no;
        }

        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));
        int balanceamento = fatorBalanceamento(no);

        // Casos de rotação
        if (balanceamento > 1 && valor < no.esquerdo.valor)
            return rotacaoDireita(no);
        if (balanceamento < -1 && valor > no.direito.valor)
            return rotacaoEsquerda(no);
        if (balanceamento > 1 && valor > no.esquerdo.valor) {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && valor < no.direito.valor) {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void remover(int valor) {
        raiz = remover(raiz, valor);
    }

    private No remover(No no, int valor) {
        if (no == null) {
            return null;
        }

        if (valor < no.valor) {
            no.esquerdo = remover(no.esquerdo, valor);
        } else if (valor > no.valor) {
            no.direito = remover(no.direito, valor);
        } else {
            if (no.esquerdo == null && no.direito == null) {
                no = null;
            } else if (no.esquerdo == null) {
                no = no.direito;
            } else if (no.direito == null) {
                no = no.esquerdo;
            } else {
                No sucessor = minimoValor(no.direito);
                no.valor = sucessor.valor;
                no.direito = remover(no.direito, sucessor.valor);
            }
        }

        if (no == null) {
            return null;
        }

        no.altura = 1 + Math.max(altura(no.esquerdo), altura(no.direito));
        int balanceamento = fatorBalanceamento(no);

        if (balanceamento > 1 && fatorBalanceamento(no.esquerdo) >= 0)
            return rotacaoDireita(no);
        if (balanceamento > 1 && fatorBalanceamento(no.esquerdo) < 0) {
            no.esquerdo = rotacaoEsquerda(no.esquerdo);
            return rotacaoDireita(no);
        }
        if (balanceamento < -1 && fatorBalanceamento(no.direito) <= 0)
            return rotacaoEsquerda(no);
        if (balanceamento < -1 && fatorBalanceamento(no.direito) > 0) {
            no.direito = rotacaoDireita(no.direito);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    private No minimoValor(No no) {
        No atual = no;
        while (atual.esquerdo != null) {
            atual = atual.esquerdo;
        }
        return atual;
    }

    public boolean buscar(int valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(No no, int valor) {
        if (no == null) {
            return false;
        }
        if (valor == no.valor) {
            return true;
        }
        if (valor < no.valor) {
            return buscar(no.esquerdo, valor);
        } else {
            return buscar(no.direito, valor);
        }
    }

    public void imprimir() {
        imprimir(raiz, "", true);
    }

    private void imprimir(No no, String prefixo, boolean ehDireito) {
        if (no != null) {
            System.out.println(prefixo + (ehDireito ? "└── " : "├── ") + no.valor);
            imprimir(no.esquerdo, prefixo + (ehDireito ? "    " : "│   "), false);
            imprimir(no.direito, prefixo + (ehDireito ? "    " : "│   "), true);
        }
    }
}


