When creating eureka server below is the only dependency we add.

spring-cloud-starter-netflix-eureka-server


the server port for eureka is always 8761

every eureka server internally behaves as a eureka client also



Fix api-gateway : resolved. issue was using '_' in VACCINATION_CENTER-SERVICE.
try resilience4J instead of hystrix







