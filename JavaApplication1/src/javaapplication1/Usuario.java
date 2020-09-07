
package javaapplication1;


public class Usuario {
    private int idUsuario;
    private String email;
    private String senha;
    private int endereco;
    private int enderecoNumero;
    private String enderecoComplemento;

    public Usuario(int idUsuario, String email, String senha, int endereco, int enderecoNumero, String enderecoComplemento){
       this.idUsuario = idUsuario;
       this.email = email;
       this.senha = senha;
       this.endereco = endereco;
       this.enderecoNumero = enderecoNumero;
       this.enderecoComplemento = enderecoComplemento;
    }
    
    public int getId() {
        return idUsuario;
    }
    
    public void setId(int id){
        this.idUsuario = id;
    }
    
    public String getEmail() {
        return email;
    }
      
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public int getEndereco(){
        return endereco;
    }
    
    public void setEndereco(int endereco){
        this.endereco = endereco;
    }
    
    public int getEnderecoNumero(){
        return enderecoNumero;
    }
    
    public void setEnderoNumero(int enderecoNumero){
        this.enderecoNumero = enderecoNumero;
    }
    
    public String getEnderecoComplemento(){
        return enderecoComplemento;
    }
    
    public void setEnderecoComplemento(String enderecoComplemento){
        this.enderecoComplemento = enderecoComplemento;
    }
    
    public String toString(){
        return getId() + " " + getEmail() + " " + getSenha() + " " + getEndereco() + " " + getEnderecoNumero() + " " + getEnderecoComplemento();
    }
}

