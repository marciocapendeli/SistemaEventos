import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EventManager manager = new EventManager();
        Usuario usuario = null;
        int opcao;

        do {
            System.out.println("\n--- Sistema de Eventos ---");
            System.out.println("1 - Cadastrar Usuário");
            System.out.println("2 - Cadastrar Evento");
            System.out.println("3 - Listar Eventos");
            System.out.println("4 - Participar de Evento");
            System.out.println("5 - Cancelar Participação");
            System.out.println("6 - Ver eventos do usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // consumir Enter

            switch(opcao) {
                case 1:
                    System.out.println("\nCadastro de usuário:");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    usuario = new Usuario(nome, idade, email);
                    System.out.println("Usuário cadastrado: " + usuario.getNome());
                    break;

                case 2:
                    System.out.println("\nCadastro de evento:");
                    System.out.print("Nome do evento: ");
                    String nomeEvento = sc.nextLine();
                    System.out.print("Endereço: ");
                    String endereco = sc.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();
                    System.out.print("Ano: ");
                    int ano = sc.nextInt();
                    System.out.print("Mês: ");
                    int mes = sc.nextInt();
                    System.out.print("Dia: ");
                    int dia = sc.nextInt();
                    System.out.print("Hora: ");
                    int hora = sc.nextInt();
                    System.out.print("Minuto: ");
                    int minuto = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = sc.nextLine();

                    Evento evento = new Evento(nomeEvento, endereco, categoria, 
                                               LocalDateTime.of(ano, mes, dia, hora, minuto), 
                                               descricao);
                    manager.adicionarEvento(evento);
                    System.out.println("Evento cadastrado: " + evento.getNome());
                    break;

                case 3:
                    System.out.println("\nEventos cadastrados:");
                    for (Evento e : manager.getEventos()) {
                        System.out.println(e);
                    }
                    break;

                case 4:
                    if(usuario == null) {
                        System.out.println("Cadastre um usuário primeiro!");
                        break;
                    }
                    System.out.print("Digite o nome do evento para participar: ");
                    String nomePart = sc.nextLine();
                    Evento evPart = manager.buscarEvento(nomePart);
                    if(evPart != null) {
                        usuario.participarEvento(evPart);
                        System.out.println("Você agora participa do evento: " + evPart.getNome());
                    } else {
                        System.out.println("Evento não encontrado!");
                    }
                    break;

                case 5:
                    if(usuario == null) {
                        System.out.println("Cadastre um usuário primeiro!");
                        break;
                    }
                    System.out.print("Digite o nome do evento para cancelar participação: ");
                    String nomeCancel = sc.nextLine();
                    Evento evCancel = manager.buscarEvento(nomeCancel);
                    if(evCancel != null && usuario.getEventosParticipando().contains(evCancel)) {
                        usuario.cancelarParticipacao(evCancel);
                        System.out.println("Participação cancelada para: " + evCancel.getNome());
                    } else {
                        System.out.println("Evento não encontrado ou você não participa dele!");
                    }
                    break;

                case 6:
                    if(usuario == null) {
                        System.out.println("Cadastre um usuário primeiro!");
                        break;
                    }
                    System.out.println("\nEventos que você participa:");
                    for(Evento e : usuario.getEventosParticipando()) {
                        String status = "";
                        LocalDateTime agora = LocalDateTime.now();
                        if(e.getHorario().isBefore(agora)) status = " (já ocorreu)";
                        else if(e.getHorario().isAfter(agora)) status = " (ainda vai ocorrer)";
                        else status = " (ocorrendo agora!)";
                        System.out.println(e.getNome() + " - " + e.getHorario().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + status);
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while(opcao != 0);

        sc.close();
    }
}
