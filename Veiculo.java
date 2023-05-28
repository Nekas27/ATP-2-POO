package trabalho;
import java.io.Serializable;

public abstract class Veiculo implements Serializable {


  private  String marca;
   private  String modelo;
    private int ano;
    protected String estilo;
   

    public Veiculo(String modelo, String marca, int ano){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    public String mostrarDados(){
        String dados = " ";
        dados += "modelo: "  + this.modelo + "\n";
        dados += "marca: "  + this.marca + "\n";
        dados += "Ano: "  + this.ano + "\n";
        dados += "Velocidade atual: " + velocidadeAtual() + "\n";
        return dados;
    }

    
    public abstract float velocidadeAtual();

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }   
}
