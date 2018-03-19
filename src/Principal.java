
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
     * @param _pilha Pilha onde será empilhada o novo elemento.
     * @param _valor Valor a ser inserido na pilha.
     * @return verdadeiro ou falso se conseguiu empilhar
     */
    public static boolean empilhar(int[] _pilha, int _valor) {
        if (topo < TAMANHO_PILHA) {
            //Adiciona o valor a pilha
            _pilha[topo] = _valor;
            //Incrementa a próxima posição da pilha
            topo = topo + 1;
            return true;
        } else {
            System.out.println("Pilha Cheia!");
            return false;
        }
    }

    /**
     * Acessa o primeiro nó da pilha sem removê-lo.
     *
     * Também chamado de Peek.
     *
     * @param _pilha Pilha que contém os nós.
     * @param _topo Início da pilha.
     * @return o valor ou -1 se não conseguiu acessar.
     */
    public static int acessarInicio(int[] _pilha, int _topo) {
        if (_topo != 0) {
            return _pilha[_topo - 1];
        } else {
            System.out.println("Pilha Vazia");
            return -1;
        }
    }

    /**
     * Altera o dado primeiro nó da pilha.
     *
     * @param _pilha Pilha que contem os nós.
     * @param _topo Início da pilha.
     * @param _valor Novo valor para o primeiro nó.
     * @return verdadeiro ou falso se conseguiu alterar.
     */
    public static boolean alterarInicio(int[] _pilha, int _topo, int _valor) {
        if (_topo != 0) {
            _pilha[_topo - 1] = _valor;
            return true;
        } else {
            System.out.println("Pilha Vazia");
            return false;
        }
    }

    /**
     * Remove um nó do topo da pilha.
     *
     * Também chamado de Pop.
     *
     * @param _pilha Pilha que contêm os nós.
     * @return O nó que foi desempilhado.
     */
    public static int desempilhar(int[] _pilha) {
        if (topo != 0) {
            //Decrementa para o próximo elemento
            topo = topo - 1;
            //Guarda o valor do topo
            int valor = _pilha[topo];
            return valor;
        } else {
            System.out.println("Pilha Vazia");
            return -1;
        }
    }

    /**
     * Lista os dados da pilha.
     *
     * @param _pilha Pilha para exibir os dados.
     * @param _topo Topo da pilha.
     */
    public static void listar(int[] _pilha, int _topo) {
        String temp = "";
        for (int i = 0; i < _topo; i++) {
            temp = temp + (i) + "-" + _pilha[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, "Listagem \n" + temp);
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
    public static int quantidadePilha() {
        return topo;
    }

    /**
     * Programa principal.
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Declaração da pilha
         */
        int pilha[] = new int[TAMANHO_PILHA];
        // Controla o menu da pilha
        int opcao = -1;

        //Menu para controle da pilha
        while (opcao != 9) {	//Monta o menu de opcoes
            opcao = Integer.parseInt(JOptionPane.showInputDialog("\t### Pilha Sequencial###\n"
                    + "Selecione a opcao desejada:\n"
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
                    if (empilhar(pilha, leitura()) == true) {
                        JOptionPane.showMessageDialog(null, "Valor empilhado com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não empilhado!");
                    }
                    break;
                }
                case 2: {
                    int valor = acessarInicio(pilha, topo);
                    JOptionPane.showMessageDialog(null, "O valor do topo é " + valor);
                    break;
                }
                case 3: {                    
                    if (alterarInicio(pilha, topo, leitura())) {
                        JOptionPane.showMessageDialog(null, "Alteração do início realizada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Alteração do início não realizada!");
                    }                    
                    break;
                }
                case 4: {
                    int valor = desempilhar(pilha);
                    if (valor != -1) {
                        JOptionPane.showMessageDialog(null, "O valor " + valor + " foi desempilhado com Sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Valor não foi desempilhado!");
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
                    JOptionPane.showMessageDialog(null, "A quantidade de elementos da pilha : " + quantidadePilha());
                    break;
                }
                case 8: {
                    if (estaVazia()) {
                        JOptionPane.showMessageDialog(null, "Pilha vazia!");
                    } else {
                        listar(pilha, topo);
                    }
                    break;
                }
                default:
                    break;
            }
        }//Fim While
    }
}
