import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

public class PostoDeSaude {
    private static final int CAPACIDADE_DIA = 100;

    public static void main(String[] args) {
        Deque<Pessoa> filaAtendimento = new ArrayDeque<>();
        Deque<Pessoa> naoAtendidos = new ArrayDeque<>();

        Random random = new Random();

        for (int i = 0; i < CAPACIDADE_DIA; i++) {
            int grupo = i / 10; // Determina o número do grupo (0, 1, 2, ...)
            int pessoasNoGrupo = grupo + 1; // Determina o número de pessoas no grupo (1, 2, 3, ...)

            for (int j = 0; j < pessoasNoGrupo; j++) {
                Pessoa pessoa = criarPessoaAleatoria();
                filaAtendimento.offer(pessoa);
            }

            Pessoa atendido = atenderPessoa(filaAtendimento);
            if (atendido == null) {
                naoAtendidos.addAll(filaAtendimento);
                filaAtendimento.clear();
                break; // Todas as pessoas restantes não serão atendidas
            }
        }

        System.out.println("Atendimentos realizados:");
        while (!filaAtendimento.isEmpty()) {
            Pessoa pessoa = filaAtendimento.poll();
            System.out.println("ID: " + pessoa.getId() + ", Prioridade: " + pessoa.getPrioridade());
        }

        System.out.println("\nPessoas não atendidas:");
        while (!naoAtendidos.isEmpty()) {
            Pessoa pessoa = naoAtendidos.poll();

            System.out.println("ID: " + pessoa.getId() + ", Prioridade: " + pessoa.getPrioridade());
        }
    }

    private static Pessoa criarPessoaAleatoria() {
        Random random = new Random();
        int id = random.nextInt(1000);
        String sexo = random.nextBoolean() ? "Masculino" : "Feminino";
        int idade = random.nextInt(80);
        boolean gestante = random.nextBoolean();
        boolean lactante = random.nextBoolean();
        boolean necessidadeEspecial = random.nextBoolean();

        return new Pessoa(id, sexo, idade, gestante, lactante, necessidadeEspecial);
    }

    private static Pessoa atenderPessoa(Deque<Pessoa> filaAtendimento) {
        for (int prioridade = 3; prioridade >= 0; prioridade--) {
            for (Pessoa pessoa : filaAtendimento) {
                if (pessoa.getPrioridade() == prioridade) {
                    filaAtendimento.remove(pessoa);
                    return pessoa;
                }
            }
        }
        return null; // Retorna null se não houver pessoas para atender
    }
}
