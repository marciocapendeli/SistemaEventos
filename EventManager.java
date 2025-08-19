import java.io.*;
import java.util.*;

public class EventManager {
    private List<Evento> eventos;
    private final String ARQUIVO = "events.data";

    public EventManager() {
        eventos = new ArrayList<>();
        carregarEventos();
    }

    public void adicionarEvento(Evento e) {
        eventos.add(e);
        salvarEventos();
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public Evento buscarEvento(String nome) {
        for(Evento e : eventos) {
            if(e.getNome().equalsIgnoreCase(nome)) {
                return e;
            }
        }
        return null;
    }

    private void salvarEventos() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(eventos);
        } catch (IOException e) {
            System.out.println("Erro ao salvar eventos: " + e.getMessage());
        }
    }

    private void carregarEventos() {
        File f = new File(ARQUIVO);
        if(f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                eventos = (List<Evento>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Erro ao carregar eventos: " + e.getMessage());
            }
        }
    }
}
