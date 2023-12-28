package med.voll.api.infra.security;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component //Para carregar uma classe/componente genérico
public class SecurtityFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        
        var tokenJWT = recuperarToken(request);
        
        //Codigo para pegar o token, validar
        System.out.println(tokenJWT);
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        //pegar o cabeçalho que está o token
        var authorizationHeader = request.getHeader("Authorization");
        if( authorizationHeader == null) {
            throw new RuntimeException("Token não enviado");
        }
        return authorizationHeader;
    }


    
}
