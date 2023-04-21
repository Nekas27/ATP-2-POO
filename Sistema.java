package trabalho;
import java.util.ArrayList;
import java.io.*;

public class Sistema {
  
    private ArrayList<Veiculo> veiculos;

    public Sistema(){
        this.veiculos = new ArrayList<Veiculo>();
    }

    public void adicionarVeiculo(Veiculo veic){
        this.veiculos.add(veic);
    }

    public void listarVeiculos(){
        for(Veiculo veic : veiculos) {
            System.out.println(veic.mostrarDados());
        }
        System.out.println("UM Total de: " + this.veiculos.size() + " foram adicionados!");
    }

    public void excluirVeiculo(String modelo){
        Veiculo veic = null;
        for (Veiculo v : this.veiculos) {
            if (v.getMarca().equals(modelo)) {
                veic = v;
                break;
            }
        }
        if (veic != null) {
            this.veiculos.remove(veic);
            System.out.println("O veículo " + veic.mostrarDados() + " foi excluído!");
        } else {
            System.out.println("Veículo não encontrado no sistema!");
        }
    }

    public void excluirVeiculos(){
        this.veiculos.clear();
        System.out.println("Todos os veículos foram excluídos!");
    }

    public void gravarVeiculos(){
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("C:\\Usuários\\piatn\\trabalho_final"));
            for (Veiculo veic : this.veiculos) {
                outputStream.writeObject(veic);
            }
            System.out.println("Veículos gravados no arquivo com sucesso!");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public void recuperarVeiculos(){
        ObjectInputStream inputStream = null;
        try{
            inputStream = new ObjectInputStream(new FileInputStream("C:\\Usuários\\piatn\\trabalho_final"));
            Object obj = null;
            while((obj = inputStream.readObject()) != null) {
                if(obj instanceof Motos)
                    this.veiculos.add((Motos)obj);
                else if (obj instanceof Carros)
                    this.veiculos.add((Carros)obj);
            }
        }catch (EOFException ex) {
            System.out.println("O final do arquivo foi encontrado!");
        }catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }catch (FileNotFoundException ex){
            ex.printStackTrace();
        }catch(IOException ex) {
            ex.printStackTrace();
        }finally{
            try{
                if(inputStream != null) {
                    inputStream.close();
                    System.out.println("Veículos recuperados!");
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        Sistema sist = new Sistema();

            Carros c1 = new Carros("320i", "BMW", 2022);
            Motos m1 = new Motos("XRE300", "Honda", 2028);
            
            sist.adicionarVeiculo(c1);
            sist.adicionarVeiculo(m1);
            sist.listarVeiculos();
            sist.gravarVeiculos();
            sist.excluirVeiculo("320I");
            sist.excluirVeiculo("XRE300");
            sist.listarVeiculos();
            sist.listarVeiculos();
            sist.recuperarVeiculos();
            sist.listarVeiculos();
    }
}

   


