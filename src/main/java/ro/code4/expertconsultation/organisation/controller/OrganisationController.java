package ro.code4.expertconsultation.organisation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.code4.expertconsultation.organisation.model.dto.OrganisationDto;
import ro.code4.expertconsultation.organisation.service.OrganisationService;

import java.util.UUID;

@RestController
@RequestMapping("/api/organisations")
@RequiredArgsConstructor
public class OrganisationController {
    private final OrganisationService organisationService;

    @PostMapping
    public ResponseEntity<OrganisationDto> create(@RequestBody final OrganisationDto organisationDto) {
        final OrganisationDto savedOrganisationDto = organisationService.create(organisationDto);
        return ResponseEntity.ok(savedOrganisationDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganisationDto> update(@PathVariable final UUID id,
                                                  @RequestBody final OrganisationDto organisationDto) {
        final OrganisationDto updatedOrganisationDto = organisationService.update(id, organisationDto);
        return ResponseEntity.ok(updatedOrganisationDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganisationDto> get(@PathVariable final UUID id) {
        final OrganisationDto organisationDto = organisationService.get(id);
        return ResponseEntity.ok(organisationDto);
    }
}