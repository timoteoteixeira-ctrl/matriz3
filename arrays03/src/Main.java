
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Criando o vetor com 10 posições
        int[] cargaHoraria = new int[10];

        // ArrayList para armazenar cursos longos
        ArrayList<Integer> cursosLongos = new ArrayList<>();

        int total = 0;
        double media;

        int maior = 0;
        int menor = 0;
        int cursoMaior = 0;
        int cursoMenor = 0;

        int curta = 0;
        int mediaDuracao = 0;
        int longa = 0;

        // 1. LEITURA E VALIDAÇÃO DAS CARGAS HORÁRIAS
        for (int i = 0; i < cargaHoraria.length; i++) {

            System.out.print("Digite a carga horária do curso "
                    + (i + 1) + ": ");
            cargaHoraria[i] = sc.nextInt();

            while (cargaHoraria[i] <= 0 || cargaHoraria[i] > 400) {
                System.out.println("Valor inválido! Digite entre 1 e 400.");

                System.out.print("Digite novamente: ");
                cargaHoraria[i] = sc.nextInt();
            }
        }

        // 2. LISTAGEM DOS CURSOS
        System.out.println("\n--- CARGAS HORÁRIAS DOS CURSOS ---");

        for (int i = 0; i < cargaHoraria.length; i++) {
            System.out.println("Curso " + (i + 1) + ": "
                    + cargaHoraria[i] + " horas");
        }

        // 3. TOTAL E MÉDIA
        for (int i = 0; i < cargaHoraria.length; i++) {
            total += cargaHoraria[i];
        }

        media = (double) total / cargaHoraria.length;

        System.out.println("\n--- TOTAL E MÉDIA ---");
        System.out.println("Total de horas: " + total);
        System.out.println("Média de horas: " + media);

        // 4. MAIOR E MENOR CARGA HORÁRIA
        maior = cargaHoraria[0];
        menor = cargaHoraria[0];

        for (int i = 1; i < cargaHoraria.length; i++) {

            if (cargaHoraria[i] > maior) {
                maior = cargaHoraria[i];
                cursoMaior = i;
            }

            if (cargaHoraria[i] < menor) {
                menor = cargaHoraria[i];
                cursoMenor = i;
            }
        }

        System.out.println("\n--- MAIOR E MENOR CARGA ---");
        System.out.println("Maior carga: Curso " + (cursoMaior + 1)
                + " com " + maior + " horas");

        System.out.println("Menor carga: Curso " + (cursoMenor + 1)
                + " com " + menor + " horas");

        // 5. CLASSIFICAÇÃO DOS CURSOS
        for (int i = 0; i < cargaHoraria.length; i++) {

            if (cargaHoraria[i] < 40) {
                curta++;

            } else if (cargaHoraria[i] < 100) {
                mediaDuracao++;

            } else {
                longa++;
                cursosLongos.add(cargaHoraria[i]);
            }
        }

        System.out.println("\n--- CLASSIFICAÇÃO ---");
        System.out.println("Cursos de curta duração: " + curta);
        System.out.println("Cursos de média duração: " + mediaDuracao);
        System.out.println("Cursos de longa duração: " + longa);

        // 6. LISTA DOS CURSOS LONGOS
        System.out.println("\n--- CURSOS DE LONGA DURAÇÃO ---");

        if (cursosLongos.isEmpty()) {
            System.out.println("Nenhum curso de longa duração.");
        } else {
            System.out.println(cursosLongos);
        }

        // 7. BUSCA DE UMA CARGA HORÁRIA
        System.out.print("\nDigite uma carga horária para buscar: ");
        int busca = sc.nextInt();

        int quantidade = 0;

        System.out.println("Cursos encontrados:");

        for (int i = 0; i < cargaHoraria.length; i++) {

            if (cargaHoraria[i] == busca) {
                System.out.println("Curso " + (i + 1));
                quantidade++;
            }
        }

        if (quantidade == 0) {
            System.out.println("Nenhum curso com essa carga horária.");
        } else {
            System.out.println("Quantidade encontrada: " + quantidade);
        }

        // 8. ORDEM INVERSA
        System.out.println("\n--- ORDEM INVERSA ---");

        for (int i = cargaHoraria.length - 1; i >= 0; i--) {
            System.out.println(cargaHoraria[i]);
        }

        sc.close();
    }
}

