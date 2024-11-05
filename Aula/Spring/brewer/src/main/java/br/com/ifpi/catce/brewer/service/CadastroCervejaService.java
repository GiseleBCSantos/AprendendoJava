package br.com.ifpi.catce.brewer.service;

import br.com.ifpi.catce.brewer.model.Cerveja;
import br.com.ifpi.catce.brewer.repository.Cervejas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroCervejaService {
    @Autowired
    private Cervejas cervejas;

    @Transactional
    public void salvar(Cerveja cerveja) {
        cervejas.save(cerveja);
    }
}
