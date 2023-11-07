import java.util.ArrayList;
import java.util.Scanner;

public class ContaTerminal {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
    public static void main(String[] args) throws Exception {
        
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {

        System.out.println("------------------------------------------------------");
        System.out.println("-------------Bem vindos a nossa Agência---------------");
        System.out.println("------------------------------------------------------");
        System.out.println("***** Selecione uma operação que deseja realizar *****");
        System.out.println("------------------------------------------------------");
        System.out.println("|   Opção 1 - Criar conta   |");
        System.out.println("|   Opção 2 - Depositar     |");
        System.out.println("|   Opção 3 - Sacar         |");
        System.out.println("|   Opção 4 - Transferir    |");
        System.out.println("|   Opção 5 - Listar        |");
        System.out.println("|   Opção 6 - Sair          |");

        int operacao = input.nextInt();

        switch (operacao) {
            case 1:
                criarConta();
                break;
            case 2:
                depositar();
                break;
            case 3:
                sacar();
                break;
            case 4:
                transferir();
                break;
            case 5:
                listarContas();
                break;
            case 6:
                System.out.println("Obrigado por ultilizar nossa agência");
                System.exit(0);
            default:
            System.out.println("Opçãoo inválida");
            operacoes();
            break;            
            
        }
    }

    public static void criarConta() {

        System.out.println("\nNome: ");
        String name = input.next();

        System.out.println("\nCPF: ");
        String cpf = input.next();

        System.out.println("\nEmail: ");
        String email = input.next();

        Cliente cliente = new Cliente(name, cpf, email);

        Conta conta = new Conta(cliente);        

        contasBancarias.add(conta);
        //System.out.println("\nOlá , obrigado por criar uma conta em nosso banco, sua agência é:  conta número:  e seu saldo é:  já está disponível./n");
       
            System.out.printf("\nOlá Seja Bem Vindo!!\n %s, \n\nObrigado por criar uma conta em nosso banco é seja bem vindo, sua agência é %s, " +
                            "conta %d e seu saldo: R$ %.2f já está disponível.\n\n"
                    ,conta.getCliente(),conta.getAgencia(),conta.getNumeroConta(),conta.getSaldo());        
 
        operacoes();
    }
    

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta corrente: contasBancarias) {
                if (corrente.getNumeroConta() == numeroConta) {
                    conta = corrente;
                }                
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual o valor deseja depositar? ");
            Double valorDeposito = input.nextDouble();
            conta.depositar(valorDeposito); 
            System.out.println("Valor depositado com sucesso!! ");
        } else {
            System.out.println("Conta não encontrada!! ");
        }
        operacoes();
    }

    public static void sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if (conta != null) {
            System.out.println("Qual o valor deseja sacar?\n ");
            Double valorSaque = input.nextDouble();
            conta.sacar(valorSaque);
            //System.out.println("Valor sacado com sucesso!! ");
        } else {
            System.out.println("Conta não encontrada!! ");
        }
        operacoes();
    }

    public static void transferir() {
        System.out.println("Número da conta do remetente: ");
        int numeroContaRemetente = input.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if (contaRemetente != null) {
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = input.nextInt();

            Conta contaDestinatario =  encontrarConta(numeroContaDestinatario);

            if (contaDestinatario != null) {
                System.out.println("Valor a transferir: ");
                Double valor = input.nextDouble();

                contaRemetente.transferir(contaDestinatario, valor);
            } else {
                System.out.println("Conta não encontrada!! ");
            }
            operacoes();            
        }                
    }

    public static void listarContas() {
        System.out.println("Número da conta: ");
        int numeroConta = input.nextInt();

        Conta conta = encontrarConta(numeroConta);

          if (conta != null) {            
                System.out.println(conta);            
          } else {
                System.out.println("Não há contas cadastradas! "); 
        }
        operacoes();
    }
}

