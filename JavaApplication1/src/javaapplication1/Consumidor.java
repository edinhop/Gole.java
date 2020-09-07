
package javaapplication1;

public class Consumidor extends Usuario {
    private String cpf;
    
    public Consumidor(String cpf, int idUsuario, String email, String senha, int endereco, int enderecoNumero, String enderecoComplemento) {
        super(idUsuario, email, senha, endereco, enderecoNumero, enderecoComplemento);
        this.cpf = cpf;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String toString(){
        return super.toString()+ " " + getCpf();
    }
}
