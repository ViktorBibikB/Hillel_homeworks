package controller;

import exception.OrderDoesNotExistException;
import model.Order;
import service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders/")
@RequiredArgsConstructor
public class OrderController {
    private OrderService orderService;

    @GetMapping("/{id}")
    public @ResponseBody Order getById(@PathVariable("id") int id) throws OrderDoesNotExistException {
        return orderService.getById(id);
    }

    @GetMapping
    public @ResponseBody List<Order> getAll() {
        return orderService.getAll();
    }

    @PostMapping
    public @ResponseBody Order add(@RequestBody Order order) {
        return orderService.add(order);
    }
}