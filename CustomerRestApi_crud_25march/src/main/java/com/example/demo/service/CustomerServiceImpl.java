package com.example.demo.service;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.model.CustomerModel;
import org.modelmapper.ModelMapper;
import com.example.demo.dto.CustomerDto;
import com.example.demo.repo.CustomerRepository;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{
    private CustomerRepository customerRepository;
    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        super();
        this.customerRepository=customerRepository;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
       ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerModel model=mapper.map(customerDto,CustomerModel.class);
        customerRepository.save(model);
        CustomerDto dto=mapper.map(model,CustomerDto.class);
        return dto;
    }

    @Override
    public CustomerDto findByCustomerId(String customerId) {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerModel model=customerRepository.findByCustomerId(customerId);
        if(model==null)
        {            throw new CustomerNotFoundException("no employee found with the given id: "+customerId);

        }
        CustomerDto dto=modelMapper.map(model, CustomerDto.class);
        return dto;
    }



    @Override
    public CustomerDto findByEmail(String email) {
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerModel model=customerRepository.findByEmail(email);
        System.out.println(model);

        return (mapper.map(model,CustomerDto.class));

    }

    @Override
    public Integer deleteByCustomerId(String customerId) {
        return customerRepository.deleteByCustomerId(customerId);

    }

    @Override
    public CustomerDto updateCustomer(String customerId, CustomerDto customerDto) {
        CustomerModel customerModel=customerRepository.findByCustomerId(customerId);
        if(customerModel==null)
        {
            throw new CustomerNotFoundException("no such account found");
        }
        ModelMapper mapper=new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        CustomerModel model=mapper.map(customerDto, CustomerModel.class);
        customerModel.setFirstName(model.getFirstName());
        customerModel.setLastName(model.getLastName());
        customerModel.setEmail(model.getEmail());
        customerRepository.save(customerModel);
        CustomerDto custDto=mapper.map(customerModel, CustomerDto.class);
        return custDto;
    }
}
