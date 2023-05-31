import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

class Pessoa {
    private int id;
    private String sexo;
    private int idade;
    private boolean gestante;
    private boolean lactante;
    private boolean necessidadeEspecial;
    private int prioridade;

    public Pessoa(int id, String sexo, int idade, boolean gestante, boolean lactante, boolean necessidadeEspecial) {
        this.id = id;
        this.sexo = sexo;
        this.idade = idade;
        this.gestante = gestante;
        this.lactante = lactante;
        this.necessidadeEspecial = necessidadeEspecial;
        setPrioridade();
    }

    public Pessoa(int id2, int sexo2, int idade2, boolean gestante2, boolean lactante2, boolean necessidadeEspecial2) {
    }

    public int getId() {
        return id;
    }

    public String getSexo() {
        return sexo;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isGestante() {
        return gestante;
    }

    public boolean isLactante() {
        return lactante;
    }

    public boolean isNecessidadeEspecial() {
        return necessidadeEspecial;
    }

    public int getPrioridade() {
        return prioridade;
    }

    private void setPrioridade() {
        if (idade >= 60) {
            prioridade = 1;
        } else if (necessidadeEspecial) {
            prioridade = 2;
        } else if (gestante || lactante) {
            prioridade = 3;
        } else {
            prioridade = 0;
        }
    }
}

