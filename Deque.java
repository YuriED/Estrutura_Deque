import java.util.LinkedList;
import java.util.Random;
import java.util.ArrayList;

public class Deque<T> {
    private LinkedList<T> deque;
    
    public Deque(){
        deque = new LinkedList<>();
    }
    
    public void adicionaNoInicio(T elemento){
        deque.addFirst(elemento);
    }
    
    public void adicionaNoFinal(T elemento){
        deque.addLast(elemento);
    }
    
    public T removeDoInicio(){
        return deque.removeFirst();
    }
    
    public T removeDoFim(){
        return deque.removeLast();
    }
    
    public T getInicio(){
        return deque.getFirst();
    }
    
    public T getFim(){
        return deque.getLast();
    }
    
    public boolean isEmpty(){
        return deque.isEmpty();
    }
    
    public int size(){
        return deque.size();
    }
    
    public void imprimir(){
        System.out.print("Deque: ");
        for(T elementos : deque){
            System.out.print(elementos + " ");
        }
        System.out.println();
    }
    
    public void organizarAtendimento(){
        Random gerador = new Random();
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();

        Deque<Pessoa> dequeLactanteEGestante = new Deque<>();
        Deque<Pessoa> dequeEspecial = new Deque<>();
        Deque<Pessoa> dequeNormal = new Deque<>();
        Deque<Pessoa> deque60Anos = new Deque<>();
        Deque<Pessoa> dequeNaoAtendidos = new Deque<>();
        Deque<Pessoa> dequeAtendidos = new Deque<>();

        for(int j = 0; j < 20; j++){
            if(!dequeLactanteEGestante.isEmpty()){
                dequeAtendidos.adicionaNoFinal(dequeLactanteEGestante.getInicio());
                dequeLactanteEGestante.removeDoInicio();
            }else if(!dequeEspecial.isEmpty()){
                dequeAtendidos.adicionaNoFinal(dequeEspecial.getInicio());
                dequeEspecial.removeDoInicio();
            }else if(!deque60Anos.isEmpty()){
                dequeAtendidos.adicionaNoFinal(deque60Anos.getInicio());
                deque60Anos.removeDoInicio();
            }else if(!dequeNormal.isEmpty()){
                dequeAtendidos.adicionaNoFinal(dequeNormal.getInicio());
                dequeNormal.removeDoInicio();
            }
            
            for(int i = 0; i < 100; i++){
                int id = gerador.nextInt(1000);
                int sexo = gerador.nextInt();
                int idade = gerador.nextInt(90);
                boolean gestante = gerador.nextBoolean();
                boolean lactante = gerador.nextBoolean();
                boolean necessidadeEspecial = gerador.nextBoolean();
        
                Pessoa p = new Pessoa(id, sexo, idade, gestante, lactante, necessidadeEspecial);
                pessoas.add(p);
        
                for(int z = 0; z < pessoas.size(); z++){
                    if(pessoas.get(z).isLactante() || pessoas.get(z).isGestante()){
                        dequeLactanteEGestante.adicionaNoFinal(pessoas.get(z));
                    }else if(pessoas.get(z).getIdade() > 60){
                        deque60Anos.adicionaNoFinal(pessoas.get(z));
                    }else if(pessoas.get(z).isNecessidadeEspecial()){
                        dequeEspecial.adicionaNoFinal(pessoas.get(z));
                    }else{
                        dequeNormal.adicionaNoFinal(pessoas.get(z));
                    }
                }
            }
        }

        System.out.println("Atendimentos Realizados: ");
        for(int i = 0; i < dequeAtendidos.size(); i++){
            System.out.println(dequeAtendidos.getInicio().toString());
            dequeAtendidos.removeDoInicio();
        }

        for(int i = 0; i < 100; i++){
            if(!dequeLactanteEGestante.isEmpty()){
                dequeNaoAtendidos.adicionaNoFinal(dequeLactanteEGestante.getInicio());
                dequeLactanteEGestante.removeDoInicio();
            }else if(!dequeEspecial.isEmpty()){
                dequeNaoAtendidos.adicionaNoFinal(dequeEspecial.getInicio());
                dequeEspecial.removeDoInicio();
            }else if(!deque60Anos.isEmpty()){
                dequeNaoAtendidos.adicionaNoFinal(deque60Anos.getInicio());
                deque60Anos.removeDoInicio();
            }else if(!dequeNormal.isEmpty()){
                dequeNaoAtendidos.adicionaNoFinal(dequeNormal.getInicio());
                dequeNormal.removeDoInicio();
            }
        }
        
        System.out.println("Atendimentos Não Realizados: ");
        for(int i = 0; i < dequeNaoAtendidos.size(); i++){
            System.out.println(dequeNaoAtendidos.getInicio().toString());
            dequeNaoAtendidos.removeDoInicio();
        }
    }

    public static void main(String[] args) {
        Deque<Pessoa> deque = new Deque<>();
        deque.organizarAtendimento();
    }
}