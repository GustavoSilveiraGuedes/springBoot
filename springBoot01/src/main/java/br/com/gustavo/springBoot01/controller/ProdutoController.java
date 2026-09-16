package br.com.gustavo.springBoot01.controller;

import br.com.gustavo.springBoot01.database.model.ProdutoModel;
import br.com.gustavo.springBoot01.dto.ProdutoDto;
import br.com.gustavo.springBoot01.exception.NotFoundExeption;
import br.com.gustavo.springBoot01.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/produtos")
public class ProdutoController {


    private final ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<List<ProdutoModel>> findAll(){
        return new ResponseEntity<>(produtoService.findAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProdutoModel> addProduto(@RequestBody ProdutoDto produtoDto){
        return new ResponseEntity<>(produtoService.addProduto(produtoDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> updateProduto(@RequestBody ProdutoDto produtoDto,@PathVariable("id") Integer id) throws NotFoundExeption {
        return new ResponseEntity<>(produtoService.updateProduto(produtoDto, id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduto(@PathVariable Integer id){
        produtoService.deleteProduto(id);
    }

}