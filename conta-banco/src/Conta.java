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
            System.out.println();
        }
    }
}
