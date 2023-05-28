package trabalho;

public class Carros extends Veiculo {
    
    public float velocidadeAtual(){
        return 198.23f;
    }
   
    public Carros(String modelo, String marca, int ano){
        super(modelo,marca,ano);
        this.estilo = "Carro";
    }
}
