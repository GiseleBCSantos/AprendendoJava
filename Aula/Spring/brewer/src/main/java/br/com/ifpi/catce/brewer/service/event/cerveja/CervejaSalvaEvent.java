package br.com.ifpi.catce.brewer.service.event.cerveja;

import br.com.ifpi.catce.brewer.model.Cerveja;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

@AllArgsConstructor
@Getter
@Setter
public class CervejaSalvaEvent {

    private Cerveja cerveja;

    public boolean temFoto(){
        return !StringUtils.isEmpty(cerveja.getFoto());
    }
}
