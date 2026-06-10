package com.transport.tms.load.interfaces.rest;

import com.transport.security.SecurityUtils;
import com.transport.tms.load.application.CreateLoadUseCase;
import com.transport.tms.load.application.service.GetAllLoadsUseCase;
import com.transport.tms.load.application.service.GetLoadByIdUseCase;
import com.transport.tms.load.application.service.GetMyLoadsUseCase;
import com.transport.tms.load.interfaces.rest.request.CreateLoadRequest;
import com.transport.tms.load.interfaces.rest.response.LoadResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/loads")
@RequiredArgsConstructor
public class LoadController {

    private final CreateLoadUseCase createLoadUseCase;

    private final GetAllLoadsUseCase getAllLoadsUseCase;

    private final GetLoadByIdUseCase getLoadByIdUseCase;

    private final GetMyLoadsUseCase getMyLoadsUseCase;

    @GetMapping("/my-loads")
    public ResponseEntity<List<LoadResponse>> getMyLoads(){
        return ResponseEntity.ok(
                getMyLoadsUseCase.getMyLoads()
        );
    }

    @GetMapping("/{loadId}")
    public ResponseEntity<LoadResponse> getLoadById(@PathVariable UUID loadId){
        return ResponseEntity.ok(
                getLoadByIdUseCase.getLoadById(loadId)
        );
    }

    @GetMapping
    public ResponseEntity<List<LoadResponse>> getAllLoads(){
        return ResponseEntity.ok(
                getAllLoadsUseCase.getAllLoads()
        );
    }

    @PostMapping
    public ResponseEntity<LoadResponse> createLoad(@RequestBody CreateLoadRequest request){
        UUID shipperId = SecurityUtils.getCurrentUserId();
        System.out.println(SecurityUtils.getCurrentUserId());
        System.out.println("Create Load API Called");

        return ResponseEntity.ok(
                createLoadUseCase.create(request, shipperId));
    }
}
