package model.Jogo;
import java.util.*;

//public enum ModeloTatico {
//  QUATRO_QUATRO_DOIS("4-4-2"),
//  QUATRO_TRES_TRES("4-3-3"),
//  TRES_CINCO_DOIS("3-5-2");
//  private final String modeloTatico;
//
//  ModeloTatico(String modeloTatico) {
//      this.modeloTatico = modeloTatico;
//  }
//  private static final ModeloTatico[] MODELOS = ModeloTatico.values();
//  private static final Random random = new Random();
//  public static ModeloTatico getRandomModeloTatico() {
//      return MODELOS[random.nextInt(MODELOS.length)];
//  }
//  public String getModeloTatico() {
//    return this.modeloTatico;
//  }
//}

public class ModeloTatico {
    private int numDefesas;
    private int numMedios;
    private int numAvancados;

    public ModeloTatico(int numDefesas, int numMedios, int numAvancados) {
        this.numDefesas = numDefesas;
        this.numMedios = numMedios;
        this.numAvancados = numAvancados;
    }

    public int getNumDefesas() {
        return numDefesas;
    }

    public void setNumDefesas(int numDefesas) {
        this.numDefesas = numDefesas;
    }

    public int getNumMedios() {
        return numMedios;
    }

    public void setNumMedios(int numMedios) {
        this.numMedios = numMedios;
    }

    public int getNumAvancados() {
        return numAvancados;
    }

    public void setNumAvancados(int numAvancados) {
        this.numAvancados = numAvancados;
    }

    public static List<ModeloTatico> getModelos() {
        List<ModeloTatico> modelos = new ArrayList<>();
        modelos.add(new ModeloTatico(4,4,2));
        modelos.add(new ModeloTatico(4,3,3));
        modelos.add(new ModeloTatico(3,5,2));

        return modelos;
    }

    public static ModeloTatico getRandomModeloTatico() {
        Random r = new Random();
        List<ModeloTatico> modelos = getModelos();
        return modelos.get(r.nextInt(modelos.size()));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("1-");
        sb.append(numDefesas);
        sb.append("-");
        sb.append(numMedios);
        sb.append("-");
        sb.append(numAvancados);

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModeloTatico that = (ModeloTatico) o;
        return numDefesas == that.numDefesas && numMedios == that.numMedios && numAvancados == that.numAvancados;
    }

    public ModeloTatico clone() {
        return new ModeloTatico(numDefesas, numMedios, numAvancados);
    }
}