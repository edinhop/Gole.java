
package javaapplication1;


public class Fornecedor extends Usuario {
    private String cnpj;
    private String nomeFantasia;
    private String razaoSocial;

    public Fornecedor(String cnpj, String nomeFantasia, String razaoSocial, int idUsuario, String email, String senha, int endereco, int enderecoNumero, String enderecoComplemento) {
        super(idUsuario, email, senha, endereco, enderecoNumero, enderecoComplemento);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
    }
    
    public String getCnpj(){
        return cnpj;
    }
    
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    
    public String getNomeFantasia(){
        return nomeFantasia;
    }
    
    public void setNomeFantasia(String nomeFantasia){
        this.nomeFantasia = nomeFantasia;
    }
    
    public String getRazaoSocial(){
        return razaoSocial;
    } 
    
    public void setRazaoSocial(String razaoSocial){
        this.razaoSocial = razaoSocial;
    }
    
    public String toString(){
        return super.toString() + " " + getCnpj() + " " + getNomeFantasia() + " " + getRazaoSocial();
    }
}
