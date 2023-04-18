package controller;

import exceptions.ProductDoesNotExistException;
import model.dto.ProductDto;
import model.entity.Product;
import service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<ProductDto> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ProductDto getById(@PathVariable("id") long id) throws ProductDoesNotExistException {
        return productService.getById(id);
    }

}
