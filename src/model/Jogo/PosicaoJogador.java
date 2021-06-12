package model.Jogo;

import java.io.Serializable;

public enum PosicaoJogador implements Serializable {
    GUARDA_REDES {
        public String toString() {
            return "Guarda Redes";
        }
    },
    DEFESA {
        public String toString() {
            return "Defesa";
        }
    },
    MEDIO {
        public String toString() {
            return "Médio";
        }
    },
    AVANCADO {
        public String toString() {
            return "Avançado";
        }
    },
    LATERAL {
        public String toString() {
            return "Lateral";
        }
    }
}
