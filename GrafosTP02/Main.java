/**
 * Algoritmos em Grafos
 * Pontifícia Universidade de Minas Gerais
 * Instituto de Ciências Exatas e Informática
 * Engenharia de Computação
 * Última Atualização: 10/05/2024
 * Integrantes: David Lanna de Moraes, João Miguel de Abreu Constâncio, 
 * Paulo Eder Medeiros Cardoso e Paulo Ricardo Ferreira Gualberto. 
 */

 import java.util.Scanner;
 import java.util.List;
 
 public class Main {
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         //ArvoreGerMin<String> agm = new ArvoreGerMin<>(); // Alteração aqui para usar ArvoreGerMin
         Grafo<String> grafo = new Grafo<String>();
         int numvertices = 0;
         int testevertices = 0;
         double peso = 1;
         String nomeV, verticeIni, verticeFim;
         Boolean x = true;
 
         // Solicita ao usuário informações iniciais sobre o grafo, como direcionamento e ponderação.
         System.out.print("Informe a quantidade de vértices no grafo: ");
         numvertices = sc.nextInt();
         System.out.print("O grafo é direcionado? (Digite 1 para sim) ");
         int ndd = sc.nextInt();
         System.out.print("O grafo é ponderado? (Digite 1 para sim) ");
         int pon = sc.nextInt();
         grafo.addnumvertices(numvertices);
         for (int i = 0; i < numvertices; i++) {
             if (testevertices <= numvertices) {
                 System.out.print("Informe o nome do vertice: ");
                 nomeV = sc.next();
                 grafo.adicionarVertice(nomeV);
                 testevertices++;
             }
         }
         // MENU
         while (x) {
            System.out.println("\n<<<<<<<<<<<< Escolha uma opcao >>>>>>>>>>>>");
            System.out.println("1. Adicionar Aresta");
            System.out.println("2. Remover aresta");
            System.out.println("3. Ver vizinhos de um vertice");
            System.out.println("4. Ver grau de um vertice");
            System.out.println("5. Ver grau do grafo");
            System.out.println("6. Identificar sucessores e predecessores de um vértice");
            System.out.println("7. Verificar se o grafo e regular");
            System.out.println("8. Verificar se o grafo e completo");
            System.out.println("9. Exportar grafo para GEXF");
            System.out.println("10. Testar se o grafo é simples");
            System.out.println("11. Testar se o grafo é bipartido");
            System.out.println("12. Imprimir grafo como matriz de adjacência");
            System.out.println("13. Imprimir grafo como lista de adjacência");
            System.out.println("14. Encontrar Árvore Geradora Mínima (Prim)");
            System.out.println("15. Busca em largura");
            System.out.println("16. Busca em profundidade");
            System.out.println("17. Ordenação Topológica");
            System.out.println("18. Testar se o grafo é conexo");
            System.out.println("19. Identificar o caminho mínimo entre dois vértices");
            System.out.println("0. Sair");

            int opcao = sc.nextInt();
 
            switch (opcao) {
                case 1:
                    // Adicionar Aresta
                    if (ndd == 1) {
                        System.out.print("Qual será o vértice de início? ");
                        verticeIni = sc.next();
                        System.out.print("Qual será o vértice final? ");
                        verticeFim = sc.next();
                        if (pon == 1) {
                            System.out.print("Qual o peso da aresta? ");
                            peso = sc.nextDouble();
                        }
                        grafo.adicionarArestaDir(peso, verticeIni, verticeFim);
                    } else {
                        System.out.print("Qual será o vértice de início? ");
                        verticeIni = sc.next();
                        System.out.print("Qual será o vértice final? ");
                        verticeFim = sc.next();
                        if (pon == 1) {
                            System.out.print("Qual o peso da aresta? ");
                            peso = sc.nextDouble();
                        }
                        grafo.adicionarArestaNaoDir(peso, verticeIni, verticeFim);
                    }
                    break;
                case 2:
                    // Remover Aresta
                    if (ndd == 1) {
                        System.out.print("Qual será o vértice de início? ");
                        verticeIni = sc.next();
                        System.out.print("Qual será o vértice final? ");
                        verticeFim = sc.next();
                        grafo.removeraresta(verticeIni, verticeFim);
                    } else {
                        System.out.print("Qual será o vértice de início? ");
                        verticeIni = sc.next();
                        System.out.print("Qual será o vértice final? ");
                        verticeFim = sc.next();
                        grafo.removerArestaNaoDir(verticeIni, verticeFim);
                    }
                    break;
                case 3:
                    // Ver Vizinhos de um Vértice
                    if (ndd == 1) {
                        System.out.print("Informe o vértice: ");
                        nomeV = sc.next();
                        grafo.getVizinhos(nomeV);
                    } else {
                        System.out.print("Informe o vértice: ");
                        nomeV = sc.next();
                        grafo.getVizinhosNaoDir(nomeV);
                    }
                    break;
                case 4:
                    // Ver Grau de um Vértice
                    if (ndd == 1) {
                        System.out.print("Informe o vértice que deseja saber o grau: ");
                        nomeV = sc.next();
                        grafo.getGrauverticeDir(nomeV);
                    } else {
                        System.out.print("Informe o vértice que deseja saber o grau: ");
                        nomeV = sc.next();
                        grafo.getGrauVerticeNaoDir(nomeV);
                    }
                    break;
                case 5:
                    // Ver Grau do Grafo
                    if (ndd == 1) {
                        grafo.getGrauGrafoDir();
                    } else {
                        grafo.getGrauGrafoNaoDir();
                    }
                    break;
                case 6:
                    // Identificar Sucessores e Predecessores de um Vértice
                    System.out.print("Informe o vértice: ");
                    nomeV = sc.next();
                    grafo.IdentificarSucePred(nomeV);
                    break;
                case 7:
                    // Verificar se o Grafo é Regular
                    if (ndd == 1) {
                        grafo.regularDir();
                    } else {
                        grafo.regularNaoDir();
                    }
                    break;
                case 8:
                    // Verificar se o Grafo é Completo
                    if (ndd == 1) {
                        grafo.CompletoDir();
                    } else {
                        grafo.CompletoNaoDir();
                    }
                    break;
                case 9:
                    // Exportar Grafo para GEXF
                    grafo.exportarParaGEXF("meuGrafo.gexf");
                    break;
                case 10:
                    // Testar se o Grafo é Simples
                    grafo.testarGrafoSimples();
                    break;
                case 11:
                    // Testar se o Grafo é Bipartido
                    if (grafo.testarGrafoBipartido()) {
                        System.out.println("O grafo é bipartido.");
                    } else {
                        System.out.println("O grafo não é bipartido.");
                    }
                    break;
                case 12:
                    // Imprimir Grafo como Matriz de Adjacência
                    System.out.println("Matriz de Adjacência:");
                    grafo.imprimirMatrizAdjacencia();
                    break;
                case 13:
                    // Imprimir Grafo como Lista de Adjacência
                    System.out.println("Lista de Adjacência:");
                    grafo.imprimirListaAdjacencia();
                    break;
                case 14:
                    // Encontrar Árvore Geradora Mínima (Prim)
                    System.out.print("Informe o vértice inicial: ");
                    nomeV = sc.next();
                    grafo.arvoreMinimaPrim(nomeV);
                    break;
                case 15:
                    // Busca em Largura
                    System.out.print("Informe o vértice inicial: ");
                    nomeV = sc.next();
                    grafo.buscaEmLargura(nomeV);
                    break;
                case 16:
                    // Busca em Profundidade
                    System.out.print("Informe o vértice inicial: ");
                    nomeV = sc.next();
                    grafo.buscaEmProfundidade(nomeV);
                    break;
                case 17:
                    // Ordenação Topológica
                    List<Vertice<String>> ordenacao = grafo.ordenacaoTopologica();
                    System.out.println("Ordenação Topológica:");
                    for (Vertice<String> vertice : ordenacao) {
                        System.out.print(vertice.getDado() + " ");
                    }
                    System.out.println();
                    break;
                    case 18:
                    // Testar se o Grafo é Conexo
                    grafo.testarConexo();
                    break;
                case 19:
                    // Identificar o Caminho Mínimo entre Dois Vértices
                    System.out.print("Informe o vértice de origem: ");
                    String origem = sc.next();
                    System.out.print("Informe o vértice de destino: ");
                    String destino = sc.next();
                    grafo.caminhoMinimoDijkstra(origem, destino);
                    break;
                case 0:
                    x = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
         }
     }
 }