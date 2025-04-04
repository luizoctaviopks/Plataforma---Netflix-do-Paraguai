
public class Filme extends Conteudo {
    
 private String diretor;

 public String getDiretor() {
    return diretor;
 }

 public void setDiretor(String diretor) {
    this.diretor = diretor;
 }

 

    @Override
    public void exibirInfo() {
        System.out.println("\nTitulo: " + getTitulo());
        System.out.println("Categoria: " + getCategoria());
        System.out.println("Duração: " + getDuracao());
        System.out.println("Diretor: " + getDiretor());

    }

}
