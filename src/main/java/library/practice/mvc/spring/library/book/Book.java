package library.practice.mvc.spring.library.book;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    private long id;
    private String title;
    private String author;
    private Integer totalPages;
    private double rent;



}
