package com.messenger.offerslistservice.Controller;

import com.messenger.offerslistservice.DAO.Entity.Buyer;
import com.messenger.offerslistservice.DAO.Repositories.BuyerRepository;
import com.messenger.offerslistservice.Utility.GetUserNameBySub;
import com.messenger.offerslistservice.Utility.TempUserStorage;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RestController
public class ProductListController {

    private final BuyerRepository buyerRepository;
    private final GetUserNameBySub getUserNameBySub;
    private final TempUserStorage tempUserStorage;
    private final AtomicLong counter = new AtomicLong();


    public ProductListController(BuyerRepository buyerRepository, GetUserNameBySub getUserNameBySub, TempUserStorage tempUserStorage) {
        this.buyerRepository = buyerRepository;
        this.getUserNameBySub = getUserNameBySub;

        this.tempUserStorage = tempUserStorage;
    }


    @PostMapping("/main")
    public ResponseEntity<String> productlistpage( @AuthenticationPrincipal Jwt jwt) {

        System.out.println(jwt);
        String sub = jwt.getSubject();
        System.out.println(sub);
//        session.setAttribute("username", jwt.getClaim("preferred_username"));
       String username = jwt.getClaim("preferred_username").toString();
       counter.incrementAndGet();
       System.out.println("counter: " + counter);
        tempUserStorage.put(String.valueOf(counter), username);


        if (!buyerRepository.existsBySub(sub)) {
            Buyer buyer = new Buyer();
            buyer.setSub(sub);
            buyerRepository.save(buyer);



        }
        ResponseCookie cookie = ResponseCookie.from("username", username)
                .httpOnly(false)
                .secure(true)
                .sameSite("None")
                .path("/")
                .maxAge(60 * 60 * 24 * 7)
                .build();
        return ResponseEntity.ok()
                .header("Set-Cookie", cookie.toString())
                .body("OK");

    }





//@GetMapping("/api/me")
//public Map<String, String> me(
//        @CookieValue(value = "username", required = false) String username
//) {
//    if (username == null) {
//        return Map.of("error", "no username cookie");
//    }
//
//    return Map.of("name", username);
//}
@GetMapping("/api/me")
public Map<String, String> me(@AuthenticationPrincipal Jwt jwt) {
    return Map.of("name", jwt.getClaim("preferred_username"));
}






}





