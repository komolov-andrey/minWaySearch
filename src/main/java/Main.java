import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n;
        System.out.print("Введите размерность: ");
        n = scanner.nextInt();

        int[][] mas = new int[n][n];

        int enter=5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                do {
                    System.out.print("Введите эдемент (" + (i+1) + ", " + (j+1) + "): 0 - свободный путь, -1 - тупик: ");
                    enter = scanner.nextInt();
                }while ((enter != 0)&&(enter != -1));
                mas[i][j] = enter;
            }
        }
        System.out.println();

        System.out.print("Введите первую координату точки входа (индексация с единицы): ");
        int ind_f1 = scanner.nextInt() - 1;
        System.out.print("Введите вторую координату точки входа (индексация с единицы): ");
        int ind_f2 = scanner.nextInt() - 1;

        System.out.print("Введите первую координату точки назначения (индексация с единицы): ");
        int ind_fx1 = scanner.nextInt() - 1;
        System.out.print("Введите вторую координату точки назначения (индексация с единицы): ");
        int ind_fx2 = scanner.nextInt() - 1;
        mas[ind_fx1][ind_fx2] = 1;

        int incr = 1;
        // Поиск 1 (finish)
        // Xi, Xj - ее координаты, потом 2, 3, ...
        int xi = 0, xj = 0;
        int ind_i = 0, ind_j = 0;

        boolean flag0 = false;

        do {
            flag0 = false;
            for (int i0 = 0; i0 < n; i0++) {
                for (int j0 = 0; j0 < n; j0++) {
                    if (mas[i0][j0] == 0) {
                        flag0 = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (mas[i][j] == incr) {
                        xi = i;
                        xj = j;
                        ind_i = xi;
                        ind_j = xj - 1;
                        if (ind_j >= 0) {
                            if (mas[ind_i][ind_j] == 0) mas[ind_i][ind_j] = incr + 1;
                        }
                        ind_i = xi;
                        ind_j = xj + 1;
                        if (ind_j < n) {
                            if (mas[ind_i][ind_j] == 0) mas[ind_i][ind_j] = incr + 1;
                        }
                        ind_i = xi - 1;
                        ind_j = xj;
                        if (ind_i >= 0) {
                            if (mas[ind_i][ind_j] == 0) mas[ind_i][ind_j] = incr + 1;
                        }
                        ind_i = xi + 1;
                        ind_j = xj;
                        if (ind_i < n) {
                            if (mas[ind_i][ind_j] == 0) mas[ind_i][ind_j] = incr + 1;
                        }
                    }
                }
            }
            incr++;
            if (incr>999) {
                System.out.println("Есть тупик!\n");
                break;
            }
        }while (flag0);

        // Рисуем ***
        int finish = mas[ind_f1][ind_f2];
        String [][] masString = new String [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                masString[i][j] = mas[i][j] + "";
            }
        }
        masString[ind_f1][ind_f2] = "O";
        int tek = finish;

        // координаты соседних точек
        int ind_l1, ind_l2, ind_u1, ind_u2, ind_r1, ind_r2, ind_d1, ind_d2;
        int k=0;

        while ((tek!=2)) {

            if (k>999){
                System.out.println("Нет пути!\n");
                break;
            }

            ind_l1 = ind_f1;
            ind_l2 = ind_f2-1;
            ind_u1 = ind_f1-1;
            ind_u2 = ind_f2;
            ind_r1 = ind_f1;
            ind_r2 = ind_f2+1;
            ind_d1 = ind_f1+1;
            ind_d2 = ind_f2;

            if (ind_l2 >= 0) {
                if ((tek - mas[ind_l1][ind_l2]) == 1){
                    masString[ind_l1][ind_l2] = "*";
                    tek = mas[ind_l1][ind_l2];
                    ind_f1 = ind_l1;
                    ind_f2 = ind_l2;
                    continue;
                }
            }
            if (ind_u1 >= 0) {
                if ((tek - mas[ind_u1][ind_u2]) == 1){
                    masString[ind_u1][ind_u2] = "*";
                    tek = mas[ind_u1][ind_u2];
                    ind_f1 = ind_u1;
                    ind_f2 = ind_u2;
                    continue;
                }
            }
            if (ind_r2 < n) {
                if ((tek - mas[ind_r1][ind_r2]) == 1){
                    masString[ind_r1][ind_r2] = "*";
                    tek = mas[ind_r1][ind_r2];
                    ind_f1 = ind_r1;
                    ind_f2 = ind_r2;
                    continue;
                }
            }
            if (ind_d1 < n) {
                if ((tek - mas[ind_d1][ind_d2]) == 1){
                    masString[ind_d1][ind_d2] = "*";
                    tek = mas[ind_d1][ind_d2];
                    ind_f1 = ind_d1;
                    ind_f2 = ind_d2;
                    continue;
                }
            }
            k++;
        }

        if (k <= 999) {

            // замена символами
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // замена -1 на #, 1 на Х, ост на .
                    if (masString[i][j].equals("-1")) {
                        masString[i][j] = "#";
                    }else {
                        if (masString[i][j].equals("1")) {
                            masString[i][j] = "X";
                        } else {
                            if (masString[i][j].equals("O")) continue;
                            if (!masString[i][j].equals("*")) masString[i][j] = ".";
                        }
                    }
                }
            }
            //вывод
            System.out.println();
            System.out.print("# - тупик, 0 - вход, Х - выход, * кротчайший путь:\n");

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(masString[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }

}