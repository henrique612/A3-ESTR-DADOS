package Parser;

import java.io.File;

public class Teste {
    public static void main(String args[]) {
        Grupos peaple = new Grupos();
        File file = new File("./Simulations/input03.txt");
        Parser parser = new Parser(file);
        Fila filas = new Fila();
        
        while (parser.hasNext()) {
            String line = parser.nextLine();
            String tokens[] = line.split(" ");
            switch (tokens[0]) {
                case "grupo:":
                    Grupos grupo = new Grupos();
                    for (int i = 1; i < tokens.length; i++) {
                        grupo.adicionar(tokens[i]);
                    }        
                    peaple.addGrupo(grupo);
                    break;
                case "conhece:":
                    if(peaple.conhece(tokens[1], tokens[2])){
            			System.out.println("["+tokens[1]+ "] conhece ["+tokens[2]+ "]!!");
                    }else{
			            System.out.println("["+tokens[1]+ "] não conhece ["+tokens[2]+ "]!!");
                    }
                    break;
                case "existe:":
                    if(peaple.existe(tokens[1])){
                        System.out.println("["+tokens[1]+ "] Existe!");
                    }else{
                        System.out.println("["+tokens[1]+ "] NÂO existe!");
                    }
                    break;
                case "criaFila:":
                    filas.addFila(tokens[1]);
                    break;
                case "chegou:":
                    for(int i=1; i < tokens.length ; i++){
                        filas.addNewPessoa(peaple,tokens[i]);
                    }
                    break;
                case "atendeFila:":
                    for(int i=1; i < tokens.length ; i++){
                        filas.atendeFila(tokens[i]);
                    }
                    break;
                case "desiste:":
                    for(int i=1; i < tokens.length ; i++){
                        filas.desiste(tokens[i]);
                    }
                    break;
               case "imprime:":
                   filas.print();
                   break;
            }
        }
        System.out.println("Fimmm");

    }
}
