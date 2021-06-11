package model.Jogo;

import model.Equipa.Equipa;
import model.Equipa.SetupEquipa;
import model.FootballManagerModel;
import model.Jogador.Jogador;
import model.Jogo.Evento.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Jogo implements Serializable {
    private String equipaCasa;
    private String equipaFora;
    private int golosCasa;
    private int golosFora;
    private LocalDate date;
    private SetupEquipa setupEquipaCasa;
    private SetupEquipa setupEquipaFora;
    Map<Integer, Integer> substituicoesCasa;
    Map<Integer, Integer> substitucoesFora;
    private Random random;
    private EventoJogo ultimoEvento;
    private double tempoComBola;
    private String equipaEmPosse;
    private int jogadorEmPosse;
    private boolean passouIntervalo;
    private static final long serialVersionUID = 6L;


    /***
     * Cria um jogo vazio
     */
    public Jogo() {
        date = LocalDate.now();
        substituicoesCasa = new HashMap<>();
        substitucoesFora = new HashMap<>();
        random = new Random();
        passouIntervalo = false;
    }

    /***
     * Cria um jogo novo, a decorrer neste momento, entre duas equipas, com um setup aleatório
     * @param ec a equipa de casa
     * @param ef a equipa de fora
     */
    public Jogo(Equipa ec, Equipa ef){
        equipaCasa = ec.getNome();
        equipaFora = ef.getNome();
        date = LocalDate.now();
        this.setupEquipaCasa = new SetupEquipa(ec); // random setup
        this.setupEquipaFora = new SetupEquipa(ef); // random setup
        substituicoesCasa = new HashMap<>();
        substitucoesFora = new HashMap<>();
        random = new Random();
        passouIntervalo = false;
    }

    /**
     * Construtor parameterizado de um jogo
     * @param ec Equipa de casa
     * @param ef Equipa de fora
     * @param gc Golos da casa
     * @param gf Golos de fora
     * @param d Data do jogo
     * @param jc Jogadores da equipa de casa
     * @param sc Setup da equipa de casa
     * @param jf Jogadores da equipa de fora
     * @param sf Setup da equipa de fora
     */
    public Jogo(String ec, String ef, int gc, int gf, LocalDate d, List<Integer> jc, Map<Integer, Integer> sc, List<Integer> jf, Map<Integer, Integer> sf){
        equipaCasa = ec;
        equipaFora = ef;
        golosCasa = gc;
        golosFora = gf;
        date = d;
        this.setupEquipaCasa = new SetupEquipa(jc);
        this.setupEquipaFora = new SetupEquipa(jf);
        substituicoesCasa = new HashMap<>(sc);
        substitucoesFora = new HashMap<>(sf);
        random = new Random();
        passouIntervalo = false;
    }

    /**
     * Construtor de cópia de um jogo
     * @param jogo Jogo a copiar
     */
    public Jogo(Jogo jogo) {
        this.equipaCasa = jogo.getEquipaCasa();
        this.equipaFora = jogo.getEquipaFora();
        this.golosCasa = jogo.getGolosCasa();
        this.golosFora = jogo.getGolosFora();
        this.date = jogo.getDate();
        this.setupEquipaCasa = jogo.getSetupEquipaCasa();
        this.setupEquipaFora = jogo.getSetupEquipaFora();
        this.substituicoesCasa = jogo.getSubstituicoesCasa();
        this.substitucoesFora = jogo.getSubstitucoesFora();
        this.ultimoEvento = jogo.getUltimoEvento();
        this.tempoComBola = jogo.getTempoComBola();
        this.random = jogo.random;
        this.passouIntervalo = jogo.getPassouIntervalo();
    }

    private boolean getPassouIntervalo() {
        return passouIntervalo;
    }

    public SetupEquipa getSetupEquipaCasa() {
        return setupEquipaCasa.clone();
    }

    public void setSetupEquipaCasa(SetupEquipa setupEquipaCasa) {
        this.setupEquipaCasa = setupEquipaCasa.clone();
    }

    public SetupEquipa getSetupEquipaFora() {
        return setupEquipaFora.clone();
    }

    public void setSetupEquipaFora(SetupEquipa setupEquipaFora) {
        this.setupEquipaFora = setupEquipaFora.clone();
    }

    public String getEquipaCasa() {
        return equipaCasa;
    }

    public void setEquipaCasa(Equipa equipaCasa) {
        this.equipaCasa = equipaCasa.getNome();
        this.setupEquipaCasa = new SetupEquipa(equipaCasa);
    }
    public void setEquipaCasa(String equipaCasa) {
        this.equipaCasa = equipaCasa;
    }

    public String getEquipaFora() {
        return equipaFora;
    }
    public void setEquipaFora(Equipa equipaFora) {
        this.equipaFora = equipaFora.getNome();
        this.setupEquipaFora = new SetupEquipa(equipaFora);
    }

    public void setEquipaFora(String equipaFora) {
        this.equipaFora = equipaFora;
    }

    public int getGolosCasa() {
        return golosCasa;
    }

    public void setGolosCasa(int golosCasa) {
        this.golosCasa = golosCasa;
    }

    public int getGolosFora() {
        return golosFora;
    }

    public void setGolosFora(int golosFora) {
        this.golosFora = golosFora;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Map<Integer, Integer> getSubstituicoesCasa() {
        return substituicoesCasa;
    }

    public void setSubstituicoesCasa(Map<Integer, Integer> substituicoesCasa) {
        this.substituicoesCasa = substituicoesCasa;
    }

    public Map<Integer, Integer> getSubstitucoesFora() {
        return substitucoesFora;
    }

    public void setSubstitucoesFora(Map<Integer, Integer> substitucoesFora) {
        this.substitucoesFora = substitucoesFora;
    }

    public EventoJogo getUltimoEvento() {
        return ultimoEvento;
    }

    public void setUltimoEvento(EventoJogo ultimoEvento) {
        this.ultimoEvento = ultimoEvento;
    }

    public static Jogo parse(String input){
        String[] campos = input.split(",");
        String[] data = campos[4].split("-");
        List<Integer> jc = new ArrayList<>();
        List<Integer> jf = new ArrayList<>();
        Map<Integer, Integer> subsC = new HashMap<>();
        Map<Integer, Integer> subsF = new HashMap<>();
        for (int i = 5; i < 16; i++){
            jc.add(Integer.parseInt(campos[i]));
        }
        for (int i = 16; i < 19; i++){
            String[] sub = campos[i].split("->");
            subsC.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        for (int i = 19; i < 30; i++){
            jf.add(Integer.parseInt(campos[i]));
        }
        for (int i = 30; i < 33; i++){
            String[] sub = campos[i].split("->");
            subsF.put(Integer.parseInt(sub[0]), Integer.parseInt(sub[1]));
        }
        return new Jogo(campos[0], campos[1], Integer.parseInt(campos[2]), Integer.parseInt(campos[3]),
                LocalDate.of(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2])),
                jc, subsC, jf, subsF);
    }
    public Jogo clone() {
        return new Jogo(this);
    }

    public String toString() {
        return  "Jogo:" + equipaCasa + " - " + equipaFora;
        //+ " -> " + substituicoesCasa.toString()
        //+ " -> " + substitucoesFora.toString();
    }

    public void setModeloTaticoCasa(ModeloTatico mt) {
        if (setupEquipaCasa == null) System.out.println("tone");
        this.setupEquipaCasa.setModeloTatico(mt);
    }

    public void setModeloTaticoFora(ModeloTatico mt) {
        this.setupEquipaFora.setModeloTatico(mt);
    }

    private double getTempoComBola() {
        return tempoComBola;
    }

    private void setTempoComBola(double tempoComBola) {
        this.tempoComBola = tempoComBola;
    }

    /**
     * Função privada que simplesmente devolve o setup da equipa com posse da bola
     * @return o SetupEquipa da equipa que tem a bola
     */
    private SetupEquipa getSetupComBola() {
        if (equipaEmPosse.equals(equipaCasa))
            return setupEquipaCasa;
        return setupEquipaFora;
    }

    /**
     * Função privada que devolve o setup da equipa sem a bola
     * @return O SetupEquipa da equipa que não possui a bola
     */
    private SetupEquipa getSetupSemBola() {
        if (equipaEmPosse.equals(equipaCasa))
            return setupEquipaFora;
        return setupEquipaCasa;
    }

    /**
     * Devolve o nome da equipa que não possui a bola
     * @return O nome da equipa que não possui a bola
     */
    private String getEquipaSemPosse() {
        if (equipaEmPosse.equals(equipaCasa))
            return equipaFora;
        return equipaCasa;
    }

    /**
     * Aumenta a quantidade de golos da equipa atual
     */
    private void aumentarGolosAtual() {
        if (equipaEmPosse.equals(equipaCasa))
            golosCasa++;
        else
            golosFora++;
    }

    /**
     * Tenta passar a bola para um jogador da mesma equipa
     * @param model O modelo
     * @param jogador O jogador a quem passar a bola
     * @return O evento de passagem de bola
     */
    private PassagemBola tentaPassarBola(FootballManagerModel model, double tempo, int jogador) {
        Jogador jogadorAtual = model.getEquipa(equipaEmPosse).getJogador(jogadorEmPosse);
        double probabilidadeConseguirPassar = (double) jogadorAtual.getPasse() / 100;
        List<Integer> defesasAdversarios = getSetupSemBola().getDefesas();
        int nDefesaAdversario = defesasAdversarios.get(random.nextInt(defesasAdversarios.size()));
        Jogador jogadorDefesa = model.getEquipa(getEquipaSemPosse()).getJogador(nDefesaAdversario);

        // Dividimos por 1000, para que nunca seja mais do que 10%
        double probabilidadeDefender = jogadorDefesa.getHabilidade() / 1000;

        if (random.nextDouble() < probabilidadeConseguirPassar && random.nextDouble() > probabilidadeDefender) {
            PassagemBola p = new PassagemBola(ultimoEvento.getTempo() + tempo, equipaEmPosse, jogadorEmPosse, equipaEmPosse, jogador);
            tempoComBola += tempo;
            jogadorEmPosse = jogador;
            return p;
        } else {
            PassagemBola p = new PassagemBola(ultimoEvento.getTempo() + tempo, equipaEmPosse, jogadorEmPosse, getEquipaSemPosse(), nDefesaAdversario);
            tempoComBola = 0;
            equipaEmPosse = getEquipaSemPosse();
            jogadorEmPosse = nDefesaAdversario;
            return p;
        }
    }

    /**
     * Tenta marcar um golo com o jogador atual
     * @param model O modelo
     * @return O eventual evento de marcar um golo, ou outro, caso não seja possível marcar
     */
    private EventoJogo tentaMarcar(FootballManagerModel model, double tempo) {
        Jogador jogadorAtual = model.getEquipa(equipaEmPosse).getJogador(jogadorEmPosse);
        double probabilidadeConseguirMarcar = (double) jogadorAtual.getRemate() / 100;
        Jogador guardaRedes = model.getEquipa(getEquipaSemPosse()).getJogador(getSetupSemBola().getGuardaRedes());
        double probabilidadeDefender = guardaRedes.getHabilidade() / 125; // Máx. 80% probabilidade de defender

        if (random.nextDouble() < probabilidadeConseguirMarcar && random.nextDouble() > probabilidadeDefender) {
            // Conseguimos marcar!
            aumentarGolosAtual();
            tempoComBola = 0;
            return new Golo(ultimoEvento.getTempo() + tempo, equipaEmPosse, jogadorEmPosse, getEquipaSemPosse());
        } else {
            PassagemBola p = new PassagemBola(ultimoEvento.getTempo() + tempo, equipaEmPosse, jogadorEmPosse, getEquipaSemPosse(), guardaRedes.getNumeroJogador());
            tempoComBola = 0;
            equipaEmPosse = getEquipaSemPosse();
            jogadorEmPosse = guardaRedes.getNumeroJogador();
            return p;
        }
    }

    private Substituicao executaSubstituicao(double tempo) {
        if (random.nextBoolean()) {
            // Equipa de casa
            if (substituicoesCasa.size() > 0) {
                int aSubstituir = (int) substituicoesCasa.keySet().toArray()[random.nextInt(substituicoesCasa.size())];
                setupEquipaCasa.substituir(aSubstituir, substituicoesCasa.get(aSubstituir));
                if (equipaEmPosse.equals(equipaCasa) && jogadorEmPosse == aSubstituir) {
                    jogadorEmPosse = substituicoesCasa.get(aSubstituir);
                }
                return new Substituicao(tempo + ultimoEvento.getTempo(), equipaCasa, aSubstituir, substituicoesCasa.get(aSubstituir));
            }
        } else {
            if (substitucoesFora.size() > 0) {
                int aSubstituir = (int) substitucoesFora.keySet().toArray()[random.nextInt(substitucoesFora.size())];
                setupEquipaFora.substituir(aSubstituir, substitucoesFora.get(aSubstituir));
                if (equipaEmPosse.equals(equipaFora) && jogadorEmPosse == aSubstituir) {
                    jogadorEmPosse = substitucoesFora.get(aSubstituir);
                }
                return new Substituicao(tempo + ultimoEvento.getTempo(), equipaFora, aSubstituir, substitucoesFora.get(aSubstituir));
            }
        }

        return null;
    }

    /***
     * Avança a simulação até ao próximo evento
     * @param model O modelo a utilizar para avançar a simulação
     * @return O próximo evento a ocorrer. Se for null, o jogo acabou.
     */
    public EventoJogo avancaSimulacao(FootballManagerModel model) {
        if (ultimoEvento == null || ultimoEvento.getClass() == Intervalo.class) {
            // Se o último evento for nulo, significa que o jogo vai começar, portanto determinamos a equipa que começa
            // com uma "moeda ao ar", ou seja, 50/50 para quem tem posse de bola.
            if (random.nextBoolean()) {
                equipaEmPosse = equipaCasa;
                jogadorEmPosse = setupEquipaCasa.getAvancados().get(0);
            } else {
                equipaEmPosse = equipaFora;
                jogadorEmPosse = setupEquipaFora.getAvancados().get(0);
            }

            ultimoEvento = new PosseBola(0.0, equipaEmPosse, jogadorEmPosse);
        } else if (ultimoEvento.getClass() == Golo.class) {
            equipaEmPosse = getEquipaSemPosse();
            jogadorEmPosse = getSetupComBola().getAvancados().get(0);

            ultimoEvento = new PosseBola(ultimoEvento.getTempo(), equipaEmPosse, jogadorEmPosse);
        } else {
            double tempoPassado = random.nextDouble() * 2 + 5; // Entre 3 e 7s
            if (tempoPassado + ultimoEvento.getTempo() >= 45 * 60 && !passouIntervalo) {
                // Meio tempo, intervalo!
                passouIntervalo = true;
                ultimoEvento = new Intervalo(45 * 60);
            } else if (tempoPassado + ultimoEvento.getTempo() >= 90 * 60) {
                // O jogo acabou!
                ultimoEvento = null;
            } else {
                boolean substituiu = false;

                if (passouIntervalo) {
                    // Podemos fazer substituições
                    if (random.nextDouble() > 0.80) {
                        Substituicao s = executaSubstituicao(tempoPassado);
                        if (s != null) {
                            ultimoEvento = s;
                            substituiu = true;
                        }
                    }
                }

                if (!substituiu) {
                    // Se a mesma equipa esteve 30 segundos com a bola, significa que chegaram perto da baliza e podem tentar rematar!
                    if (tempoComBola + tempoPassado > 30) {
                        if (getSetupComBola().getPosicaoJogador(jogadorEmPosse) != PosicaoJogador.AVANCADO) {
                            List<Integer> avancados = getSetupComBola().getAvancados();
                            int avancado = avancados.get(random.nextInt(avancados.size()));
                            ultimoEvento = tentaPassarBola(model, tempoPassado, avancado);
                        } else {
                            ultimoEvento = tentaMarcar(model, tempoPassado);
                        }
                    } else {
                        List<Integer> jogadoresAPassar = getSetupComBola().getAvancados();
                        jogadoresAPassar.addAll(getSetupComBola().getMedios());
                        int jogador = jogadoresAPassar.get(random.nextInt(jogadoresAPassar.size()));

                        ultimoEvento = tentaPassarBola(model, tempoPassado, jogador);
                    }
                }
            }
        }

        return ultimoEvento;
    }
}

