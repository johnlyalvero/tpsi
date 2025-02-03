import java.util.List;

public interface IPersonaDAO {
    List<Persona> findAll() throws Exception;
    Persona findById(String codiceFiscale) throws Exception;
    void save(Persona persona) throws Exception;
    void update(Persona persona) throws Exception;
    void delete(String codiceFiscale) throws Exception;
}
