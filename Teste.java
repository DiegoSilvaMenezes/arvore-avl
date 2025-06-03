// Para o teste funcionar corretamente é necessário instalar os freamework que estão disponivel no arquivo freamework//
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArvoreAVLTest {
    private ArvoreAVL arvore;

    @BeforeEach
    public void setUp() {
        arvore = new ArvoreAVL();
    }

    @AfterEach
    public void imprimirEstadoDaArvore() {
        System.out.println("Estado da árvore após o teste:");
        arvore.imprimir();
        System.out.println("------------------------------");
    }

    private void inserirValores(List<Integer> valores) {
        for (int val : valores) {
            arvore.inserir(val);
        }
    }

    @Test
    public void testInsercaoEBuscaBasica() {
        List<Integer> valores = List.of(10, 20, 30, -5, 0, 19 , 22 , 20);
        inserirValores(valores);
        valores.forEach(v -> assertTrue(arvore.buscar(v)));
    }

    @Test
    public void testInsercaoDeValoresRepetidos() {
        inserirValores(List.of(10, 10, 10));
        assertEquals(1, arvore.contarNos());
    }

    @Test
    public void testBuscarElementoNaoExistente() {
        inserirValores(List.of(5, 10, 15));
        assertFalse(arvore.buscar(95));
    }

   @Test
public void testRotacaoSimplesEsquerdaSequenciaMaior() {
    inserirValores(List.of(10, 20, 30, 40, 69));
    System.out.println("Rotações realizadas: " + arvore.rotacoes);
    // Ajuste o assert conforme o valor esperado
}

 @Test
public void testRotacaoSimplesDireitaSequenciaMaior() {
    inserirValores(List.of(69, 40, 30, 20, 10));
    System.out.println("Rotações realizadas: " + arvore.rotacoes);
    // Ajuste o assert conforme o valor esperado
}

    @Test
    public void testRotacaoDuplaEsquerdaDireita() {
        inserirValores(List.of(30, 10, 20));
        assertEquals(2, arvore.rotacoes);
    }

    @Test
    public void testRotacaoDuplaDireitaEsquerda() {
        inserirValores(List.of(10, 30, 20));
        assertEquals(2, arvore.rotacoes);
    }

    @Test
    public void testRemoverFolha() {
        inserirValores(List.of(10, 5));
        arvore.remover(5);
        assertFalse(arvore.buscar(5));
    }

@Test
public void testRemoverComUmFilho() {
    List<Integer> valoresInseridos = List.of(10, 5, 3, 4 , 6 , 7 ,8 );
    inserirValores(valoresInseridos);

    int valorParaRemover = 5; // valor que será removido (não existe na árvore)

    if (!arvore.buscar(valorParaRemover)) {
        System.out.println("Número " + valorParaRemover + " não está na árvore.");
    } else {
        arvore.remover(valorParaRemover);
    }

    assertFalse(arvore.buscar(valorParaRemover)); // deve continuar não existindo

    // Verifica que os demais valores inseridos ainda estão na árvore
    for (int v : valoresInseridos) {
        if (v != valorParaRemover) {
            assertTrue(arvore.buscar(v));
        }
    }
}
    @Test
    public void testRemoverComDoisFilhos() {
        inserirValores(List.of(50, 10, 30, 25, 40));

        int valorParaRemover = 30;

        if (!arvore.buscar(valorParaRemover)) {
            System.out.println("Número " + valorParaRemover + " não está na árvore, não pode ser removido.");
        } else {
            arvore.remover(valorParaRemover);
            assertFalse(arvore.buscar(valorParaRemover));
        }

        assertTrue(arvore.buscar(25));
        assertTrue(arvore.buscar(40));
    }

    @Test
    public void testImpressaoNaoLancaExcecao() {
        inserirValores(List.of(10, 5, 15));
        assertDoesNotThrow(() -> arvore.imprimir());
    }
}
