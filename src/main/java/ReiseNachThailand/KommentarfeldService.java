package ReiseNachThailand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KommentarfeldService {
    @Autowired
    private KommentarfeldRepository kommentarfeldRepository;


    public Iterable<Kommentarfeld> getKommentarfelde() {
        return kommentarfeldRepository.findAll();
    }

    public void addEintrag(Kommentarfeld kommentarfeldg) {
        kommentarfeldRepository.save(kommentarfeldg);
    }
}
