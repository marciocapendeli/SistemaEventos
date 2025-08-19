import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private int idade;
    private String email;
    private List<Evento> eventosParticipando;

    public Usuario(String nome, int idade, String email) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.eventosParticipando = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void participarEvento(Evento e) {
        if(!eventosParticipando.contains(e)) {
            eventosParticipando.add(e);
        }
    }

    public void cancelarParticipacao(Evento e) {
        eventosParticipando.remove(e);
    }

    public List<Evento> getEventosParticipando() {
        return eventosParticipando;
    }
}
