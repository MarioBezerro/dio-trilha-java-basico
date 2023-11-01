public class Conta {

    private static int contadorDecontas = 1;
    
    private int numeroConta;
    private String agencia;
    private Cliente cliente;
    private Double saldo = 0.0;

    public Conta(Cliente cliente, String agencia) {
        this.numeroConta = contadorDecontas;
        this.agencia = agencia;
        this.cliente = cliente;
        contadorDecontas += 1;        
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return  "\nNúmero da conta: " + this.getNumeroConta() +
                "\nNome: " + this.cliente.getName() + 
                "\nCPF: " + this.cliente.getCpf() + 
                "\nEmail: " + this.cliente.getEmail() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) + 
                "\n";  
    }

    public void depositar(Double valor) {
        if(valor > 0) {
            setSaldo(getSaldo() + valor);
            System.out.println("Seu depósito foi realizado com sucesso!!");
        }else{
            System.out.println("Não foi possível realizar a operação!!");
        }
    }

    public void sacar(Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Seu saque realizado com sucesso!!");
        }else{
            System.out.println("Saldo insuficiente não foi possível realizar a operação!!");
        }
    } 
    
    public void transferir(Conta contaParaDeposito, Double valor) {
        if(valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            System.out.println("Transferência realizada com sucesso!!");
        }else{
            System.out.println("Saldo insuficiente não foi possível realizar a operação!!");
        }
    }
}
