package aed;

class Debugging {
    public static void main(String[] args) {
        Debugging debugging = new Debugging();
        debugging.xor(true, false);
        int[] array1 = {1, 2, 3};
        int[] array2 = {7, -2, 4};
        debugging.iguales(array1, array2);
        debugging.ordenado(array1);
        debugging.maximo(array1);
        debugging.todosPositivos(array2);
    }
    boolean xor(boolean a, boolean b) {
        return (a || b) && !(a && b);
    }

    boolean iguales(int[] xs, int[] ys) {
        boolean res = true;

        for (int i = 0; i < xs.length; i++) {
            if (xs[i] != ys[i] || xs.length != ys.length) {
                return false;
            }
        }
        return res;
    }

    boolean ordenado(int[] xs) {
        boolean res = true;
        for (int i = 0, j = 1 ; i < (xs.length - 1); i++, j++) {
            if (xs[i] > xs[j]) {
                res = false;
            }
        }
        return res;
    }

    int maximo(int[] xs) {
        int res = xs[0];
        for (int i = 0; i < xs.length; i++) {
            if (xs[i] >= res)
                res = xs[i];
        }
        return res;
    }

    boolean todosPositivos(int[] xs) {
        boolean res = true;
        for (int x : xs) {
            if (x > 0) {
                res = true;
            } else {
                return false;
            }
        }
        return res;
    }
}
