public class Car {

    private boolean ligado;

    private int velocidade;

    private int marcha;

    public Car(){

        this.marcha = 0;
        this.velocidade = 0;
        this.ligado = false;

    }

    public void ligar(){
        if (ligado){
            System.out.println("O carro já está ligado!");
            return;
        }

        ligado = true;
        System.out.println("O carro foi ligado com sucesso!");

    }

    public void acelerar() {
        if (!ligado) {
            System.out.println("O carro está desligado! Não é possível acelerar.");
            return;
        }

        if (marcha == 0) {
            System.out.println("O carro está em ponto morto! Troque a marcha para acelerar.");
            return;
        }

        int limite = limiteDaMarchaAtual(marcha);
        if (velocidade >= limite) {
            System.out.println("Você já atingiu a velocidade máxima da marcha atual! Troque a marcha.");
            return;
        }

        velocidade += 1;
        System.out.println("Seu carro acelerou 1km/h. Velocidade atual: " + velocidade + "km/h");
    }



    public void diminuirVelocidade(){
        if (!ligado){
            System.out.println("O carro está desligado! Não é possível desacelerar.");
            return;
        }

        if (velocidade == 0){
            System.out.println("Seu carro está parado!");
            return;
        }

        int limiteMin = limiteMinDaMarcha(marcha);
        if (velocidade - 1 < limiteMin) {
            System.out.println("Não é possível diminuir mais sem reduzir a marcha. Velocidade mínima para a marcha atual: "
                    + limiteMin + "km/h");
            return;
        }

        velocidade -= 1;
        System.out.println("Velocidade diminuída. Velocidade atual: " + velocidade + "km/h");

    }

    public void desligar(){
        if (velocidade != 0) {
            System.out.println("Diminua a velocidade do carro a 0 para poder desligar.");
            return;
        }

        if (marcha != 0) {
            System.out.println("Deixe o carro em ponto neutro antes de desligar.");
            return;
        }

        ligado = false;
        System.out.println("Carro desligado com sucesso!");

    }

    public void virarEsquerda() {
        if (!podeVirar()) return;
        System.out.println("O carro virou para a esquerda.");
    }

    public void virarDireita() {
        if (!podeVirar()) return;
        System.out.println("O carro virou para a direita.");
    }


    public void verificarVelocidade() {
        System.out.println("A velocidade atual: " + velocidade + " Km/h || Marcha atual: " + marcha);
    }

    public void aumentarMarcha(){
        if (!ligado){
            System.out.println("O carro está desligado! Não é possível mudar a marcha.");
            return;
        }

        if (marcha == 6){
            System.out.println("Você já está na 6º marcha");
            return;
        }

        int proximaMarcha = marcha + 1;

        if (velocidade < limiteMinDaMarcha(proximaMarcha)) {
            System.out.println("Velocidade muito baixa para aumentar a marcha.");
            return;
        }

        marcha = proximaMarcha;
        System.out.println("Marcha atual: " + marcha);

    }

    public void diminuirMarcha(){
        if (!ligado){
            System.out.println("O carro está desligado! Não é possível mudar a marcha.");
            return;
        }

        if (marcha == 0){
            System.out.println("O carro já está em ponto morto.");
            return;
        }

        int proximaMarcha = marcha - 1;

        if (velocidade > limiteDaMarchaAtual(proximaMarcha)) {
            System.out.println("Velocidade muito alta para diminuir a marcha.");
            return;
        }

        marcha = proximaMarcha;

        if (marcha == 0) {
            System.out.println("Você colocou o carro em ponto morto.");
        } else {
            System.out.println("Marcha atual: " + marcha);
        }

    }

    private boolean podeVirar() {
        if (!ligado) {
            System.out.println("O carro está desligado! Não é possível virar.");
            return false;
        }

        if (velocidade < 1 || velocidade > 40) {
            System.out.println("Você só pode virar entre 1km/h e 40km/h. Velocidade atual: " + velocidade + "km/h");
            return false;
        }

        return true;
    }

    private int limiteMinDaMarcha(int marcha) {
        switch (marcha) {
            case 0: return 0;
            case 1: return 0;
            case 2: return 20;
            case 3: return 40;
            case 4: return 60;
            case 5: return 80;
            case 6: return 100;
            default: throw new IllegalStateException("Marcha inválida " + marcha);
        }
    }

    private int limiteDaMarchaAtual(int marcha) {
        switch (marcha) {
            case 0: return 0;
            case 1: return 20;
            case 2: return 40;
            case 3: return 60;
            case 4: return 80;
            case 5: return 100;
            case 6: return 120;
            default: throw new IllegalStateException("Marcha inválida " + marcha);
        }
    }

    public void verificarStatus() {
        System.out.println("\n=== STATUS DO CARRO ===");
        System.out.println("Ligado: " + (ligado ? "Sim" : "Não"));
        System.out.println("Velocidade: " + velocidade + " km/h");
        System.out.println("Marcha: " + (marcha == 0 ? "Ponto morto" : marcha + "ª"));
    }

}
