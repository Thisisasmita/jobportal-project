//package com.jobportal.security;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;

//import reactor.core.publisher.Mono;

//@Component
//public class JWTAuthenticationFilter implements GatewayFilter {

    //@Autowired
    //private JWTUtil jwtUtil;

    //@Override
   // public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
     //   String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        // ✅ Check for missing or invalid Authorization header
       // if (authHeader == null || !authHeader.startsWith("Bearer ")) {
         //   exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
           // return exchange.getResponse().setComplete();
       // }
//
        // ✅ Extract token
   //     String token = authHeader.substring(7);

        // ✅ Validate token
  //     if (!jwtUtil.validateToken(token)) {
    //exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
  //  return exchange.getResponse().setComplete();
//}


        // ✅ Extract username and add it to headers
   //    String userName = jwtUtil.getUserNameFromToken(token);
//
  //      ServerWebExchange mutatedExchange = exchange.mutate()
    //            .request(exchange.getRequest().mutate()
      //                  .header("userName", userName)
        //                .build())
          //      .build();

        // ✅ Continue with the filter chain
     //   return chain.filter(mutatedExchange);
   // }
//}
