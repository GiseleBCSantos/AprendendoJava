package br.com.ifpi.catce.brewer.controller.converter;

import br.com.ifpi.catce.brewer.model.Estilo;
import ch.qos.logback.core.util.StringUtil;
import org.springframework.core.convert.converter.Converter;

public class EstiloConverter implements Converter<String, Estilo> {

    @Override
    public Estilo convert(String codigo) {
        if (!StringUtil.isNullOrEmpty(codigo)) {
            Estilo estilo = new Estilo();
            estilo.setCodigo(Long.valueOf(codigo));
            return estilo;
        }

        return null;
    }

}
