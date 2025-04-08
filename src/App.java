import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
     Scanner input = new Scanner(System.in);
     int opcao = -1;
     int opcao2 = 0;
     
     List<Filme> filmes = new ArrayList<>();
     List<Serie> series = new ArrayList<>();
     


  
        while (opcao != 0 ) {

               
            System.out.println("\n<<<< MENU >>>>\n");
            System.out.println("1 - Adcionar conteudo.");
            System.out.println("2 - Remover conteudo.");
            System.out.println("3 - Exibir conteudo.");
            System.out.println("4 - Buscar conteudo por titulo.");
            System.out.println("0 - Sair");                
            System.out.print("Opção: ");

            opcao = input.nextInt();
            input.nextLine();

                     switch (opcao) {



                //Adcionar conteudo.
                case 1:
                    System.out.println("Qual conteudo gostaria de adicionar?");
                    System.out.println("1 - Filme");
                    System.out.println("2 - Serie");
                    opcao2 = input.nextInt();
                    input.nextLine(); 
                   
                    
                        if(opcao2 == 1){
                            AdicionarFilme(input, filmes);
                            break;
                        }
        

                        if(opcao2 == 2){
                            AdicionarSerie(input, series);
                            break;                      
                        }
        
                
                //Remover conteudo.
                case 2:
                System.out.println("Qual conteudo gostaria de remover?");
                System.out.println("1 - Filme");
                System.out.println("2 - Serie");
                opcao2 = input.nextInt();
                input.nextLine();
            
                if (opcao2 == 1) {
                    RemoverFilme(input, filmes);
                    break;
                }
            
                if (opcao2 == 2) {
                    RemoverSerie(input, series);
                    break;
                }
                break;
        
               // Exibir conteúdo.
                case 3:
                    System.out.println("Qual conteúdo você deseja exibir?");
                    System.out.println("1 - Filmes");
                    System.out.println("2 - Séries");
                    opcao2 = input.nextInt();
                    input.nextLine();

                        if (opcao2 == 1) {
                            ExibirFilmes(filmes);
                        } else if (opcao2 == 2) {
                            ExibirSeries(series);
                        }
                    voltarMenu(input);
                    break;

                // Buscar conteúdo por título.
                case 4:
                    System.out.println("Qual conteúdo deseja buscar?");
                    System.out.println("1 - Filme");
                    System.out.println("2 - Série");
                    opcao2 = input.nextInt();
                    input.nextLine();

                    System.out.println("Digite o título para buscar:");
                    String tituloBusca = input.nextLine();

                        if (opcao2 == 1) {
                            BuscarFilmePorTitulo(tituloBusca, filmes);
                        } else if (opcao2 == 2) {
                            BuscarSeriePorTitulo(tituloBusca, series);
                        }
                    voltarMenu(input);
                    break;
        
                default:
                    break;
                   
        
                 }
        
                 
             
            }
            input.close();
        }

        private static void ExibirFilmes(List<Filme> filmes) {
            if (filmes.isEmpty()) {
                System.out.println("Nenhum filme cadastrado.");
                return;
            }
        
            System.out.println("\n--- FILMES CADASTRADOS ---");
            for (Filme filme : filmes) {
                filme.exibirInfo();
                System.out.println("-------------------------");
            }
        }
        
        private static void ExibirSeries(List<Serie> series) {
            if (series.isEmpty()) {
                System.out.println("Nenhuma série cadastrada.");
                return;
            }
        
            System.out.println("\n--- SÉRIES CADASTRADAS ---");
            for (Serie serie : series) {
                serie.exibirInfo();
                System.out.println("-------------------------");
            }
        }
        
        private static void BuscarFilmePorTitulo(String titulo, List<Filme> filmes) {
            boolean encontrado = false;
            for (Filme filme : filmes) {
                if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println("\nFilme encontrado:");
                    filme.exibirInfo();
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Filme não encontrado.");
            }
        }
        
        private static void BuscarSeriePorTitulo(String titulo, List<Serie> series) {
            boolean encontrado = false;
            for (Serie serie : series) {
                if (serie.getTitulo().equalsIgnoreCase(titulo)) {
                    System.out.println("\nSérie encontrada:");
                    serie.exibirInfo();
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Série não encontrada.");
            }
        }

        private static void RemoverFilme(Scanner input, List<Filme> filmes) throws InterruptedException, IOException {
            if (filmes.isEmpty()) {
                System.out.println("Nenhum filme cadastrado.");
                voltarMenu(input);
                return;
            }
        
            System.out.println("Digite o título do filme a ser removido:");
            String titulo = input.nextLine();
        
            boolean removido = filmes.removeIf(filme -> filme.getTitulo().equalsIgnoreCase(titulo));
        
            if (removido) {
                System.out.println("Filme removido com sucesso!");
            } else {
                System.out.println("Filme não encontrado.");
            }
        
            voltarMenu(input);
        }
        
        private static void RemoverSerie(Scanner input, List<Serie> series) throws InterruptedException, IOException {
            if (series.isEmpty()) {
                System.out.println("Nenhuma série cadastrada.");
                voltarMenu(input);
                return;
            }
        
            System.out.println("Digite o título da série a ser removida:");
            String titulo = input.nextLine();
        
            boolean removido = series.removeIf(serie -> serie.getTitulo().equalsIgnoreCase(titulo));
        
            if (removido) {
                System.out.println("Série removida com sucesso!");
            } else {
                System.out.println("Série não encontrada.");
            }
        
            voltarMenu(input);
        }



    private static void AdicionarFilme(Scanner input, List<Filme> filmes) throws InterruptedException, IOException {        
       
        System.out.println("Qual o titulo?");
        String titulo = input.nextLine();
      
        System.out.println("Qual a categoria?");
        String categoria = input.nextLine();
      
        System.out.println("Qual a duracao do filme?");
        int duracao = input.nextInt();
      
        input.nextLine();
      
        System.out.println("Qual o diretor?");
        String diretor = input.nextLine();
      
                      Filme filme = new Filme();
                      filme.setTitulo(titulo);
                      filme.setCategoria(categoria);  
                      filme.setDuracao(duracao);
                      filme.setDiretor(diretor);
      
                      filmes.add(filme);
                      filme.exibirInfo();    
                      
                      System.out.println("Filme adicionado com sucesso!");
                     
                      voltarMenu(input);
    }
     
    private static void AdicionarSerie(Scanner input, List<Serie> series) throws InterruptedException, IOException {
        
        System.out.println("Qual o titulo?");
        String titulo = input.nextLine();
      
        System.out.println("Qual a categoria?");
        String categoria = input.nextLine();
      
        System.out.println("Qual a duracao da serie?");
        int duracao = input.nextInt();
      
        input.nextLine();
      
        System.out.println("Quantas temporadas tem?");
        int temporada = input.nextInt();
      
                      Serie serie = new Serie();
                      serie.setTitulo(titulo);
                      serie.setCategoria(categoria);  
                      serie.setDuracao(duracao);
                      serie.setTemporada(temporada);
      
                      series.add(serie);
                      serie.exibirInfo();    
                      
                      System.out.println("Serie adicionada com sucesso!");
                     
    }
     


    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
        
    }
}
