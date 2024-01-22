package com.tobeto.spring.b.services.concretes;

import com.tobeto.spring.b.entities.Brand;
import com.tobeto.spring.b.repositories.BrandRepository;
import com.tobeto.spring.b.services.abstracts.BrandService;
import com.tobeto.spring.b.services.dtos.requests.brand.AddBrandRequest;
import com.tobeto.spring.b.services.dtos.requests.brand.UpdateBrandRequest;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandListResponse;
import com.tobeto.spring.b.services.dtos.responses.brand.GetBrandResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {
    private final BrandRepository brandRepository;

    @Override
    public List<GetBrandListResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetBrandListResponse> responseList = new ArrayList<>();

        for (Brand brand : brands) {
            GetBrandListResponse response = new GetBrandListResponse();
            response.setId(brand.getId());
            response.setName(brand.getName());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public GetBrandResponse getById(int id) {
        Brand brand = brandRepository.findById(id).orElseThrow();

        GetBrandResponse response = new GetBrandResponse();
        response.setName(brand.getName());

        return response;
    }

    @Override
    public void add(AddBrandRequest request) {
        Brand brand = new Brand();
        brand.setName(request.getName());

        brandRepository.save(brand);
    }

    @Override
    public void update(int id, UpdateBrandRequest updateBrandRequest) {
        Brand brand = new Brand();
        brandRepository.findById(brand.getId()).orElseThrow();
        brand.setId(updateBrandRequest.getId());
        brand.setName(updateBrandRequest.getName());

        brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        Brand brandToDelete = brandRepository.findById(id).orElseThrow();
        brandRepository.delete(brandToDelete);
    }
}
