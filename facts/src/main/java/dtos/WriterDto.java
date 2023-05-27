package dtos;

import demo.facts.Writer;
import lombok.Data;

@Data
public class WriterDto {
    private Long id;
    private String name; 
    private String surname;


    public WriterDto(Writer writer){
        this.id = writer.getId();
        this.name = writer.getName();
        this.surname = writer.getSurname();

    }
}
