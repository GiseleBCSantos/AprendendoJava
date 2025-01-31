package br.com.ifpi.catce.brewer.storage;

import br.com.ifpi.catce.brewer.dto.FotoDTO;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

public class FotoStorageRunnable implements Runnable {

    private MultipartFile[] files;
    private DeferredResult<FotoDTO> resultado;
    private FotoStorage fotoStorage;

    public FotoStorageRunnable(MultipartFile[] file, DeferredResult<FotoDTO> resultado, FotoStorage fotoStorage) {
        this.files = file;
        this.resultado = resultado;
        this.fotoStorage = fotoStorage;
    }

    @Override
    public void run() {
        String nomeFoto = this.fotoStorage.salvarTemporariamente(files);
        String contentType = files[0].getContentType();
        resultado.setResult(new FotoDTO(nomeFoto, contentType));
    }
}
