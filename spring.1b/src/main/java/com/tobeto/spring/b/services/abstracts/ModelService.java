package com.tobeto.spring.b.services.abstracts;

import com.tobeto.spring.b.services.dtos.requests.model.AddModelRequest;
import com.tobeto.spring.b.services.dtos.requests.model.UpdateModelRequest;
import com.tobeto.spring.b.services.dtos.responses.model.GetModelListResponse;
import com.tobeto.spring.b.services.dtos.responses.model.GetModelResponse;

import java.util.List;

public interface ModelService {
    List<GetModelListResponse> getAll();
    GetModelResponse getById(int id);
    void add(AddModelRequest request);
    void update(UpdateModelRequest updateModelRequest);
    void delete(int id);

}
