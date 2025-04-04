import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
     Scanner input = new Scanner(System.in);
     int opcao = -1;
     int opcao2 = 0;


  


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

                     List<Filme> filmes = new ArrayList<>();
                     List<Serie> series = new ArrayList<>();
                     
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
            

                        if(opcao2 == 1){
                            AdicionarFilme(input, filmes);
                            break;
                        }


                        if(opcao2 == 2){
                            AdicionarSerie(input, series);
                            break;                      
                        }

                    
        
                //Exibir conteudo.
                case 3:
                  
                    break;
        
                //Buscar conteudo por titulo.
                case 4:
                    
                    break;
        
        
        
                default:
                    break;
                   
        
                 }
        
                 
             
            }
            input.close();
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
