package aed;

class Funciones {
    int cuadrado(int x) {
        int res;
        res = x * x;   
        return res ;
    }

    double distancia(double x, double y) {
        double res;
        res = Math.sqrt(x*x + y*y);
        return res;
    }

    boolean esPar(int n) {
        if (n % 2 == 0){
            return true;
        } 
        return false;
    }

    boolean esBisiesto(int n) {
        if (n % 400 == 0){
            return true;
        }
        else if (n % 100 == 0){
            return false;
        }
        else if (n % 4 == 0){
            return true;
        }
        return false;
    }

    int factorialIterativo(int n) {
        int res = 1;
        if (n == 0){
            return 1;
        } 
        else {
        for (int i = 1; i <= n; i++){
            res = i * res;
        }
            return res;
        }
        }

    int factorialRecursivo(int n) {
        int res;
        if (n == 0){
            return 1;
        }
        else {
            res = n * factorialIterativo(n-1);
        }
        return res;
    }

    boolean esPrimo(int n) {
        if (n == 0 || n == 1){
            return false;
        }
        for (int i = 2; i < n; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i = 0; i < numeros.length; i++) {
            res = numeros[i] + res;
        }
        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado){
                return i;
            }
        }
        return -1;
    }

    boolean tienePrimo(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i])){
                return true;
            }
        }
        return false;
    }

    boolean todosPares(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
        if (numeros[i] % 2 != 0){
            return false;
            }
        }
        return true;
    }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                return false;
            }
        }
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        for (int i = (s1.length() - 1), j = s2.length() - 1; i >= 0; i-- , j-- ) {
            if (s1.charAt(i) != s2.charAt(j)){
                return false;
            }
        }
        return true;
    }
}

// Prueba