import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("""
                Матричный калькулятор
                Список задач:
                1) Умножение матрицы на скаляр
                2) Сложение матриц
                3) Вычитание матриц
                4) Умножение матриц
                5) Транспонирование матрицы
                6) Вычисление определителя
                7) Выход""");

        while (true) {
            int choice = getUserChoice();
            if (choice < 1 || choice > 7) {
                System.out.println("Нужно ввести число от 1 до 6");
            } else {
                switch (choice) {
                    case 1 -> FirstTask();
                    case 2 -> SecondTask();
                    case 3 -> ThirdTask();
                    case 4 -> FourthTask();
                    case 5 -> FifthTask();
                    case 6 -> SixthTask();
                }

                if (choice == 7) {
                    break;
                }
            }
        }
    }

    public static int getUserChoice() {
        System.out.println("Введите номер задачи: ");
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            try {
                return scanner.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Введены некорректные данные, нужно ввести целое число");
            }
        }
    }

    public static CountRowsColsMatrix createMatrix() {
        int rows, cols;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Введите количество строк матрицы: ");
                rows = scanner.nextInt();
                if (rows >= 1) {
                    System.out.print("Введите количество столбцов матрицы: ");
                    cols = scanner.nextInt();
                    if (cols >= 1) {
                        return new CountRowsColsMatrix(rows, cols);
                    }
                }
                System.out.println("Количество строк/столбцов должно быть больше или равно 1");
            } catch (Exception e) {
                System.out.println("Нужно ввести положительное целое число");
            }
        }
    }

    public static void FirstTask() {
        System.out.println("Умножение матрицы на скаляр");
        CountRowsColsMatrix rc = createMatrix();

        int[][] matrix = new int[rc.getRows()][rc.getCols()];

        for (int i = 0; i < rc.getRows(); i++) {
            for (int j = 0; j < rc.getCols(); j++) {
                System.out.print("Введите элемент матрицы [" + i + "][" + j + "]: ");
                while (true) {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        matrix[i][j] = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Элемент должен быть целым числом");
                    }
                }
            }
        }

        System.out.print("Введите скаляр: ");
        int scalar;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                scalar = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Скаляр должен быть целым числом");
            }
        }

        for (int i = 0; i < rc.getRows(); i++) {
            for (int j = 0; j < rc.getCols(); j++) {
                matrix[i][j] *= scalar;
            }
        }

        System.out.println("Результат умножения матрицы на скаляр:");
        for (int i = 0; i < rc.getRows(); i++) {
            for (int j = 0; j < rc.getCols(); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void SecondTask() {
        System.out.println("Сложение матриц");

        System.out.println("Матрица 1:");
        CountRowsColsMatrix rc1 = createMatrix();
        System.out.println("Матрица 2:");
        CountRowsColsMatrix rc2 = createMatrix();

        if (rc1.getRows() != rc2.getRows() || rc1.getCols() != rc2.getCols()) {
            System.out.println("Невозможно сложить матрицы разного размера.");
            return;
        }

        int[][] matrix1 = new int[rc1.getRows()][rc1.getCols()];

        System.out.println("Введите элементы первой матрицы:");
        for (int i = 0; i < rc1.getRows(); i++) {
            for (int j = 0; j < rc1.getCols(); j++) {
                System.out.print("Введите элемент матрицы 1 [" + i + "][" + j + "]: ");
                while (true) {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        matrix1[i][j] = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Элемент должен быть целым числом");
                    }
                }
            }
        }

        int[][] matrix2 = new int[rc2.getRows()][rc2.getCols()];

        System.out.println("Введите элементы второй матрицы:");
        for (int i = 0; i < rc2.getRows(); i++) {
            for (int j = 0; j < rc2.getCols(); j++) {
                System.out.print("Введите элемент матрицы 2 [" + i + "][" + j + "]: ");
                while (true) {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        matrix2[i][j] = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Элемент должен быть целым числом");
                    }
                }
            }
        }

        int[][] resultMatrix = new int[rc1.getRows()][rc1.getCols()];
        for (int i = 0; i < rc1.getRows(); i++) {
            for (int j = 0; j < rc1.getCols(); j++) {
                resultMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("Результат сложения матриц:");
        for (int i = 0; i < rc1.getRows(); i++) {
            for (int j = 0; j < rc1.getCols(); j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void ThirdTask() {
        System.out.println("Вычитание матриц");

        System.out.println("Матрица 1:");
        CountRowsColsMatrix rc1 = createMatrix();
        System.out.println("Матрица 2:");
        CountRowsColsMatrix rc2 = createMatrix();

        if (rc1.getRows() != rc2.getRows() || rc1.getCols() != rc2.getCols()) {
            System.out.println("Невозможно вычесть матрицы разного размера.");
            return;
        }

        int[][] matrix1 = new int[rc1.getRows()][rc1.getCols()];

        System.out.println("Введите элементы первой матрицы:");
        for (int i = 0; i < rc1.getRows(); i++) {
            for (int j = 0; j < rc1.getCols(); j++) {
                System.out.print("Введите элемент матрицы 1 [" + i + "][" + j + "]: ");
                while (true) {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        matrix1[i][j] = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Элемент должен быть целым числом");
                    }
                }
            }
        }

        int[][] matrix2 = new int[rc2.getRows()][rc2.getCols()];

        System.out.println("Введите элементы второй матрицы:");
        for (int i = 0; i < rc2.getRows(); i++) {
            for (int j = 0; j < rc2.getCols(); j++) {
                System.out.print("Введите элемент матрицы 2 [" + i + "][" + j + "]: ");
                while (true) {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        matrix2[i][j] = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Элемент должен быть целым числом");
                    }
                }
            }
        }

        int[][] resultMatrix = new int[rc1.getRows()][rc1.getCols()];
        for (int i = 0; i < rc1.getRows(); i++) {
            for (int j = 0; j < rc1.getCols(); j++) {
                resultMatrix[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }

        System.out.println("Результат вычитания матриц:");
        for (int i = 0; i < rc1.getRows(); i++) {
            for (int j = 0; j < rc1.getCols(); j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void FourthTask() {
        System.out.println("Умножение матриц");

        System.out.println("Матрица 1:");
        CountRowsColsMatrix rc1 = createMatrix();
        System.out.println("Матрица 2:");
        CountRowsColsMatrix rc2 = createMatrix();

        if (rc1.getCols() != rc2.getRows()) {
            System.out.println("Невозможно умножить матрицы с данными размерами.");
            return;
        }

        int[][] matrix1 = new int[rc1.getRows()][rc1.getCols()];

        System.out.println("Введите элементы первой матрицы:");
        for (int i = 0; i < rc1.getRows(); i++) {
            for (int j = 0; j < rc1.getCols(); j++) {
                System.out.print("Введите элемент матрицы 1 [" + i + "][" + j + "]: ");
                while (true) {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        matrix1[i][j] = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Элемент должен быть целым числом");
                    }
                }
            }
        }

        int[][] matrix2 = new int[rc2.getRows()][rc2.getCols()];

        System.out.println("Введите элементы второй матрицы:");
        for (int i = 0; i < rc2.getRows(); i++) {
            for (int j = 0; j < rc2.getCols(); j++) {
                System.out.print("Введите элемент матрицы 2 [" + i + "][" + j + "]: ");
                while (true) {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        matrix2[i][j] = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Элемент должен быть целым числом");
                    }
                }
            }
        }

        int[][] resultMatrix = new int[rc1.getRows()][rc2.getCols()];
        for (int i = 0; i < rc1.getRows(); i++) {
            for (int j = 0; j < rc2.getCols(); j++) {
                for (int k = 0; k < rc1.getCols(); k++) {
                    resultMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        System.out.println("Результат умножения матриц:");
        for (int i = 0; i < rc1.getRows(); i++) {
            for (int j = 0; j < rc2.getCols(); j++) {
                System.out.print(resultMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void FifthTask() {
        System.out.println("Вычисление определителя");

        System.out.print("Введите порядок квадратной матрицы (2 или 3): ");
        int order;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                order = scanner.nextInt();
                if (order == 2 || order == 3) {
                    break;
                }
                System.out.println("Нужно ввести '2' или '3', другие данные не поддерживаются");
            } catch (Exception e) {
                System.out.println("Нужно ввести '2' или '3', другие данные не поддерживаются");
            }
        }

        int[][] matrix = new int[order][order];

        for (int i = 0; i < order; i++) {
            for (int j = 0; j < order; j++) {
                System.out.print("Введите элемент матрицы [" + i + "][" + j + "]: ");
                while (true) {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        matrix[i][j] = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Элемент должен быть целым числом");
                    }
                }
            }
        }

        int determinant;

        if (order == 2) {
            determinant = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {
            determinant = matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                    - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                    + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        }

        System.out.println("Определитель матрицы: " + determinant);
    }

    public static void SixthTask() {
        System.out.println("Транспонирование матрицы");
        CountRowsColsMatrix rc = createMatrix();

        int[][] matrix = new int[rc.getRows()][rc.getCols()];

        for (int i = 0; i < rc.getRows(); i++) {
            for (int j = 0; j < rc.getCols(); j++) {
                System.out.print("Введите элемент матрицы [" + i + "][" + j + "]: ");
                while (true) {
                    try {
                        Scanner scanner = new Scanner(System.in);
                        matrix[i][j] = scanner.nextInt();
                        break;
                    } catch (Exception e) {
                        System.out.println("Элемент должен быть целым числом");
                    }
                }
            }
        }

        int[][] transposedMatrix = new int[rc.getCols()][rc.getRows()];

        for (int i = 0; i < rc.getRows(); i++) {
            for (int j = 0; j < rc.getCols(); j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        System.out.println("Результат транспонирования матрицы:");
        for (int i = 0; i < rc.getCols(); i++) {
            for (int j = 0; j < rc.getRows(); j++) {
                System.out.print(transposedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
