package model.Jogo;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum ModeloTatico {
  QUATRO_QUATRO_DOIS("4-4-2"),
  QUATRO_TRES_TRES("4-3-3"),
  TRES_CINCO_DOIS("3-5-2");

  private final String modeloTatico;
  ModeloTatico(String modeloTatico) {
      this.modeloTatico = modeloTatico;
  }
  private static final ModeloTatico[] MODELOS = ModeloTatico.values();
  private static final Random random = new Random();
  public static ModeloTatico getRandomModeloTatico() {
      return MODELOS[random.nextInt(MODELOS.length)];
  }
  public String getModeloTatico() {
    return  this.modeloTatico;
  }
}
