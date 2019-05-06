/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

/**
 *
 * @author Pablo Fellype
 */
public class GeradorIdentificador {
    private int identificador = 0;
    String nomeDoArquivo = "PFellype/Documentos/RentSystem/DadosID.txt";
    
    public GeradorIdentificador() throws FileNotFoundException, IOException{
        FileReader fr = new FileReader(nomeDoArquivo);
        BufferedReader br = new BufferedReader(fr);
        String linha = br.readLine();
        String vetorString[] = linha.split(";");
        identificador = Integer.parseInt(vetorString[0]);
        br.close();
    }

    public int getIdentificador() {
        return +identificador;
    }
    
    public void finalize() throws IOException{
        //cria arquivo
        FileWriter fw = new FileWriter(nomeDoArquivo, false);
        //cria buffer do arquivo
        BufferedWriter bw = new BufferedWriter(fw);
        //escreve no arquivo
        String saida = identificador + "\n";
        bw.write(saida);
        //fecha o arquivo
        bw.close();
    }
    
}
