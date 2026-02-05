package com.diaries.library.controller;

import com.diaries.library.dto.BookDto;
import com.diaries.library.dto.CreateBookRequestDto;
import com.diaries.library.dto.UpdateBookRequestDto;
import com.diaries.library.entity.BookEntity;
import com.diaries.library.repository.BookRepository;
import com.diaries.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    //dependency Injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    //public BookEntity createBook(String title, String author, String isbn)->here these parameters can grow over time and impact exponentially we take insatnce of class createbook
    public BookDto createBook(@Valid @RequestBody CreateBookRequestDto requestDto){

        return bookService.createBook(requestDto);
    }
    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable Long id){
        return bookService.getBook(id);
    }
    @GetMapping
    public Page<BookDto> getBooks(Pageable pageable){
        return bookService.getBooks(pageable);
    }
    //implement update functionality
    @PutMapping("/{id}")
    public BookDto updateBook(@PathVariable Long id,
                                   @Valid @RequestBody UpdateBookRequestDto requestDto){
        return bookService.updateBook(id,requestDto);
    }
    //implement delete functionality
    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id){
        bookService.deleteBookById(id);
    }
}
