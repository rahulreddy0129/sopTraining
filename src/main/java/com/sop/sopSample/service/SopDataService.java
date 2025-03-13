package com.sop.sopSample.service;

import com.sop.sopSample.exception.SopException;
import com.sop.sopSample.model.Status;
import com.sop.sopSample.model.TmType;
import com.sop.sopSample.model.Training;
import com.sop.sopSample.model.TrainingCategory;
import com.sop.sopSample.repository.StatusRepository;
import com.sop.sopSample.repository.TmTYpeRepository;
import com.sop.sopSample.repository.TrainingCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;

public class SopDataService {

    @Autowired
    private TmTYpeRepository tmTypeRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private TrainingCategoryRepository trainingCategoryRepository;

    public TmType getTmTypeId(Long id) {
        return tmTypeRepository.findById(id).orElseThrow(() ->
                new SopException("Tm Type not available for given ID:" + id));
    }

    public Status getStatusName(String name) {
        return statusRepository.findByName(name);
    }

    public TrainingCategory getTrainingCategoryByName(String catgName) {
        return trainingCategoryRepository.findByName(catgName);
    }





//    WEBCLIENT

    public ResponseEntity<Object> getProductStoreDetailsById(Long id) {

        return null;
    }

//    public ResponseEntity<Object> getProductStoreDetailsById(Long id) {
//        try {
//            Mono<ResponseEntity<Object>> response = webClient
//                    .get()
//                    .uri(WebClientConstants.MASTER_GET_PRODUCT_STORE_DETAILS_BY_ID + id)
//                    .headers(h -> h.setBearerAuth(getToken()))
//                    .retrieve()
//                    .toEntity(new ParameterizedTypeReference<Object>() {});
//            return response.block();
//        } catch (WebClientResponseException re) {
//            log.error("Error response code is {} and error response body is {}", re.getRawStatusCode(), re.getResponseBodyAsString());
//            throw re;
//        } catch (Exception e) {
//            log.error("Error in getUserByLogin" + e);
//            throw e;
//        }
//    }
}
