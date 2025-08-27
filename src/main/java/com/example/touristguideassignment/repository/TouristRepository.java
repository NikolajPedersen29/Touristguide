package com.example.touristguideassignment.repository;

import com.example.touristguideassignment.models.TouristAttraction;
import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> attractions = new ArrayList<>();

    public TouristRepository() {
        attractions.add(new TouristAttraction( "Tivoli", "Forlystelsespark i København"));
        attractions.add(new TouristAttraction( "Den Lille Havfrue", "Berømt statue ved havnen"));
    }

    public List<TouristAttraction> getAllAttractions() {
        return attractions;
    }


    // Create
    public TouristAttraction addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
        return attraction;
    }

    // READ
    public TouristAttraction findByName(String name) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }
    // Update
    public TouristAttraction updateAttraction(String name, String newName, String newDescription) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                attraction.setName(newName);
                attraction.setDescription(newDescription);
                return attraction;
            }
        }
        return null;
    }

    //Delete
    public TouristAttraction deleteAttraction(String name) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                attractions.remove(attraction);
                return attraction;
            }
        }
    return null;
    }
}