
package javaapplication1;

public class Entregador extends Usuario {
    private int idPedido;
    private String nome;
    private String cnh;
    private String cpf;

    public Entregador(int pedidoIdPedido, String nome, String cnh, String cpf, int idUsuario, String email, String senha, int endereco, int enderecoNumero, String enderecoComplemento) {
        super(idUsuario, email, senha, endereco, enderecoNumero, enderecoComplemento);
        this.idPedido = idPedido;
        this.nome = nome;
        this.cnh = cnh;
        this.cpf = cpf;
    }
    
    public int getIdPedido(){
        return idPedido;
    }
    
    public void setIdPedido(int idPedido){
        this.idPedido = idPedido;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getCnh(){
        return cnh;
    }
    
    public void setCnh(String cnh){
        this.cnh = cnh;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String toString(){
        return super.toString() + " " + getIdPedido() + " " + getNome() + " " + getCnh() + " " + getCpf();
    }
}
