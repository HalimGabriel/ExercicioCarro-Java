import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            Car carro = new Car();

            int opcao = -1;

            do {

                System.out.println("\n=== MENU DO CARRO ===");
                System.out.println("1 - Ligar carro");
                System.out.println("2 - Desligar carro");
                System.out.println("3 - Acelerar");
                System.out.println("4 - Diminuir velocidade");
                System.out.println("5 - Virar para esquerda");
                System.out.println("6 - Virar para direita");
                System.out.println("7 - Aumentar marcha");
                System.out.println("8 - Diminuir marcha");
                System.out.println("9 - Verificar Status do carro");
                System.out.println("0 - Sair");

                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                } else {
                    System.out.println("Digite apenas números!");
                    scanner.next();
                    continue;
                }

                switch (opcao) {
                    case 1:
                        carro.ligar();
                        break;
                    case 2:
                        carro.desligar();
                        break;
                    case 3:
                        carro.acelerar();
                        break;
                    case 4:
                        carro.diminuirVelocidade();
                        break;
                    case 5:
                        carro.virarEsquerda();
                        break;
                    case 6:
                        carro.virarDireita();
                        break;
                    case 7:
                        carro.aumentarMarcha();
                        break;
                    case 8:
                        carro.diminuirMarcha();
                        break;
                    case 9:
                        carro.verificarStatus();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!!!");

                }
                if (opcao != 0 && opcao != 2 && opcao != 9) {
                    carro.verificarVelocidade();
                }

            } while (opcao != 0);

            scanner.close();
        }
    }
