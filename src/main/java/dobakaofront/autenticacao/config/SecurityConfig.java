package dobakaofront.autenticacao.config;

import dobakaofront.autenticacao.dominio.Usuario;
import dobakaofront.autenticacao.repositorio.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
public class SecurityConfig {

    // 1. Bean para criptografia de senha
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 2. Bean para carregar detalhes do usuário a partir do banco de dados
    @Bean
    public UserDetailsService userDetailsService(UsuarioRepository usuarioRepo) {
        return username -> {
            Usuario usuario = usuarioRepo.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
            // Converte nosso Usuario em um objeto UserDetails do Spring Security:
            return User.builder()
                    .username(usuario.getUsername())
                    .password(usuario.getPassword())  // senha já codificada no banco
                    .roles("USER")                   // atribui role padrão "USER" (Projeto 1 não diferencia roles)
                    .build();
        };
    }

    // 3. Configuração da cadeia de filtros de segurança HTTP
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/login", "/resources/**", "/css/**").permitAll()
                                // ^ Permite acesso anônimo à página de login e recursos estáticos (se houver)
                                .anyRequest().authenticated()
                        // ^ Qualquer outra requisição requer autenticação
                )
                .formLogin(form -> form
                        .loginPage("/login")              // página de login customizada (definiremos no Thymeleaf)
                        .defaultSuccessUrl("/home", true) // redireciona para /home após sucesso no login
                        .permitAll()                      // permite acesso público à página de login
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout") // redireciona para /login após logout
                        .permitAll()
                );
        return http.build();
    }
}
