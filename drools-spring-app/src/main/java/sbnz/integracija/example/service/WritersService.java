package sbnz.integracija.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import demo.facts.Writer;
import lombok.AllArgsConstructor;
import sbnz.integracija.example.dto.WriterDto;
import sbnz.integracija.example.repository.WritersRepository;

@Service
@AllArgsConstructor
public class WritersService {
    
    private final WritersRepository writersRepository;

    public List<Writer> getAll() {
        return writersRepository.findAll();
    }

    public List<WriterDto> getAllWriterDtos() {
        List<Writer> writers = getAll();
        return genresToGenresDto(writers);
    }

    private List<WriterDto> genresToGenresDto(List<Writer> genres) {
        List<WriterDto> writerDtos = new ArrayList<>();
                genres.stream().forEach(writer -> { 
                WriterDto dto = new WriterDto(writer);
                writerDtos.add(dto);
            });
        return writerDtos;
    }
}
