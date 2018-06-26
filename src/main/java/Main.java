public class Main {

    public static void main(String[] args) {

        int[][] mas = {
                {0, 0, 0, 1, 0},
                {0, -1, -1, -1, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, -1, 0},
                {0, 0, 0, -1, 0},
        };

        int n = 5;
        int incr = 1;

        // Поиск 1 (finish)
        // Xi, Xj - ее координаты
        // потом 2, 3, ...
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

        // Вывод
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j] + "\t");
            }
            System.out.println();
        }
    }
}








        /*
        // координаты внутреннего квадрата
        int is = fi, js = fj;
        int im = fi, jm = fj;
        boolean left = true, down = true, right = true, up = true;

        boolean repeat = true;

        do {
            is = is - 1;
            js = js - 1;
            im = im + 1;
            jm = jm + 1;


            if (is < 0) {
                is = 0;
                up = false;
            }
            if (js < 0) {
                js = 0;
                left = false;
            }
            if (im >= n) {
                im = n - 1;
                down = false;
            }
            if (jm >= m) {
                jm = m - 1;
                right = false;
            }

            repeat = true;
            int repeatCount = 0;

            while (repeat) {
                // замены элементов
                for (int iv = is; iv <= im; iv++) {
                    for (int jv = js; jv <= jm; jv++) {
                        if (mas[iv][jv] == 0) {
                            if (iv != im) { // не последняя строка
                                if (jv != jm) { // не последний столбец
                                    if ((mas[iv][jv] < mas[iv][jv + 1]) && (mas[iv][jv + 1] != -1))
                                        mas[iv][jv] = mas[iv][jv + 1] + 1;
                                    if ((mas[iv][jv] < mas[iv + 1][jv]) && (mas[iv + 1][jv] != -1))
                                        mas[iv][jv] = mas[iv + 1][jv] + 1;
                                } else { // последний столбец
                                    if ((mas[iv][jv] < mas[iv][jv - 1]) && (mas[iv][jv - 1] != -1))
                                        mas[iv][jv] = mas[iv][jv - 1] + 1;
                                    if ((mas[iv][jv] < mas[iv + 1][jv]) && (mas[iv + 1][jv] != -1))
                                        mas[iv][jv] = mas[iv + 1][jv] + 1;
                                }
                            } else { // последняя строка
                                if (jv != jm) { // не последний столбец
                                    if ((mas[iv][jv] < mas[iv][jv + 1]) && (mas[iv][jv + 1] != -1))
                                        mas[iv][jv] = mas[iv][jv + 1] + 1;
                                    if ((mas[iv][jv] < mas[iv - 1][jv]) && (mas[iv - 1][jv] != -1))
                                        mas[iv][jv] = mas[iv - 1][jv] + 1;
                                } else { // последний столбец
                                    if ((mas[iv][jv] < mas[iv][jv - 1]) && (mas[iv][jv - 1] != -1))
                                        mas[iv][jv] = mas[iv][jv - 1] + 1;
                                    if ((mas[iv][jv] < mas[iv - 1][jv]) && (mas[iv - 1][jv] != -1))
                                        mas[iv][jv] = mas[iv - 1][jv] + 1;
                                }
                            }
                        }
                        //System.out.print(mas[iv][jv] + "\t");
                    }
                    //System.out.println();
                }
                repeat = false;
                for (int iv = is; iv <= im; iv++) {
                    for (int jv = js; jv <= jm; jv++) {
                        if (mas[iv][jv] == 0) {
                            repeat = true;
                        }
                    }
                }
                repeatCount++;
                System.out.println(repeatCount);
                if (repeatCount > 25) break;
            }
        }while (left || down || right || up) ;


        // Вывод
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mas[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
*/