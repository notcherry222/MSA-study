import org.springframework.context.annotation.Bean;

public class CustomFeignException {

    @Bean
    public CustomFeignException getCustomFeignException() {
        return new CustomFeignException();
    }

}
