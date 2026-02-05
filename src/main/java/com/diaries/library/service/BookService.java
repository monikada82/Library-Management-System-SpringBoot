package com.diaries.library.service;

import com.diaries.library.advice.exception.NoSuchBookException;
import com.diaries.library.dto.BookDto;
import com.diaries.library.dto.CreateBookRequestDto;
import com.diaries.library.dto.UpdateBookRequestDto;
import com.diaries.library.entity.BookEntity;
import com.diaries.library.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



    public BookDto createBook(CreateBookRequestDto requestDto){
        BookEntity bookEntity=new BookEntity();
        bookEntity.setTitle(requestDto.getTitle());
        bookEntity.setAuthor(requestDto.getAuthor());
        bookEntity.setIsbn(requestDto.getIsbn());
        return toDto(bookRepository.save(bookEntity));
    }

    public BookDto getBook(Long id) {
        return bookRepository.findById(id)
                .map(this::toDto)
                .orElseThrow(()->new NoSuchBookException(id));
//        Optional<BookEntity>optionalBookEntity= bookRepository.findById(id);
//        if(optionalBookEntity.isEmpty()){
//            throw new RuntimeException("Book not found");
//        }
//        return optionalBookEntity.get();

    }
    public Page<BookDto> getBooks(Pageable pageable) {
        //return bookRepository.findAll(PageRequest.of(0,5));
        return bookRepository.findAll(pageable)
                .map(this::toDto);
    }

    public void deleteBookById(Long id) {
     bookRepository.deleteById(id);
    }

    public BookDto updateBook(Long id, UpdateBookRequestDto requestDto) {
        BookEntity bookEntity=bookRepository.findById(id)
                .orElseThrow(()->new NoSuchBookException(id));
        // use requestDto to set fields
        bookEntity.setTitle(requestDto.getTitle());
        bookEntity.setAuthor(requestDto.getAuthor());
        bookEntity.setIsbn(requestDto.getIsbn());
        return toDto(bookRepository.save(bookEntity));
    }
    private BookDto toDto(BookEntity bookEntity){
        BookDto dto=new BookDto();
        dto.setTitle(bookEntity.getTitle());
        dto.setAuthor(bookEntity.getAuthor());
        return dto;
    }
}
