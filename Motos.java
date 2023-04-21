package trabalho;

public class Motos extends Veiculo {
    
    public float velocidadeAtual(){
        return 80.34f;
    }
   
    public Motos(String modelo, String marca, int ano){
        super(modelo,marca,ano);
        this.estilo = "Moto";
    }
}
