package com.sop.sopSample.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sop.sopSample.DTO.SopDTO;
import com.sop.sopSample.service.TmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class TmResource {

    private TmService tmService;

    @PostMapping("/sop/create")
    public ResponseEntity<Object> createSopTraining(
            @RequestParam("file") MultipartFile file,
            @RequestParam("submitValue") String submitValue
            ) {
        try {
            ObjectMapper mapper =new ObjectMapper();
            SopDTO sopData = mapper.readValue(submitValue, SopDTO.class);

            return ResponseEntity.ok(tmService.createSop(sopData, file));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create SOP Training");
        }
    }
}
