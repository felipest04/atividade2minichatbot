import java.util.Scanner;

public class miniChatbot {

    public static void main(String[] args) {
        miniChatbot chatbot = new miniChatbot();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao MiniChatbot! Digite 'sair' para encerrar a conversa.");

        while (true) {
            System.out.print("Você: ");
            String entradaUsuario = scanner.nextLine().toLowerCase(); // Converter para minúsculas para simplificar a detecção.

            if (entradaUsuario.equals("sair")) {
                System.out.println("MiniChatbot: Foi um prazer conversar com você! Até mais!");
                break;
            }

            String resposta = chatbot.gerarResposta(entradaUsuario);
            System.out.println("MiniChatbot: " + resposta);
        }

        scanner.close();
    }

    // Método principal para gerar respostas
    public String gerarResposta(String entrada) {
        if (containsKeyword(entrada, "olá") || containsKeyword(entrada, "oi")) {
            return responderSaudacao();
        } else if (containsKeyword(entrada, "seu nome")) {
            return responderNome();
        } else if (containsKeyword(entrada, "como você está")) {
            return responderComoEstou();
        } else {
            return responderPadrao();
        }
    }

    // Funções específicas para as respostas
    private String responderSaudacao() {
        return "Olá! Como posso ajudar você hoje?";
    }

    private String responderNome() {
        return "Meu nome é MiniChatbot! Estou aqui para ajudar.";
    }

    private String responderComoEstou() {
        return "Estou funcionando perfeitamente, obrigado por perguntar!";
    }

    private String responderPadrao() {
        return "Desculpe, não entendi sua pergunta. Pode reformular?";
    }

    // Método utilitário para detectar palavras-chave
    private boolean containsKeyword(String entrada, String keyword) {
        return entrada.contains(keyword);
    }
}
