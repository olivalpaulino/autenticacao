package dobakaofront.autenticacao.config;

import dobakaofront.autenticacao.dominio.Usuario;
import dobakaofront.autenticacao.repositorio.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {
    @Bean
    CommandLineRunner loadInitialData(UsuarioRepository usuarioRepo) {
        return args -> {
            if(usuarioRepo.count() == 0) {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                Usuario user = new Usuario();
                user.setUsername("joao");
                user.setPassword( encoder.encode("12345") ); // senha "12345" criptografada
                usuarioRepo.save(user);
            }
        };
    }
}
