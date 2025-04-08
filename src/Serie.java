public class Serie extends Conteudo{

    private int temporada;

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    @Override
    public void exibirInfo() {
        System.out.println("\nTitulo: " + getTitulo());
        System.out.println("Categoria: " + getCategoria());
        System.out.println("Duração: " + getDuracao());
        System.out.println("Temporadas: " + getTemporada());
    }

}
