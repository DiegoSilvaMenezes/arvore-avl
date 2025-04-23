import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArvoreAVL arvore = new ArvoreAVL();

        int opcao;
        do {
            System.out.println("\n===== MENU ÁRVORE AVL =====");
            System.out.println("1 - Inserir número");
            System.out.println("2 - Remover número");
            System.out.println("3 - Buscar número");
            System.out.println("4 - Imprimir árvore");
            System.out.println("5 - Mostrar número de rotações");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número a inserir: ");
                    int valorInserir = scanner.nextInt();
                    arvore.inserir(valorInserir);
                    System.out.println("Número inserido com sucesso.");
                    break;

                case 2:
                    System.out.print("Digite o número a remover: ");
                    int valorRemover = scanner.nextInt();
                    arvore.remover(valorRemover);
                    System.out.println("Número removido (se existente).");
                    break;

                case 3:
                    System.out.print("Digite o número a buscar: ");
                    int valorBuscar = scanner.nextInt();
                    boolean encontrado = arvore.buscar(valorBuscar);
                    System.out.println(encontrado ? "Número encontrado!" : "Número não encontrado.");
                    break;

                case 4:
                    System.out.println("\nEstrutura da árvore:");
                    arvore.imprimir();
                    break;

                case 5:
                    System.out.println("Total de rotações realizadas: " + arvore.rotacoes);
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
