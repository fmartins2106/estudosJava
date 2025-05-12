//package academy.devdojo.maratonajava.javacore.datas.dominio;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.nio.file.StandardOpenOption;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//public class test2 {
//
//    public void gerarEvento(List<EventoBase43>eventoBase43s){
//        Path pastaArquivo = Paths.get("relatorios");
//        try {
//            if (Files.notExists(pastaArquivo)){
//                Files.createDirectories(pastaArquivo);
//            }
//            Path caminhoArquivo = pastaArquivo.resolve("relatorio_evento.csv");
//            StringBuilder conteudo = new StringBuilder();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
//            conteudo.append("\"nome evento\",\"local evento\",\"data e hora\"\n");
//            for (EventoBase43 eventoBase43 : eventoBase43s) {
//                String linha = String.format("\"%s\",\"%s\",\"%s\"\n",eventoBase43.getNomerEvento()
//                        ,eventoBase43.getLocalEvento(),eventoBase43.getDataHora().format(formatter));
//                conteudo.append(linha).append("\n");
//            }
//            Files.writeString(caminhoArquivo,conteudo,StandardCharsets.UTF_8,StandardOpenOption.CREATE,
//                    StandardOpenOption.TRUNCATE_EXISTING);
//            System.out.println("Relatório gerado com sucesso:"+caminhoArquivo.toAbsolutePath());
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }
//}
