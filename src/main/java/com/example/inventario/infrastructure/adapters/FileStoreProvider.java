package com.example.inventario.infrastructure.adapters;

import com.example.inventario.application.dto.StoreDto;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FileStoreProvider {

    private final List<StoreDto> stores = new ArrayList<>();

    public FileStoreProvider() {
        try {
            ClassPathResource resource = new ClassPathResource("stores.txt");
            try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8))) {
                String line;
                while ((line = br.readLine()) != null) {
                    line = line.trim();
                    if (line.isEmpty() || line.startsWith("#")) continue;
                    String[] parts = line.split("\\|", 2);
                    if (parts.length == 2) {
                        try {
                            Long id = Long.parseLong(parts[0].trim());
                            String name = parts[1].trim();
                            stores.add(new StoreDto(id, name));
                        } catch (NumberFormatException ignored) {
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public List<StoreDto> findAll() {
        return new ArrayList<>(stores);
    }

    public Optional<StoreDto> findById(Long id) {
        return stores.stream().filter(s -> s.getId().equals(id)).findFirst();
    }
}
