package org.example;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        System.out.print("Escribe un archivo y su tipo de ordenación: ");
        String comando = sc.nextLine();

        String[] partesDeComando = comando.split(" ");

        Path pathFile = Paths.get(partesDeComando[0]);
        List<String> lineasTexto = Files.readAllLines(pathFile);
//        String texto = Files.readString(pathFile);
//
//        System.out.println(Arrays.toString(texto.split("\n")));
        List<List<String>> textoSeparado = new ArrayList<>();
        for (String linea : lineasTexto){
            textoSeparado.add(Arrays.stream(linea.split("\\.")).toList());

        }

        List<String> lineasTextoConEspacios = textoSeparado.stream().flatMap(List::stream).toList();
        String a = "asdas";

        List<String> lineasTextoFinal = new ArrayList<>();
        for (String linea : lineasTextoConEspacios){
            if(partesDeComando.length >= 3 && partesDeComando[2].equals("case-insensitive")) {
                if (linea.length() > 1) {
                    lineasTextoFinal.add(linea.trim().substring(0, 1).toUpperCase() + linea.trim().substring(1));
                }else {
                    lineasTextoFinal.add(linea.trim());
                }
            }else {
                lineasTextoFinal.add(linea.trim());
            }
        }
        if (partesDeComando.length >= 2 && partesDeComando[1].equals("descendente")){
            lineasTextoFinal.stream().sorted().toList().reversed().forEach(System.out::println);
        }
        else {
            lineasTextoFinal.stream().sorted().forEach(System.out::println);
        }


    }




}
