
/**
 * Implementação de Pilha Sequencial de forma estruturada.
 *
 * Utiliza o critério LIFO
 *
 */
import javax.swing.JOptionPane;

public class Principal {

    /**
     * Tamanho máximo da pilha.
     */
    private static final int TAMANHO_PILHA = 10;
    /**
     * topo da pilha.
     */
    private static int topo = 0;

    /**
     * Realiza a leitura dos dados dos nós.
     *
     * @return O valor lido.
     */
    public static int leitura() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite um valor:"));
    }

    /**
     * Adiciona um novo nó no topo da pilha.
     *
     * Também chamado de push.
     *
     * @param pilha Pilha onde será empilhada o novo elemento.
     * @param novo Valor a ser inserido na pilha.
     * @return verdadeiro ou falso se conseguiu empilhar
     */
    public static boolean empilhar(int[] pilha, int novo) {
        //Verifica se a pilha tem posições disponíveis para enfileirar        
        if (topo < TAMANHO_PILHA) {
            //Adiciona o valor no topo da pilha
            pilha[topo] = novo;
            //Incrementa a próxima posição da pilha
            topo = topo + 1;
            return true;
        } else {
            System.out.println("Empilar - Pilha Cheia.");
            return false;
        }
    }

    /**
     * Acessa o primeiro nó da pilha sem removê-lo.
     *
     * Também chamado de Peek.
     *
     * @param pilha Pilha que contém os nós.
     * @param topo Início da pilha.
     * @return o valor ou -1 se não conseguiu acessar.
     */
    public static int acessarInicio(int[] pilha, int topo) {
        //Verifica se a pilha não está vazia
        if (topo != 0) {
            return pilha[topo - 1];
        } else {
            System.out.println("Acessar início - Pilha Vazia.");
            return -1;
        }
    }

    /**
     * Altera o dado primeiro nó da pilha.
     *
     * @param pilha Pilha que contem os nós.
     * @param topo Início da pilha.
     * @param valor Novo valor para o primeiro nó.
     * @return verdadeiro ou falso se conseguiu alterar.
     */
    public static boolean alterarInicio(int[] pilha, int topo, int valor) {
        //Verifica se a pilha não está vazia
        if (topo != 0) {
            pilha[topo - 1] = valor;
            return true;
        } else {
            System.out.println("Alterar início - Pilha Vazia.");
            return false;
        }
    }

    /**
     * Remove um nó do topo da pilha.
     *
     * Também chamado de Pop.
     *
     * @param pilha Pilha que contêm os nós.
     * @return O nó que foi desempilhado.
     */
    public static int desempilhar(int[] pilha) {
        //Verifica se a pilha não está vazia
        if (topo != 0) {
            //Decrementa para o próximo elemento
            topo = topo - 1;
            //Guarda o valor do topo
            int valor = pilha[topo];
            return valor;
        } else {
            System.out.println("Desempilahr - Pilha Vazia.");
            return -1;
        }
    }

    /**
     * Lista os dados da pilha.
     *
     * @param pilha Pilha para exibir os dados.
     * @param topo Topo da pilha.
     * @return Uma String com os dados da pilha.
     */
    public static String listar(int[] pilha, int topo) {
        //String de retorno
        String temp = "";
        for (int i = 0; i < topo; i++) {
            temp = temp + (i) + "-" + pilha[i] + "\n";
        }
        return temp;
    }

    /**
     * Retorna se a pilha está cheia.
     *
     * @return Verdadeiro ou falso se a pilha está cheia.
     */
    public static boolean estaCheia() {
        return topo == TAMANHO_PILHA;
    }

    /**
     * Retorna se a pilha esta vazia.
     *
     * @return Verdadeiro ou falso se a pilha está vazia.
     */
    public static boolean estaVazia() {
        return topo == 0;
    }

    /**
     * Retorna a quantidade de elementos da pilha.
     *
     * @return A quantidade de elementos da pilha.
     */
    public static int getN() {
        return topo;
    }

    /**
     * Programa principal.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Declaração da pilha
        int pilha[] = new int[TAMANHO_PILHA];

        //Quantidade incial de elementos na pilha
        topo = 0;

        // Controla o menu da pilha
        int opcao = -1;

        //Menu para controle da pilha
        while (opcao != 9) {
            //Monta o menu de opções
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Pilha Sequencial ###\n"
                    + "Selecione a opção desejada:\n"
                    + "1 - Empilhar\n"
                    + "2 - Consultar topo\n"
                    + "3 - Alterar Topo\n"
                    + "4 - Desempilhar\n"
                    + "5 - Está cheia?\n"
                    + "6 - Está vazia?\n"
                    + "7 - Tamanho da Pilha\n"
                    + "8 - Listar\n"
                    + "9 - Sair"));
            switch (opcao) {
                case 1: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    if (empilhar(pilha, dado) == true) {
                        JOptionPane.showMessageDialog(null, "Valor empilhado com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não empilhado!");
                    }
                    break;
                }
                case 2: {
                    if (!estaVazia()) {
                        int dado = acessarInicio(pilha, topo);
                        JOptionPane.showMessageDialog(null, "O valor do topo é " + dado);
                    } else {
                        JOptionPane.showMessageDialog(null, "Pilha vazia!");
                    }

                    break;
                }
                case 3: {
                    //Preenche o valor do dado
                    int dado = leitura();
                    if (alterarInicio(pilha, topo, dado)) {
                        JOptionPane.showMessageDialog(null, "Alteração do início realizada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Alteração do início não realizada!");
                    }
                    break;
                }
                case 4: {
                    int dado = desempilhar(pilha);
                    if (dado != -1) {
                        JOptionPane.showMessageDialog(null, "O valor " + dado + " foi desempilhado com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Pilha vazia, valor não foi desempilhado!");
                    }
                    break;
                }
                case 5: {
                    JOptionPane.showMessageDialog(null, "Está cheia : " + estaCheia());
                    break;
                }
                case 6: {
                    JOptionPane.showMessageDialog(null, "Está vazia : " + estaVazia());
                    break;
                }
                case 7: {
                    JOptionPane.showMessageDialog(null, "A quantidade de elementos da pilha : " + getN());
                    break;
                }
                case 8: {
                    if (!estaVazia()) {
                        JOptionPane.showMessageDialog(null, "Listagem \n" + listar(pilha, topo));
                    } else {
                        JOptionPane.showMessageDialog(null, "Pilha vazia!");

                    }
                    break;
                }
                default:
                    break;
            }//Fim Switch
        }//Fim While
    }//Fim main
}
