package br.com.estagginc.estagg_api.view;

import org.springframework.stereotype.Component;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

@Component
public class StringFormatter {
    public StringFormatter() {
    }

    public static String formatString(String texto, String mascara) throws ParseException {
        MaskFormatter mf = new MaskFormatter(mascara);
        mf.setValueContainsLiteralCharacters(false);
        return mf.valueToString(texto);
    }

//"(##) #####-####" para celulares
//"(##) ####-####" para telefones fixos

    public String formatCpf(String cpf) throws ParseException {
        return formatString(cpf,  "###.###.###-##");
    }

}
