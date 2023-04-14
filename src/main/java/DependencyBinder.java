import jakarta.inject.Singleton;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import services.OrderService;

public class DependencyBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(OrderService.class)
                .to(OrderService.class)
                .in(Singleton.class);
    }
}