//package com.jobportal.security;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;

//@Configuration
//public class GatewayConfig {

  //  @Autowired
  //  private JWTAuthenticationFilter jwtFilter;

  //  @Bean
  //  public RouteLocator routes(RouteLocatorBuilder builder) {
    //    return builder.routes()
      //          // Auth Service
        //        .route("auth-service", r -> r.path("/api/auth/**")
          //              .uri("http://localhost:8080"))
//
  //              // Jobseeker Service
    //            .route("jobseeker-service", r -> r.path("/api/jobSeekers/**")
      //                  .filters(f -> f.filter(jwtFilter))
        //                 .uri("http://localhost:8080"))
//
  //              // Recruiter Service
    ////            .route("recruiter-service", r -> r.path("/api/recruiters/**")
        ///                .filters(f -> f.filter(jwtFilter))
           //              .uri("http://localhost:8080"))
///
   //             // Job Post Service
     //           .route("jobpost-service", r -> r.path("/api/jobposts/**")
       ///                 .filters(f -> f.filter(jwtFilter))
          ///               .uri("http://localhost:8080"))
///
   ///             // Application Service
      //          .route("application-service", r -> r.path("/api/applications/**")
        //                .filters(f -> f.filter(jwtFilter))
          ///             .uri("http://localhost:8080"))
///
   ///             // Admin Service
      ///          .route("admin-service", r -> r.path("/api/admins/**")
         ///               .filters(f -> f.filter(jwtFilter))
            //             .uri("http://localhost:8080"))
///
   ///             // Email / Notification Service
      //          .route("email-service", r -> r.path("/api/notifications/**")
          //              .filters(f -> f.filter(jwtFilter))
            //            .uri("http://localhost:8080"))
        ////        // File Upload Service
              //  .route("fileupload-service", r -> r.path("/api/upload/**")
                //        .filters(f -> f.filter(jwtFilter))
                  //      .uri("http://localhost:8080"))
//
  //              // Payment Service
    //            .route("payment-service", r -> r.path("/api/payment/**")
      //                  .filters(f -> f.filter(jwtFilter))
        //               .uri("http://localhost:8080"))
//
  //              // Dashboard Service
    //            .route("dashboard-service", r -> r.path("/api/dashboards/**")
      //                  .filters(f -> f.filter(jwtFilter))
        //                .uri("http://localhost:8080"))
//
  //              .build();
    //}
//}
