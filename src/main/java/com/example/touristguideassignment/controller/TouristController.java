package com.example.touristguideassignment.controller;


import com.example.touristguideassignment.models.TouristAttraction;
import com.example.touristguideassignment.service.TouristService;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private final TouristService touristService;
    private TouristService service;

    public TouristController(TouristService service, TouristService touristService) {
        this.service = service;
        this.touristService = touristService;
    }

    //Find alle attraktioner
    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
        List<TouristAttraction> touristAttractions = touristService.getAllAttractions();
        return new ResponseEntity<>(touristAttractions, HttpStatus.OK);
    }

    //Find bestemt attraktion
    @GetMapping("{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction touristAttraction = touristService.getAttractionByName(name);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    // Add Attraction
    @PostMapping("add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction touristAttraction) {
        touristService.addAttraction(touristAttraction);
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);

    }

    //update attraction
    @PostMapping("/update")
    public ResponseEntity<TouristAttraction> updateAttraction(@RequestBody TouristAttraction attraction, @RequestParam String name) {
        TouristAttraction updatedAttraction = touristService.updateAttraction(name, attraction.getName(), attraction.getDescription());
        if (updatedAttraction != null) {
            return new ResponseEntity<>(updatedAttraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    // Delete bestemt attraktion
    @PostMapping("/delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name) {
        TouristAttraction deletedAttraction = service.deleteAttraction(name);
        if (deletedAttraction != null) {
            return new ResponseEntity<>(deletedAttraction, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
}
