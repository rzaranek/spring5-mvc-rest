package guru.springfamework.bootstrap;

import guru.springfamework.domain.Category;
import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.CategoryRepository;
import guru.springfamework.repositories.CustomerRepository;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by jt on 9/24/17.
 */
@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepository categoryRespository;
    private CustomerRepository customerRepository;

    private VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository,
                     VendorRepository vendorRepository) {
        this.categoryRespository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCategory();
        loadCustomer();
        loadVendors();
    }

    private void loadCategory() {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRespository.save(fruits);
        categoryRespository.save(dried);
        categoryRespository.save(fresh);
        categoryRespository.save(exotic);
        categoryRespository.save(nuts);

        System.out.println("Category Data Loaded = " + categoryRespository.count());
    }

    private void loadCustomer() {
        Customer apple = new Customer();
        apple.setLastname("Apple");

        Customer pollack = new Customer();
        pollack.setLastname("Pollack");

        Customer green = new Customer();
        green.setLastname("Green");

        customerRepository.save(apple);
        customerRepository.save(pollack);
        customerRepository.save(green);

        System.out.println("Customer Data Loaded = " + customerRepository.count());
    }

    private void loadVendors() {
        Vendor apple = new Vendor();
        apple.setName("Apple Corp.");

        Vendor ibm = new Vendor();
        ibm.setName("IBM");

        Vendor microsoft = new Vendor();
        microsoft.setName("Microsoft");

        vendorRepository.save(apple);
        vendorRepository.save(ibm);
        vendorRepository.save(microsoft);

        System.out.println("Vendor Data Loaded = "+ vendorRepository.count());
    }
}
