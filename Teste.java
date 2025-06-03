import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArvoreAVLTest {
    private ArvoreAVL arvore;

    @BeforeEach
    public void setUp() {
        arvore = new ArvoreAVL();
    }

    @Test
    public void testInsercaoSimples() {
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30);
        assertTrue(arvore.buscar(10));
        assertTrue(arvore.buscar(20));
        assertTrue(arvore.buscar(30));
    }

    @Test
    public void testRotacaoSimplesDireita() {
        arvore.inserir(30);
        arvore.inserir(20);
        arvore.inserir(10); // causa rotação à direita
        assertEquals(1, arvore.rotacoes);
    }

    @Test
    public void testRotacaoSimplesEsquerda() {
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(30); // causa rotação à esquerda
        assertEquals(1, arvore.rotacoes);
    }

    @Test
    public void testRotacaoDuplaEsquerdaDireita() {
        arvore.inserir(30);
        arvore.inserir(10);
        arvore.inserir(20); // causa rotação dupla (esquerda-direita)
        assertEquals(2, arvore.rotacoes);
    }

    @Test
    public void testRotacaoDuplaDireitaEsquerda() {
        arvore.inserir(10);
        arvore.inserir(30);
        arvore.inserir(20); // causa rotação dupla (direita-esquerda)
        assertEquals(2, arvore.rotacoes);
    }

    @Test
    public void testRemoverFolha() {
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.remover(5);
        assertFalse(arvore.buscar(5));
    }

    @Test
    public void testRemoverComUmFilho() {
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(3);
        arvore.remover(5); // nó com filho único
        assertFalse(arvore.buscar(5));
        assertTrue(arvore.buscar(3));
    }

    @Test
    public void testRemoverComDoisFilhos() {
        arvore.inserir(20);
        arvore.inserir(10);
        arvore.inserir(30);
        arvore.inserir(25);
        arvore.inserir(40);
        arvore.remover(30); // nó com dois filhos
        assertFalse(arvore.buscar(30));
        assertTrue(arvore.buscar(25));
        assertTrue(arvore.buscar(40));
    }

    @Test
    public void testBuscarElementoNaoExistente() {
        arvore.inserir(10);
        assertFalse(arvore.buscar(99));
    }

    @Test
    public void testBuscarElementoExistente() {
        arvore.inserir(42);
        assertTrue(arvore.buscar(42));
    }

    @Test
    public void testImpressaoNaoLancaExcecao() {
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(15);
        assertDoesNotThrow(() -> arvore.imprimir());
    }
}
