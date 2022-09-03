//package br.com.estagginc.estagg_api.controller;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//
//@RestController
//public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
//    @RequestMapping("/error")
//    public String handleError(HttpServletRequest request){
//        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
//        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
//        return String.format(
//                "<!DOCTYPE html>\n" +
//                        "<html lang=\"en\">\n" +
//                        "\n" +
//                        "<head>\n" +
//                        "    <meta charset=\"UTF-8\">\n" +
//                        "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
//                        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
//                        "    <title>Error</title>\n" +
//                        "</head>\n" +
//                        "\n" +
//                        "<body style=\"background-color: #000; color: #fff; margin: 0 auto; text-align: center\">\n" +
//                        "    <img src=\"https://conteudo.imguol.com.br/c/bol/fotos/97/2018/01/10/faustao-mostrou-que-nem-sempre-quem-sabe-faz-ao-vivo-1515582826765_300x200.jpg\"\n" +
//                        "        alt=\"\">\n" +
//                        "    <br><br>\n" +
//                        "    <H1 style=\"color: red;\">ERROOOOU</H1>\n" +
//                        "    <br><br>\n" +
//                        "    <div>\n" +
//                        "        <h2 style=\"text-decoration: underline;\">Status Code:</h2>\n" +
//                        "        <p><b>%s</b></p>\n" +
//                        "        <h2 style=\"text-decoration: underline;\">Exception Message:</h2>\n" +
//                        "        <p><b>%s</b></p>\n" +
//                        "    </div>\n" +
//                        "</body>\n" +
//                        "\n" +
//                        "</html>", statusCode, exception == null ? "N/A":exception.getMessage());
//    }
//
//    public String getErrorPath(){
//        return "/error";
//    }
//}
