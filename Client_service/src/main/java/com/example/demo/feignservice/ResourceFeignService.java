package com.example.demo.feignservice;

import com.example.demo.dto.ApplianceUserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "household-service")
@Service
public interface ResourceFeignService {
    @PostMapping("/appliance/saveOrUpdate")
    ApplianceUserDto save(@RequestBody ApplianceUserDto applianceUserDto);

    @GetMapping("/appliance/getById/{id}")
    ApplianceUserDto getById(@PathVariable Integer id);

    @GetMapping("/appliance/getByName/{applianceName}")
    List<ApplianceUserDto> getByApplianceName(@PathVariable String name);


      @DeleteMapping("/appliance/deleteById/{id}")
      Map<String, Boolean> deleteById(@PathVariable Integer id);

}
