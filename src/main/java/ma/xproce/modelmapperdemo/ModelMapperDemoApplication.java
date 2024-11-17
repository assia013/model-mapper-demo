package ma.xproce.modelmapperdemo;

import ma.xproce.modelmapperdemo.dtos.CustomerDTO;
import ma.xproce.modelmapperdemo.entities.Customer;
import ma.xproce.modelmapperdemo.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class ModelMapperDemoApplication {

    @Autowired
    private CustomerMapper customerMapper;
    public static void main(String[] args) {
        SpringApplication.run(ModelMapperDemoApplication.class, args);
    }
    @Bean
    CommandLineRunner start(){
        return args -> {
            List<Customer> customers = List.of(
                    Customer.builder().id(1L).name("AIT ALI Assia").email("assia@gmail.com").password("qwerty").build(),
                    Customer.builder().id(2L).name("EL MAOUDDA Hind").email("hind@gmail.com").password("azerty").build(),
                    Customer.builder().id(3L).name("AIT Ali").email("ali@gmail.com").password("qwaz").build()
            );

            // Transformer les customers en customerDTO
            List<CustomerDTO> customerdtoslist = customers.stream()
                    .map(customerMapper::fromCustomer)
                    .collect(Collectors.toList());

            // Afficher la liste
            customerdtoslist.forEach(System.out::println);

        };
    }
}
