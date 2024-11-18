package AlmacenarPaises;

import java.io.*;

public class PaisesBinario {
    public void crearFicheroDat(ListaPaises listaPaises) throws IOException, ClassNotFoundException {
        File fichero = new File("Paises.dat");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero));
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero));

        for (Pais pais : listaPaises.getPais()){
            oos.writeObject(pais);
        }
        oos.close();
        System.out.println("\n");
        System.out.println("En la siguiente parte se mostrarán los resultados del (fichero.dat)");
        System.out.println("\n");
        for (Pais pais : listaPaises.getPais()){
            System.out.println(ois.readObject());
        }
        ois.close();
    }
}
