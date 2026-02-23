package Persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PercistenceService {

    private String arquivo;

    public PercistenceService(){
        this.arquivo = arquivo;
    }

    public void salvarDado (List<?> lista){
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(arquivo))) {

            oos.writeObject(lista);

        }catch (IOException e){
            System.out.println("Erro em salvar" + e.getMessage());
        }
    }

    public <T> List<T> carregarDado(){
        try (ObjectInputStream ois = new ObjectInputStream(

                new FileInputStream(arquivo))){

            return (List<T>) ois.readObject();

        } catch (Exception e){
            return new ArrayList<>();
        }

    }
}