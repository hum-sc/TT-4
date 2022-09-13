package TT4;

public class Prueba {
    public static void main(String[] args) {
        Window window = new Window("Prueba", 400, 250);
        window.setVisible(true);
        int[] inte =window.getInt(2, new String[]{"Numero de nodos", "Numero de lados"}, "Bienvenido, ingrese los siguientes datos", "Continuar");
    }
}
