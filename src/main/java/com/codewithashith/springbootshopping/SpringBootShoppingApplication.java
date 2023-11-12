package com.codewithashith.springbootshopping;

import com.codewithashith.springbootshopping.repository.UserRepository;
import com.codewithashith.springbootshopping.request.AddressRequest;
import com.codewithashith.springbootshopping.request.CategoryRequest;
import com.codewithashith.springbootshopping.request.RegisterRequest;
import com.codewithashith.springbootshopping.service.AddressService;
import com.codewithashith.springbootshopping.service.CategoryService;
import com.codewithashith.springbootshopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootShoppingApplication implements CommandLineRunner {

//    http://localhost:8080/swagger-ui/

    @Autowired
    CategoryService categoryService;
    @Autowired
    AddressService addressService;
    @Autowired
    UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootShoppingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(categoryService.create(new CategoryRequest("Fiction")));
        System.out.println(categoryService.create(new CategoryRequest("Fantasy")));
        System.out.println(categoryService.create(new CategoryRequest("Science")));

        System.out.println(categoryService.update(new CategoryRequest(1L, "Action")));
        System.out.println(categoryService.deleteById(3));

        AddressRequest addressRequest = new AddressRequest();
        addressRequest.setUserId(1L);
        addressRequest.setAddress("Tambaramaa");
        addressRequest.setCity("Chennai");
        addressRequest.setZipcode(600045);

        AddressRequest addressRequestUpdate = new AddressRequest();
        addressRequestUpdate.setId(1L);
        addressRequestUpdate.setUserId(1L);
        addressRequestUpdate.setAddress("Tambaram");
        addressRequestUpdate.setCity("Chennai");
        addressRequestUpdate.setZipcode(600045);

        AddressRequest addressRequestDelete = new AddressRequest();
        addressRequestDelete.setUserId(1L);
        addressRequestDelete.setAddress("Tambaram");
        addressRequestDelete.setCity("Chennai");
        addressRequestDelete.setZipcode(600045);

        System.out.println(addressService.create(addressRequest));
        System.out.println(addressService.create(addressRequestDelete));

        System.out.println(addressService.update(addressRequestUpdate));
        System.out.println(addressService.deleteById(2L));

    }
}
