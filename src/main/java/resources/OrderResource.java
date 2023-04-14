package resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import model.Order;
import services.OrderService;

import java.util.List;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {

    @Inject
    private OrderService orderService;

    @GET
    public List<Order> getAllOrders() {
        return orderService.getOrders();
    }

    @GET
    @Path("/{id}")
    public Order getOrderById(@PathParam("id") int id) {
        return orderService.getOrderById(id);
    }

    @POST
    public void addOrder(Order order) {
        orderService.addOrder(order);
    }
}
