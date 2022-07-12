//
//package com.integrador.tp.security;
//
//import java.io.IOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//
//public class JwtTokenFilter extends OncePerRequestFilter {
//    
//    private final static Logger log = LoggerFactory.getLogger(JwtProvider.class);
//    @Autowired JwtProvider jwtProvider;
//    
//    @Override
//    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws ServletException, IOException {
//         try{
//             String token = this.getToken(req);
//             if (token != null && jwtProvider.validateToken(token)){
//                 String idUsuario = jwtProvider.getUsuarioToken(token);
//                 
//             }
//         }catch(Exception e){
//             log.error("error del metodo doFilter");
//         }
//    }
//    
//    private String getToken(HttpServletRequest request){
//        String header = request.getHeader("Authorization");
//        if (header != null && header.startsWith("Bearer")){
//            return header.replace("Bearer ", "");
//        }else{
//            return null;
//        }
//    }
//    
//}
