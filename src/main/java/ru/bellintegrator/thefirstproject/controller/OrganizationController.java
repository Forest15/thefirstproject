package ru.bellintegrator.thefirstproject.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.thefirstproject.domain.model.*;
import ru.bellintegrator.thefirstproject.domain.model.organization.*;
import ru.bellintegrator.thefirstproject.service.OrganizationService;

import java.util.List;

@RestController
@RequestMapping(path = "api/organization", produces = "application/json")
public class OrganizationController {

    private final OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService){
        this.organizationService = organizationService;
    }

    @PostMapping(value = "/list")
    @ApiOperation(value = "Request the organization list with filter", tags = "Organization")
    public List<OrganizationBaseModel> getOrgList(@RequestBody OrganizationRequestModel orgRequestModel){
        return organizationService.getOrgList(orgRequestModel);
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Get organization card by id", tags = "Organization")
    public OrganizationFullModel getOrgById(@PathVariable("id") Long id) {
        return organizationService.getOrgById(id);
    }

    @PutMapping(value = "/update")
    @ApiOperation(value = "The update of the organization details", tags = "Organization")
    public ResponseModel updateOrganization(@RequestBody OrganizationFullModel orgUpdatingModel){
        return organizationService.updateOrganization(orgUpdatingModel);
    }

    @PostMapping(value = "/save")
    @ApiOperation(value = "The creation of the organization", tags = "Organization")
    public ResponseModel createOrganization(@RequestBody OrganizationCreatingModel organizationCreatingModel){
        return organizationService.createOrganization(organizationCreatingModel);
    }
}