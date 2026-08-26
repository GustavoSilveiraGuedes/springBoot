package br.com.gustavo.springBoot01.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hello")
public class HelloWorldController {

    @GetMapping
    public ResponseEntity < String > get() {
        return new ResponseEntity<>("Hello World GET", HttpStatus.OK);
    }

    @GetMapping("/{id1}&{id2}")
    public ResponseEntity < String > get(@PathVariable int id1, @PathVariable int id2) {
        return new ResponseEntity<>("Hello World " + (id1 + id2), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity < String > post() {
        return new ResponseEntity<>("Hello World POST",HttpStatus.CREATED);
    }

}
